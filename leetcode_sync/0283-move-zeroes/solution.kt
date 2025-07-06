class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var slow = 0
        // 将保留对象往前填充，末尾填充0
        for (fast in nums.indices) {
            if (nums[fast] != 0) {
                if(fast != slow){
                    nums[slow] = nums[fast]
                    nums[fast] = 0  
                }
                slow++
            }
        }

       
    }
}
