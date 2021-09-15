import kotlin.math.sqrt

fun main(args: Array<String>) {
    val sol = Solution2()
    println(sol.solution(10001, 3))
}

class Solution2 {

    fun solution(n: Int, k: Int): Int {
        val string = convert(n, k)
        println("original: $string")

        var ret = 0
        string.split("0").forEach {
            println("num: $it")
            if (it.isNotEmpty())
                if (it.isPrime())
                    ret++
        }

        return ret
    }

    private fun String.isPrime(): Boolean {
        try {
            val number = this.toLong()
            if (number == 1L)
                return false

            for (i in 2 until sqrt(number.toDouble()).toInt() + 1) {
                if (number % i == 0L) {
                    println("This number div : $i")
                    return false
                }
            }
            return true
        }catch(e : Exception){
            return false
        }
    }

    private fun convert(n: Int, k: Int): String {
        return StringBuilder().apply {
            var temp = n

            while (temp / k > 0) {
                val div = temp / k
                val mod = temp % k
                append(mod)
                temp = div
            }

            append(temp)
        }.toString().reversed()
    }
}