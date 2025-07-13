package leetcode.binary_search


/**
 * [LeetCode 34 - Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * 声明长度为 2 的整型数组: IntArray[2]
 * intArrayOf(2) : 长度为 1、唯一元素等于 2 的 IntArray
 *
 * 左边界： 找左边，第一个 >=target 的位置；
 * 右边界： 找右边最后一个 <=target 的位置。
 *
 * 分治法：
 *  1. 分解 （ Divide )
 *  2. 解决 （ Conquer )
 *  3. 合并  ( Combine )
 */

fun searchLeftBoundary(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    var boundary = -1

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) { // 找到了一个，但这个数是左边第一个等于target的数吗？并不确定，再往左继续找。
            boundary = mid
            right = mid - 1
        } else if (nums[mid] > target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return boundary
}

fun searchRightBoundary(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    var boundary = -1

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) { // 找到了一个，但这个数是左边第一个等于target的数吗？并不确定，再往左继续找。
            boundary = mid
            left = mid + 1
        } else if (nums[mid] > target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return boundary

}

fun searchRange(nums: IntArray, target: Int): IntArray {
    val leftIndex = searchLeftBoundary(nums, target)
    val rightIndex = searchRightBoundary(nums, target)
    return intArrayOf(leftIndex, rightIndex)
}

fun main() {
    val nums = intArrayOf(5, 7, 7, 8, 8, 10)
    val output = searchRange(nums, 6)
    print("output= ${output.contentToString()}")
}