package programmers

import kotlin.math.max

/*
모의 고사
풀이 방법: 브루트 포스
 */

fun main(args: Array<String>) {

}

class Solution3 {
    val p1 = intArrayOf(1, 2, 3, 4, 5)
    val p2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val p3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    fun solution(answers: IntArray): IntArray {
        var a1 = 0
        var a2 = 0
        var a3 = 0
        answers.forEachIndexed { index, i ->
            if (p1[index % p1.size] == i)
                a1++

            if (p2[index % p2.size] == i)
                a2++

            if (p3[index % p3.size] == i)
                a3++
        }

        val i = maxOf(a1, a2, a3)
        val answer = arrayListOf<Int>()

        if (a1 == i)
            answer.add(1)

        if (a2 == i)
            answer.add(2)

        if (a3 == i)
            answer.add(3)


        return answer.toIntArray()
    }
}