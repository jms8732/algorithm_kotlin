package programmers

import java.util.*

fun main(args: Array<String>) {
    var array = arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 1)
    )

    println(solution(3, array))
}

lateinit var visited: Array<BooleanArray>

fun solution(n: Int, computers: Array<IntArray>): Int {
    visited = Array(n) {
        BooleanArray(n)
    }
    var count = 0

    for (i in 0  until n ) {
        if (computers[i][i] == 1 && !visited[i][i]) {
            visited[i][i] = true
            count++
            val q = LinkedList<Int>().apply {
                add(i)
            }

            while (q.isNotEmpty()) {
                val cur = q.poll()

                for (j in 0 until n) {
                    if (!visited[cur][j] && computers[cur][j] == 1) {
                        visited[cur][j] = true
                        visited[j][cur] = true
                        visited[j][j] = true

                        q.add(j)
                    }
                }
            }
        }
    }

    return count
}