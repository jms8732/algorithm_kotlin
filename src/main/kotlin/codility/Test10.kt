package codility

import kotlin.math.abs

fun main(args: Array<String>) {
    println(solution(intArrayOf(1, 3, 6, 4, 1, 2)))
}

private fun solution(A: IntArray): Int {
    // write your code in Kotlin 1.3.11 (Linux)
    A.sort()

    var rank = 1
    for(i in A){
        if(i >= 1){
            if(rank == i)
                rank++
        }
    }

    return rank
}
