package leetcode.binary_search

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LC33SearchInRotatedSortedArrayTest {

@Test
 fun searchRotatedArray2() {
    val nums = intArrayOf(4,5,6,7,0,1,2,3)
    assertEquals(4, LC33.searchRotatedArray2(nums, 0))
 }

    @Test
     fun notFound(){
         val nums = intArrayOf(4,5,6,7,0,1,2,3)
         assertEquals(-1, LC33.searchRotatedArray2(nums, 8))
     }

    @ParameterizedTest
    @MethodSource("cases")
    fun searchAll(nums:IntArray, target:Int, expected:Int){
        assertEquals(expected, LC33.searchRotatedArray2(nums, target))
    }

     companion object{

         @JvmStatic
         fun cases(): Stream<Arguments> = Stream.of(
             Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2, 3), 0, 4),
             Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2, 3), 8, -1),
             Arguments.of(intArrayOf(1), 0, -1),
             Arguments.of(intArrayOf(1), 1, 0),
             Arguments.of(intArrayOf(3,1), 1, 1)

         )
     }

}