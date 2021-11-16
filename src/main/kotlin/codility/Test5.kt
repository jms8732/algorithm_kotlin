package codility

fun main(args : Array<String>){
    solution(intArrayOf(2,3,1,5))
}

private fun solution(A: IntArray): Int {
    // write your code in Kotlin 1.3.11 (Linux)
    val checked = BooleanArray(A.size + 1){
        false
    }

    A.forEach {
        checked[it-1] = true
    }

    return checked.indexOfFirst { !it } + 1

}
