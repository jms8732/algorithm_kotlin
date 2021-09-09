package programmers.kakao.internship2020

import kotlin.math.min

/*
보석 쇼핑
풀이 방법: 투 포인터 + map, set

Set은 모든 종류의 보석을 파악하기 위해서 사용
map은 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾기 위해서 사용
 */
fun main(args: Array<String>) {
    val sol = Solution3()
    sol.solution2(
        arrayOf(
            "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
            //"AA", "AB", "AC", "AA", "AC"
            //"XYZ", "XYZ", "XYZ"
            //"DIA","SA","EM","DIA","SA","EM","DIA","SA","EM","AR"
            //"ZZZ", "YYY", "NNNN", "YYY", "BBB"
        )
    ).forEach {
        print("$it ")
    }
}

class Solution3 {
    fun solution(gems: Array<String>): IntArray {
        val totalGems = gems.toSet()
        val tempGems = HashMap<String, Int>()

        var left = 0
        var right = 0

        var answer = IntArray(2).apply {
            this[0] = Int.MAX_VALUE
            this[1] = Int.MAX_VALUE
        }
        var len = Int.MAX_VALUE

        while (right < gems.size) {
            if (tempGems.containsKey(gems[right])) {
                tempGems[gems[right]] = tempGems[gems[right]]?.plus(1)!!
            } else {
                tempGems[gems[right]] = 1
            }

            while (totalGems.size == tempGems.keys.size) {
                //보석을 적어도 한 개씩 싹쓸이 한 경우
                if (len > right - left + 1) {
                    answer.run {
                        this[0] = left + 1
                        this[1] = right + 1
                    }
                    len = min(len, right - left + 1)
                }

                if (tempGems.containsKey(gems[left])) {
                    tempGems[gems[left]] = tempGems[gems[left]]?.minus(1)!!
                    if (tempGems[gems[left]] == 0)
                        tempGems.remove(gems[left])
                }
                left++
            }

            right++
        }

        return answer
    }

    //다른 사람 풀이
    fun solution2( gems : Array<String>) : IntArray{
        val answer = intArrayOf(1,gems.size)
        val tokenKindSize = gems.toSet().size

        gems.foldIndexed(LinkedHashMap<String,Int>()){index, map , gem ->
            map.remove(gem)
            map[gem] =index

            if(map.size == tokenKindSize){
                val start = map.values.first()
                val end = map.values.last()

                if(end - start < answer[1] - answer[0]){
                    answer[0] = start +1
                    answer[1] = end + 1
                }
            }

            map
        }

        return answer
    }
}