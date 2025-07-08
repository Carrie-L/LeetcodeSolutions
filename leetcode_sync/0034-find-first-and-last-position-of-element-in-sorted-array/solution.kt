class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val leftIndex = searchLeftBoundary(nums, target)
        val rightIndex = searchRightBoundary(nums, target)
        return intArrayOf(leftIndex, rightIndex)
    }

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
}
