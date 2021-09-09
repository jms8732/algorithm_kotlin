package programmers.kakao.internship2020

import java.lang.StringBuilder
import java.util.*


/*
키패드 누르기
풀이 방법: 구현 + bfs
왼손의 좌표와 오른손의 좌표를 각각 기억 해놓은 뒤 조건에 맞춰서 어떤 손으로 누를 지 선택한다.
 */
fun main(args: Array<String>) {
    val sol = Solution()
    println(sol.solution(intArrayOf(1,3,4,5,8,2,1,4,5,9,5),"right"))
}

class Solution {
    val keyPad = arrayOf(
        arrayOf('1', '2', '3'),
        arrayOf('4', '5', '6'),
        arrayOf('7', '8', '9'),
        arrayOf('*', '0', '#')
    )

    var leftHand: Point = Point(3, 0)
    var rightHand: Point = Point(3, 2)
    fun solution(numbers: IntArray, hand: String): String {
        val sb = StringBuilder()
        numbers.forEach {
            sb.append(move(it, hand))
        }

        return sb.toString()
    }

    private fun move(num: Int, hand: String): Char {
        if (num == 1 || num == 4 || num == 7) {
            leftHand = when(num){
                1 -> Point(0,0)
                4 -> Point(1,0)
                else -> Point(2,0)
            }
            return 'L'
        }else if (num == 3 || num == 6 || num == 9) {
            rightHand = when(num){
                3 -> Point(0,2)
                6 -> Point(1,2)
                else -> Point(2,2)}

            return 'R'
        }else {
            val point = when(num){
                2 -> Point(0,1)
                5 -> Point(1,1)
                8 -> Point(2,1)
                else -> Point(3,1)
            }
            val left = bfs(point,leftHand)
            val right = bfs(point,rightHand)

            if(left == right){
                if(hand == "left") {
                    leftHand = point
                    return 'L'
                }else {
                    rightHand = point
                    return 'R'
                }
            }else{
                if(left < right) {
                    leftHand = point
                    return 'L'
                }else {
                    rightHand = point
                    return 'R'
                }
            }
        }
    }

    private fun bfs(target: Point, current: Point) : Int{
        val ud = arrayOf(-1,0,1,0)
        val rl = arrayOf(0,1,0,-1)

        val q = LinkedList<Point>().apply {
            add(current)
        }

        val visited = arrayListOf<BooleanArray>().apply {
            for (i in keyPad.indices)
                add(BooleanArray(keyPad[i].size))
        }

        val move = arrayListOf<IntArray>().apply{
            for(i in keyPad.indices)
                add(IntArray(keyPad[i].size))
        }

        while(q.isNotEmpty()){
            val cur = q.poll()

            visited[cur.x][cur.y] = true

            for(i in ud.indices){
                val nx = cur.x + ud[i]
                val ny = cur.y + rl[i]

                if(nx < 0 || nx >= 4 || ny <0 || ny >= 3 || visited[nx][ny])
                    continue

                visited[nx][ny] = true
                move[nx][ny] = move[cur.x][cur.y]+1
                q.add(Point(nx,ny))
            }
        }

        return move[target.x][target.y]
    }

    data class Point(
        val x: Int,
        val y: Int
    )
}