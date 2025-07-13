package org.example

import leetcode.array.Solution33
import leetcode.binary_search.Solution

fun main() {
    println("Hello World!")

    val nums = intArrayOf(4,5,6,7,0,1,2)
    println(Solution.searchRotatedArray2(nums, 0))  // 4
    println(Solution33(nums, 0))       // 4  (wrapper 调用)
}