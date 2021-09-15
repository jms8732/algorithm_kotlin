package programmers.skill

import kotlin.math.min

fun main(args: Array<String>) {
    val sol = Solution2()

    sol.solution(
        6, 6,
        arrayOf(
            intArrayOf(2, 2, 5, 4),
            intArrayOf(3, 3, 6, 6),
            intArrayOf(5, 1, 6, 3)
        )
    ).forEach{
        print("$it ")
    }
}

class Solution2 {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val board = Array(rows) { i ->
            IntArray(columns) { j ->
                i * rows + j + 1
            }
        }

        val ret = mutableListOf<Int>()
        queries.fold(board) { b, q ->
            ret.add(rotation(b, q))
            b
        }

        return ret.toTypedArray().toIntArray()
    }

    private fun rotation(board: Array<IntArray>, queries: IntArray)  : Int{
        var startX = queries[0] -1
        var startY = queries[1] -1
        val endX = queries[2]- 1
        val endY = queries[3]-1

        var i = 0
        val ud = arrayOf(0, 1, 0, -1)
        val rl = arrayOf(1, 0, -1, 0)
        var x=  startX
        var y = startY
        var temp = board[x][y]
        var min = temp

        while (i < 4) {
            val nx = x + ud[i]
            val ny = y + rl[i]

            if (nx < startX || nx > endX || ny < startY || ny > endY) {
                i++

                continue
            }

            val nTemp = board[nx][ny]
            board[nx][ny] = temp
            temp = nTemp

            min = min(min,temp)

            x = nx
            y = ny
        }

        return min
    }

    private fun Array<IntArray>.contentPrint() {
        this.forEach {
            it.forEach {
                print("$it ")
            }
            println()
        }

        println()
    }
}