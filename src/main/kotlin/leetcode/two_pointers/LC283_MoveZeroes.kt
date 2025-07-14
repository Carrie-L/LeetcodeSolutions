package org.example.leetcode.two_pointers

/**
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
object LC283 {
    fun moveZeroes(nums: IntArray): Unit {
        var slow = 0
        // 如果不是0， slow和fast一起前进；如果是0，slow留下，fast前进。如果slow和fast不相等，说明slow在0的位置，就替换slow位置的元素

        for (fast in nums.indices) {
            if (nums[fast] != 0) {
                if (fast != slow) {
                    nums[slow] = nums[fast]
                    nums[fast] = 0
                }
                slow++
            }
        }

    }

    fun moveZeroes1(nums: IntArray):Unit{
        var slow = 0
        for(fast in nums.indices){
            if(nums[fast]!=0){
                val temp = nums[slow]
                nums[slow] = nums[fast]
                nums[fast] = temp
                slow++
            }
        }
    }
}