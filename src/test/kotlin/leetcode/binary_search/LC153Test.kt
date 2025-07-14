package leetcode.binary_search

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LC153Test {

    @Test
    fun findMin() {
        val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        assertEquals(0, LC153.findMin(nums))

    }

    @ParameterizedTest
    @MethodSource("cases")
    fun find_all(nums:IntArray, expected:Int) {
        assertEquals(expected, LC153.findMin(nums))
    }

    companion object {
        @JvmStatic
        fun cases(): Stream<Arguments> = Stream.of(
            Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0),
            Arguments.of(intArrayOf(3, 4, 5, 1, 2), 1),
            Arguments.of(intArrayOf(11, 13, 15, 17), 11)

        )
    }
}