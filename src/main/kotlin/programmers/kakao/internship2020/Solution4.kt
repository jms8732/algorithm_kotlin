package programmers.kakao.internship2020

import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.min

/*
경주로 건설
풀이 방법: 다익스트라를 이용한 최소 비용 구하기

 */
fun main(args: Array<String>) {
    val sol = Solution4()

    println(
        sol.solution(
            arrayOf(
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 1),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 0, 0, 0, 1),
                intArrayOf(0, 0, 1, 0, 0, 0, 1, 0),
                intArrayOf(0, 1, 0, 0, 0, 1, 0, 0),
                intArrayOf(1, 0, 0, 0, 0, 0, 0, 0)
            )
        )
    )
}

class Solution4 {
    fun solution(board: Array<IntArray>): Int {
        val pq = PriorityQueue<Node>(Comparator<Node> { o1, o2 ->
            o1.cost.compareTo(o2.cost)
        }).apply {
            for (i in 0 until 4) {
                add(Node(0, 0, 0, i))
            }
        }

        val cost = Array(4){
            Array(board.size){
                IntArray(board.size){
                    Int.MAX_VALUE
                }
            }
        }

        val ud = arrayOf(1, 0, -1, 0)
        val rl = arrayOf(0, 1, 0, -1)
        while (!pq.isEmpty()) {
            val cur = pq.poll()

            for (i in ud.indices) {
                val nx = cur.x + ud[i]
                val ny = cur.y + rl[i]

                //뒤로 돌아가는 경우
                if(abs(cur.dir - i) == 2)
                    continue

                if (nx < 0 || nx >= board.size || ny < 0 || ny >= board[0].size || board[nx][ny] == 1)
                    continue

                if(cost[i][nx][ny] > cur.cost + cost(cur.dir,i)) {
                    cost[i][nx][ny] = cur.cost + cost(cur.dir,i)
                    pq.add(
                        Node(
                            x = nx,
                            y = ny,
                            cost = cur.cost + cost(cur.dir, i),
                            dir = i
                        )
                    )
                }
            }
        }

        var min = Int.MAX_VALUE
        for(i in cost.indices){
            min = min(min,cost[i][board.lastIndex][board.lastIndex])
        }

        return min
    }

    private fun cost(preDir : Int , curDir : Int) : Int{
        return when(preDir){
            0, 2-> {
                if(curDir == 1 || curDir == 3) 600
                else  100
            }
            else -> {
                if(curDir == 0 || curDir == 2) 600
                else 100
            }
        }
    }

    data class Node(
        val x: Int,
        val y: Int,
        val cost: Int,
        val dir: Int
    )
}