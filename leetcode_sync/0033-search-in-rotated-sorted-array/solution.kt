class Solution {
    fun search(nums: IntArray, target: Int): Int {
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
}
