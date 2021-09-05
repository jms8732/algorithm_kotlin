package programmers.code_challenge

/*
음양 더하기
풀이 방법: foldIndex를 이용
 */
fun main(args: Array<String>) {
    val sol = Solution()
    println(sol.solution(intArrayOf(4, 7, 12), booleanArrayOf(true, false, true)))
}

class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        return absolutes.foldIndexed(0) { index, result, value ->
            if (signs[index])
                value + result
            else
                result - value
        }
    }
}