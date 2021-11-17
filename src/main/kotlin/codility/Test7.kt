package codility


fun main(args : Array<String>){
    println(solution(5, intArrayOf(1,3,1,4,2,3,5,4)))
}

private fun solution(X: Int, A: IntArray): Int {
    // write your code in Kotlin 1.3.11 (Linux)
    var total = 0

    for(i  in 1 .. X){
        total += i
    }

    val checked = BooleanArray(X)

    for(i in A.indices){
        if(!checked[A[i]-1]) {
            checked[A[i] - 1] = true
            total -= A[i]

            if(total == 0)
                return i
        }

    }

    return -1
}