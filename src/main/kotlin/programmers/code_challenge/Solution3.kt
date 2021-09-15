package programmers.code_challenge

import java.lang.Math.pow


/*
3진법 뒤집기
풀이 방법: 코틀린 extension
 */
class Solution3 {
    fun solution(n: Int): Int {
        return n.changeNotation().foldRightIndexed(0){index, c, total ->
            total + (c-'0') * pow(3.0, index.toDouble()).toInt()
        }
    }

    private fun Int.changeNotation() : String{
        var num = this
        return StringBuilder().apply {
            while (num / 3 > 0) {
                val div = num / 3
                val mod = num % 3

                this.append(mod)
                num = div
            }

            this.append(num)
        }.toString().reversed()
    }
}