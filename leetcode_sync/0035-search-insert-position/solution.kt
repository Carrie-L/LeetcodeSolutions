class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var mid = 0
        while (left <= right) {
            mid = left + (right - left) / 2
            if (nums[mid] == target) return mid
            else if (nums[mid] < target) left = mid + 1
            else if (nums[mid] > target) right = mid - 1
        }
        return left
    }
}
