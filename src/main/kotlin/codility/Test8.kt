package codility

fun main(args : Array<String>){
    println(solution(intArrayOf(10,5,6,7,8,4,3,2,1,9)))
}

private fun solution(A: IntArray): Int {
    // write your code in Kotlin 1.3.11 (Linux)
    val big = A.maxOrNull()

    if(big == A.size){
        A.sort()
        var target = 1
        for(i in A){
            if(i != target){
                return 0
            }
            target++
        }

        return 1
    }

    return 0
}
