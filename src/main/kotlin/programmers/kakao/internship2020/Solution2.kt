package programmers.kakao.internship2020

import java.lang.NumberFormatException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.exp
import kotlin.math.max

/*
수식 최대화
풀이 방법: 재귀 + 구현 + combination
 */

fun main(args: Array<String>) {
    val sol = Solution2()

    println(sol.solution("100-200*300-500+20"))
}

class Solution2 {
    fun ArrayList<Char>.swap(fromIndex: Int, toIndex: Int) {
        val temp = this[fromIndex]
        this[fromIndex] = this[toIndex]
        this[toIndex] = temp
    }

    var max = -1L

    fun solution(expression: String): Long {
        val op = arrayListOf<Char>().apply {
            if (expression.contains("*")) add('*')
            if (expression.contains("-")) add('-')
            if (expression.contains("+")) add('+')
        }

        combination(
            depth = 0,
            next = 0,
            expression = expression,
            op = op
        )

        return max
    }

    private fun combination(depth: Int,  next : Int, expression: String, op: ArrayList<Char>) {
        if (depth == op.size) {
            max = max(
                max, abs(split(
                    depth = op.size,
                    expression = expression,
                    op = op
                ))
            )

            return
        }

        for (i in next until op.size) {
            op.swap(i, next)
            combination(
                depth = depth + 1,
                next = i,
                op = op,
                expression = expression
            )
            op.swap(depth, i)
        }
    }

    private fun split(depth: Int, expression: String, op: ArrayList<Char>): Long {
        if (depth == -1)
            return 0

        val dq = ArrayDeque<Long>()

        expression.split(op[depth - 1]).forEach {
            try {
                dq.add(it.toLong())
            } catch (e: NumberFormatException) {
                val result = split(
                    depth = depth - 1,
                    expression = it,
                    op = op
                )
                dq.add(result)
            }
        }

        while (dq.size > 1) {
            val opr1 = dq.pollFirst()
            val opr2 = dq.pollFirst()

            val result = when (op[depth-1]) {
                '+' -> opr1 + opr2
                '-' -> opr1 - opr2
                else -> opr1 * opr2
            }

            dq.addFirst(result)
        }

        return dq.poll()
    }
}