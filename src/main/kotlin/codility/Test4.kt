package codility

fun main(args: Array<String>) {

}

fun solution(X: Int, Y: Int, D: Int): Int {
    // write your code in Kotlin 1.3.11 (Linux)
    val div = (Y - X).div(D)
    val mod = (Y - X).rem(D)


    return div + when (mod) {
        0 -> 0
        else -> 1
    }
}