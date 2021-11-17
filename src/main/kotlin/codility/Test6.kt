package codility

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    val temp = intArrayOf(3,1,2,4,3)

    println(solution(temp))
}

private fun solution(A: IntArray): Int {
    // write your code in Kotlin 1.3.11 (Linux)
    val total = A.sum()
    var first = 0
    var ret = Int.MAX_VALUE

    for (i in 1 until A.size) {
        first += A[i-1]
        val second = total - first

        ret = min(ret, abs(second - first))
    }


    return ret
}
