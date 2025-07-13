class Solution {
    fun search(nums: IntArray, target: Int): Int {
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
