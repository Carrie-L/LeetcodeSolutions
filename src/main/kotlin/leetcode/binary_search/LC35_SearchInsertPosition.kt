package binary_search


/**
 * O(n)
 */
fun searchInsert0(nums: IntArray, target: Int): Int {
    var slow = 0
    for (fast in nums.indices) {
        if (nums[fast] != target) {
            if (nums[slow] < target) {
                slow++
            }
        }
    }
    return slow
}


fun searchInsert1(nums: IntArray, target: Int): Int {
    var left = 0
    var mid: Int
    var right = nums.size - 1

    while (left < right) {
        mid = left + (right - left) / 2
        if (nums[mid] > target) {
            right = mid
        } else if (nums[mid] < target) {
            left = mid + 1
        } else {
            return mid
        }

    }
    return if (nums[right] < target) left + 1
    else left
}

/**
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * [1,3] , target = 1
 * Output: 1
 *
 */

/**
 * “夹逼”派 / “边界收缩”派
 */
fun searchInsert2(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    var mid = 0
    while (left + 1 < right) {
        mid = left + (right - left) / 2
        if (nums[mid] >= target) {
            right = mid
        } else {
            left = mid
        }
    }

    return if (nums[left] >= target) return left
    else if (nums[right] >= target) return right
    else return nums.size

}

fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2 // int, boolean等基本数据类型存放在栈内存中，在循环内声明对性能没有影响。String等class类型在堆内存中存储，才要放到外面。
        if (nums[mid] == target) return mid
        else if (nums[mid] < target) left = mid + 1
        else if (nums[mid] > target) right = mid - 1
    }
    return left
}

fun main() {
    val nums = intArrayOf(1, 3, 5, 6)
    val target = 0
    val result = searchInsert(nums, target)
    print(result)
}