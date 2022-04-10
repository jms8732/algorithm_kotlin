package programmers

import java.util.*


fun main(args : Array<String>){
    Solution().solution(
        progresses = intArrayOf(93,30,55),
        speeds = intArrayOf(1,30,5)
    )
}
private class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {


        val remainProgress = progresses.map {
            //남은 작업량
            100 - it
        }.zip(speeds.toTypedArray()) { remain, speed ->
            val div = remain.div(speed)
            val mod = remain.rem(speed)

            div + if (mod > 0) 1 else 0
        }.run {
            LinkedList(this)
        }

        val ret = mutableListOf<Int>()
        while(remainProgress.isNotEmpty()){
            val value = remainProgress.pop()
            var count = 1
            //큐에 앞에 값보다 작을 때,
            while(remainProgress.isNotEmpty() && value >= remainProgress.peek()){
                count++
                remainProgress.pop()
            }

            ret.add(count)
        }

        return ret.toIntArray()
    }
}