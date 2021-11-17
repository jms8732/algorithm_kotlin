package codility

import kotlin.math.max

fun main(args: Array<String>) {
    solution(5, intArrayOf(3, 4, 4, 6, 1, 4, 4)).forEach {
        print("$it ")
    }
}

private fun solution(N: Int, A: IntArray): IntArray {
    // write your code in Kotlin 1.3.11 (Linux)
    val ret = IntArray(N) {
        0
    }

    var max = 0
    var cachedMax = 0
    for (i in A) {
        if (i in 1..N) {
            if (ret[i - 1] < cachedMax)
                ret[i - 1] = cachedMax + 1
            else
                ret[i - 1] += 1

            max = max(max, ret[i - 1])
        } else
            cachedMax = max
    }

    for(i in ret.indices){
        if(ret[i] < cachedMax)
            ret[i] = cachedMax
    }

    return ret
}
