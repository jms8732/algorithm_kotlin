package codility

import java.util.*
import kotlin.collections.HashMap


/*
map을 이용해서 문제 접근
HashMap일 경우, O(N) or O(nlogn)의 시간 복잡도 => 마지막 문제 실패
TreeMap일 경우, O(N^2) 의 시간복잡도 => 내부적으로 정렬을 진행하기 때문에 N^2의 시간이 발생함

XOR 연산을 이용
 */
fun main(args: Array<String>) {
    println(solution(intArrayOf(9, 3, 9, 3, 9, 7, 9)))
}

private fun solution(A: IntArray): Int {
    // write your code in Kotlin 1.3.11 (Linux)
    var temp = 0
    A.forEach {
        temp = it.xor(temp)
    }

    return temp
}

