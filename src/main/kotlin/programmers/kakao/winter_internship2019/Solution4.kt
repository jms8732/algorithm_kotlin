package programmers.kakao.winter_internship2019

import kotlin.math.max
import kotlin.math.min

/*
징검다리 건너기
풀이 방법: 그리디

주의: 디딤돌의 최댓값을 구하는 방식으로 진행할 경우, 디딤돌이 내림차순으로 있을 때, TC 13이 시간 초과가 발생한다.
 */

fun main(args : Array<String>){
    val sol = Solution4()
    println(sol.solution(intArrayOf(10,9,8,7,6,5,5,4,3,2,1),4))
}

class Solution4 {
    fun solution(stones: IntArray, k: Int): Int {
        val stoneList = stones.toList()

        //징검다리가 내림차순으로 존재할 경우를 생각하자.
        var sorted = false
        for(i in 1 until stoneList.size){
            if(stoneList[i-1] < stoneList[i]) {
                sorted = true
                break
            }
        }

        if(!sorted)
            return stoneList[stoneList.lastIndex - k+1]


        var startIndex = 0
        var friends = Integer.MAX_VALUE

        while(startIndex+k <= stoneList.size){
            val subList = stoneList.subList(startIndex,startIndex+k)
            val max = subList.maxOrNull()!!
            val index = subList.indexOfLast { it == max}

            friends = min(max,friends)
            startIndex += index+1
        }

        return friends
    }
}