package programmers.kakao.winter_internship2019

import java.util.*


/*
크레인 인형뽑기 게임
풀이 방법: 구현 + stack
 */
fun main(args : Array<String>){
    val sol = Solution()

    println(sol.solution(arrayOf(
        intArrayOf(0,0,0,0,0),
        intArrayOf(0,0,1,0,3),
        intArrayOf(0,2,5,0,1),
        intArrayOf(4,2,4,4,2),
        intArrayOf(3,5,1,3,1)
    ), intArrayOf(1,5,3,5,1,2,1,4)))
}

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val stack = Stack<Int>()
        var ret = 0

        moves.forEach {
            val dollNum = moveDown(it-1, board)

            if(stack.isNotEmpty() && dollNum != 0 && stack.peek() == dollNum){
                stack.pop()
                ret += 2
            }else{
                stack.push(dollNum)
            }
        }

        return ret
    }

    private fun moveDown(y : Int, board : Array<IntArray>) : Int{
        for(it in board){
            if(it[y] != 0) { //인형이 존재하는 경우
                val ret = it[y]
                it[y] = 0
                return ret
            }
        }
        return 0
    }
}