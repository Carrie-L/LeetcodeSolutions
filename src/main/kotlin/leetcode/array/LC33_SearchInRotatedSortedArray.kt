package leetcode.array

import leetcode.binary_search.Solution as BS

/** Re-export LC33 under the 'array' topic */
object Solution33 : (IntArray, Int) -> Int {
    override fun invoke(nums: IntArray, target: Int) = BS.searchRotatedArray2(nums, target)
}
