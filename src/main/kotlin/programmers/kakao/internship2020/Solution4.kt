package programmers.kakao.internship2020

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

fun main(args: Array<String>) {
    val sol = Solution4()

    println(
        sol.solution(
            arrayOf(
                intArrayOf(0, 0, 1, 0),
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 1, 0, 1),
                intArrayOf(1, 0, 0, 0)
            )
        )
    )
}

class Solution4 {
    fun solution(board: Array<IntArray>): Int {
        val visited = Array(2) {
            Array(board.size) {
                BooleanArray(board[it].size)
            }
        }.apply {
            this[0][0][0] = true
            this[1][0][0] = true
        }

        val cost = arrayListOf<IntArray>().apply {
            for (i in board.indices) {
                add(IntArray(board[i].size) {
                    Int.MAX_VALUE
                })
            }
        }.apply {
            this[0][0] = 0
        }

        return bfs(board, visited, cost)
    }

    private fun bfs(board: Array<IntArray>, visited: Array<Array<BooleanArray>>, cost: ArrayList<IntArray>): Int {
        val q = LinkedList<Point>().apply {
            add(Point(0, 0, 0))
            add(Point(0, 0, 1))
        }

        val ud = arrayOf(-1, 0, 1, 0)
        val rl = arrayOf(0, 1, 0, -1)

        while (!q.isEmpty()) {
            val cur = q.poll()

            println(cost.contentPrintln())

            visited[cur.dir][cur.x][cur.y] = true

            for (i in ud.indices) {
                val nx = cur.x + ud[i]
                val ny = cur.y + rl[i]

                val ndir = i % 2

                if (nx < 0 || nx >= board.size || ny < 0 || ny >= board[0].size
                    || board[nx][ny] == 1
                )
                    continue

                cost[nx][ny] = min(
                    cost[nx][ny], cost[cur.x][cur.y] + when (ndir == cur.dir) {
                        true -> 100
                        else -> 600
                    }
                )

                if (!visited[ndir][nx][ny]) {
                    visited[ndir][nx][ny] = true
                    q.add(Point(nx, ny, ndir))
                }
            }
        }

        cost.contentPrintln()

        return cost[board.lastIndex][board[0].lastIndex]
    }

    private fun ArrayList<IntArray>.contentPrintln(){
        this.forEach {
            it.forEach{
                print("$it ")
            }
            println()
        }
        println()
    }

    data class Point(
        val x: Int,
        val y: Int,
        val dir: Int
    )
}