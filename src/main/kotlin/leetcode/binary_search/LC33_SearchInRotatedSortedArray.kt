package leetcode.binary_search

/**
 * [Leetcode 33](https://leetcode.com/problems/search-in-rotated-sorted-array/)
 *
 * 给你一个 先升序排好，然后在某个未知位置整体“旋转”过一次 的整型数组 nums，以及一个整数 target。
 * 请你在 O(log n) 的时间复杂度内找到 target 的下标；如果找不到，返回 -1。
 *
 * [4,5,6,7,0,1,2,3] target=0
 */

object LC33 {
    fun searchRotatedArray(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (nums[mid] >= nums[high]) {  // 说明 mid 在左边序列
                if (nums[low] > target) { // 完全不在左边序列
                    low = mid + 1
                } else {
                    if (nums[mid] == target) return mid
                    else if (nums[mid] > target) {
                        high = mid - 1
                    } else {
                        low = mid + 1
                    }
                }
            } else if (nums[mid] < nums[high]) { // 说明 mid 在右边序列
                if (nums[high] < target) high = mid - 1
                else {
                    if (nums[mid] == target) return mid
                    else if (nums[mid] < target) {
                        low = mid + 1
                    } else {
                        high = mid - 1
                    }
                }
            }
        }
        return -1
    }

    /**
     * 优化暴力解法的代码
     */
    fun searchRotatedArray1(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (nums[mid] == target) return mid

            if (nums[mid] >= nums[high]) {  // 说明 mid 在左边序列
                if (nums[low] > target || nums[mid] < target) { // 完全不在左边序列
                    low = mid + 1
                } else {
                    high = mid - 1
                }
            } else if (nums[mid] < nums[high]) { // 说明 mid 在右边序列
                if (nums[high] < target || nums[mid] > target) high = mid - 1
                else {
                    low = mid + 1
                }
            }
        }
        return -1
    }

    /**
     * 更优雅的写法
     * [4,5,6,7,0,1,2,3] target=0
     */
    fun searchRotatedArray2(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.lastIndex
        while (low <= high) {
            val mid = low + high ushr 1
            if (nums[mid] == target) return mid
            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) high = mid - 1 else low = mid + 1
            } else {
                if (target > nums[mid] && target <= nums[high]) low = mid + 1 else high = mid - 1
            }
        }
        return -1
    }
}
