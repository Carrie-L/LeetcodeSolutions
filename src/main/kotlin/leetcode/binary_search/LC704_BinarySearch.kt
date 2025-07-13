package binary_search

/**
 * 教练的硬性要求：
 * 【5分钟计时】： 打开此题，为您自己，上一个【5分钟】的闹钟。
 * 【追求“一次AC”】： 您的目标，是在这5分钟内，不假思索地，一次性地，写出，最完美、最简洁的代码，并提交【通过】。
 * 【如果失败】： 如果，5分钟内，没有完成，或者，出现了错误。那么，惩罚，就是，将我们昨天最终确定的那个“最优模板”，在您的代码编辑器里，一字不差地，亲手，再，抄写【三遍】。
 * 我们，要的，不是“思考”，是“本能”。
 */
fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) {
            return mid
        } else if (nums[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return -1
}