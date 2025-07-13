#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Scan Kotlin solution files, aggregate by topic & difficulty,
then replace README placeholders.

README must contain:
<!-- PROBLEMS:START --> ... <!-- PROBLEMS:END -->
<!-- STATS:START --> ... <!-- STATS:END -->
"""

from pathlib import Path
import re, sys
import requests, json, os

ROOT = Path(__file__).resolve().parents[1]
SRC  = ROOT / "src" / "main" / "kotlin" / "leetcode"

FILE_PATTERN = re.compile(r"LC(\d+)_([A-Za-z0-9]+)\.kt$",
                          re.IGNORECASE)
DIFF_PATTERN = re.compile(r"//\s*Difficulty:\s*(Easy|Medium|Hard)",
                          re.IGNORECASE)

SESSION = os.getenv("LEET_SESSION")   # secrets.LEET_SESSION
CSRF    = os.getenv("LEET_CSRF")      # secrets.LEET_CSRF

HEADERS = {
    "Content-Type": "application/json",
    "Cookie": f"LEETCODE_SESSION={SESSION}; csrftoken={CSRF};",
    "x-csrftoken": CSRF,
    "Referer": "https://leetcode.com",
    "User-Agent": "Mozilla/5.0 (+GitHubActions)"
}

def fetch_difficulty(slug: str) -> str:
    query = """
    query questionData($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        difficulty
      }
    }
    """
    payload = {"query": query, "variables": {"titleSlug": slug}}
    r = requests.post("https://leetcode.com/graphql",
                      headers=HEADERS,
                      data=json.dumps(payload),
                      timeout=10)
    r.raise_for_status()
    diff = r.json()["data"]["question"]["difficulty"]
    return diff.capitalize()      # "Easy" / "Medium" / "Hard"


def scan():
    table = []                        # [(no, title, topic, diff, rel_path)]
    for path in SRC.rglob("LC*_*.kt"):
        m = FILE_PATTERN.search(path.name)
        if not m:
            continue
        no, title = int(m[1]), m[2]
        topic = path.parent.name      # binary_search / array ...
        diff = "Unknown"
        # 读取前 30 行找难度注释
        with path.open(encoding="utf-8") as f:
            for _ in range(30):
                line = f.readline()
                if not line: break
                dm = DIFF_PATTERN.search(line)
                if dm:
                    diff = dm[1].capitalize()
                    break
        rel = path.relative_to(ROOT).as_posix()
        table.append((no, title, topic, diff, rel))
    return sorted(table, key=lambda t: t[0])


def render_problem_table(rows):
    buf = ["| 题号 | 标题 | 主题 | 难度 | 源码 |",
           "| ---- | ---- | ---- | ---- | ---- |"]
    for no, title, topic, diff, rel in rows:
        buf.append(f"| {no} | {title} | {topic} | {diff} | [Link]({rel}) |")
    return "\n".join(buf)

def render_stats(rows):
    total = len(rows)
    diff_cnt = {"Easy":0, "Medium":0, "Hard":0, "Unknown":0}
    for *_, diff, _ in rows:
        diff_cnt[diff] += 1
    return (f"已收录 **{total}** 题： "
            f"Easy {diff_cnt['Easy']}・"
            f"Medium {diff_cnt['Medium']}・"
            f"Hard {diff_cnt['Hard']}")

def replace_block(text, start, end, new_block):
    pattern = re.compile(
        rf"({start})(.*?)({end})", re.S)
    return pattern.sub(rf"\1\n{new_block}\n\3", text)

def main():
    rows = scan()
    if diff == "Unknown": # 若没找到注释就远程抓
        slug = title.lower().replace('_', '-')
        try:
            rows = fetch_difficulty(slug)
        except Exception:
            pass
    print(fetch_difficulty(rows))
    
    table_md = render_problem_table(rows)
    stats_md = render_stats(rows)
    readme = ROOT / "README.md"
    content = readme.read_text(encoding="utf-8")
    content = replace_block(content, r"<!-- PROBLEMS:START -->",
                            r"<!-- PROBLEMS:END -->", table_md)
    content = replace_block(content, r"<!-- STATS:START -->",
                            r"<!-- STATS:END -->", stats_md)
    if content != readme.read_text(encoding="utf-8"):
        readme.write_text(content, encoding="utf-8")
        print("README updated ✅")
        sys.exit(1)                    # 非 0 → GitHub Actions 后续 commit
    print("README up-to-date ✨")

if __name__ == "__main__":
    main()
