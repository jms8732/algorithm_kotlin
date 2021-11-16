package codility

import kotlin.math.max

fun main(args : Array<String>){
    println(solution(529))
}

fun solution(N: Int): Int {
    val binary = N.toString(2)
    var ret = 0
    var startIndex = binary.indexOf("1",startIndex = -1)
    while(true){
        val endIndex = binary.indexOf("1",startIndex+1)

        if(endIndex == -1)
            break

        ret = max(ret, endIndex - startIndex -1)
        startIndex = endIndex
    }

    return ret
}