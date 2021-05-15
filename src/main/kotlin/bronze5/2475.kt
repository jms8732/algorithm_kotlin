import kotlin.math.pow

fun main(args: Array<String>) {
    var result = 0.0

    readLine()?.split(" ")?.forEach {
        result += it.toDouble().pow(2)
    }


    println(result.rem(10).toInt())
}