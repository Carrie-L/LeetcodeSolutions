package leetcode.binary_search


object LC153 {

    /**
     * [LeetCode 153. 寻找旋转排序数组中的最小值](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/)
     * input: [4,5,6,7,0,1,2]
     * output: 0
     *
     * [11,13,15,17]
     * 11
     *
     * [3,4,5,1,2]
     * 1
     */
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = left + (right - left) / 2

            if (nums[mid] > nums[right]) { // 说明mid在左边序列，要往右边查找最小值
                left = mid + 1
            } else if (nums[mid] < nums[right]) { // 往这个递增序列的左边查最小值
                right = mid
            }
        }
        return nums[left]
    }
}