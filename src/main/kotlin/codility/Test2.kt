package codility

fun main(args: Array<String>){
    val array = intArrayOf(3, 8, 9, 7, 6)

    solution(array,3).forEach {
        print("$it ")
    }
}

fun solution(A: IntArray, K: Int): IntArray {
    // write your code in Kotlin 1.3.11 (Linux)
    if(A.isEmpty())
        return intArrayOf()

    val ret = IntArray(A.size)

    val remain = K.rem(A.size)

    for(i in ret.indices){
        ret[(i + remain).rem(ret.size)] = A[i]
    }

    return ret
}