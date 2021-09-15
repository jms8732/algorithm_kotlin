fun main(args: Array<String>) {
    val sol = Solution6()
    println(sol.solution(
        arrayOf(intArrayOf(5,5,5,5,5),
            intArrayOf(5,5,5,5,5),
            intArrayOf(5,5,5,5,5),
            intArrayOf(5,5,5,5,5)),

        arrayOf(intArrayOf(1,0,0,3,4,4),
            intArrayOf(1,2,0,2,3,2),
            intArrayOf(2,1,0,3,1,2),
            intArrayOf(1,0,1,3,3,1),
        )
    ))
}

class Solution6 {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        skill.forEach {
            enemyAttack(board, it)
        }

        var count = 0
        board.forEach {
            it.forEach {
                if(it > 0)
                    count++
            }
        }

        return count
    }

    private fun enemyAttack(board: Array<IntArray>, s: IntArray) {
        val startX = s[1]
        val startY = s[2]
        val endX = s[3]
        val endY = s[4]

        val type = when(s[0]){
            1 -> s[5] * -1
            else -> s[5]
        }

        for (i in startX..endX) {
            for (j in startY..endY) {
                board[i][j] += type
            }
        }
    }
}