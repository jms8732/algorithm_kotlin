package programmers.code_challenge

/*
내적
풀이방법: zip을 이용
 */
class Solution2 {
    fun solution(a: IntArray, b: IntArray): Int {
        val c = a.zip(b){v1 ,v2 ->
            v1 * v2
        }

        return c.fold(0){total, value ->
            total + value
        }
    }
}