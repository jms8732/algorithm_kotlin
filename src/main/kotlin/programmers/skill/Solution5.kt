package programmers.skill

fun main(args: Array<String>) {
    val sol = Solution5()

    println(sol.solution(3, arrayOf(
        intArrayOf(1,1,0),
        intArrayOf(1,1,0),
        intArrayOf(0,0,1)
    )))
}

class Solution5 {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var ret = 0
        val visited = Array(computers.size) {
            BooleanArray(computers[it].size)
        }

        for (i in computers.indices) {
            for (j in computers[i].indices) {
                if (computers[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true
                    visited[j][i] = true

                    search(j,computers,visited)
                    ret++
                }
            }
        }

        return ret
    }

    private fun search(x: Int, computers: Array<IntArray>, visited: Array<BooleanArray>) {
        for (i in computers[x].indices) {
            if (computers[x][i] == 1 && !visited[x][i]) {
                visited[x][i] = true
                visited[i][x] = true

                search(i, computers, visited)
            }
        }
    }
}