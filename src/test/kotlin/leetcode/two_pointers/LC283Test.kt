package leetcode.two_pointers

import org.example.leetcode.two_pointers.LC283
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LC283Test {

    @Test
    fun moveZeroes() {
//        val nums = intArrayOf(0, 1, 0, 3, 12)
//        val expected = intArrayOf(1, 3, 12, 0, 0)

        val nums = intArrayOf(0)
        val expected = intArrayOf(0)

        LC283.moveZeroes(nums)
        assertArrayEquals(expected, nums)
    }

    /**
     * ` ` 可读性极高、具有自解释性的单元测试
     * 这种像自然语言一样的方法名，只建议在测试种使用，正式代码还是驼峰命名。
     */

    @ParameterizedTest(name = "Case {index}: input=`{0}`, expected=`{1}`")
    @MethodSource("cases")
    fun  `test moveZeros with various cases` (input:IntArray, output: IntArray){
        // 执行待测方法
        LC283.moveZeroes(input)
        LC283.moveZeroes1(input)

        // 断言结果是否与预期相符
        assertArrayEquals(output, input)
    }

    companion object{

        @JvmStatic
        fun cases():Stream<Arguments> = Stream.of(
            // --- 常规情况 ---
            Arguments.of(intArrayOf(0, 1, 0, 3, 12), intArrayOf(1, 3, 12, 0, 0)),

            // --- 边界情况 ---
            Arguments.of(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)),        // 全是零
            Arguments.of(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3)),        // 没有零
            Arguments.of(intArrayOf(0, 0, 1, 2), intArrayOf(1, 2, 0, 0)),  // 零在开头
            Arguments.of(intArrayOf(1, 2, 0, 0), intArrayOf(1, 2, 0, 0)),  // 零在末尾

            // --- 特殊情况 ---
            Arguments.of(intArrayOf(), intArrayOf()),                      // 空数组
            Arguments.of(intArrayOf(0), intArrayOf(0)),                      // 单个零
            Arguments.of(intArrayOf(5), intArrayOf(5))
        )
    }
}