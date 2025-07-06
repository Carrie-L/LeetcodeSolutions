class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var low = 0
        for(fast in nums.indices){
            if(`val` != nums[fast]){ // 不相等，慢指针往前移动
                nums[low] = nums[fast]
                low++
            }
        }
        return low
    }
}
