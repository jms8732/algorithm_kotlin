package programmers

import java.lang.StringBuilder
import kotlin.math.min

/**
 * 제한 사항
 * s의 길이는 1 <= <= 1000
 * s는 소문자 알파벳으로만 구성
 */

fun main(args: Array<String>) {
    println(solution("a"))
}

/**
 * 반복문은 s/2 까지만 진행
 *
 * 1. step 설정
 * 2. 현재 위치와 다음 위치의 값을 비교
 *  2-1. 값이 같으면 누적 개수를 올리고 인덱스를 다음으로 넘어가고 2번 진행
 *  2-2. 값이 다르면 인덱스만 넘김
 */
fun solution(s: String): Int {
    val size = s.length / 2

    //길이가 1인 경우
    if(size == 0)
        return 1

    var minLen = Int.MAX_VALUE
    var step = 0
    while (++step <= size) {
        val list = mutableListOf<String>()

        var position = 0
        while (position < s.length) {
            if (position + step >= s.length) {
                list.add(s.substring(position, s.length))
                break
            }
            val sub = s.substring(position, position + step)
            list.add(sub)
            position += step
        }

        position = 0

        var cached = 1
        val sb = StringBuilder()
        while (++position < list.size) {
            val first = list[position - 1]
            val second = list[position]

            if (first == second)
                cached++
            else {
                if (cached > 1) {
                    sb.append(cached).append(first)
                } else
                    sb.append(first)
                cached = 1
            }
        }

        if(cached > 1){
            sb.append(cached).append(list[position-1])
        }else
            sb.append(list[position-1])

        minLen = min(minLen,sb.length)
    }
    return minLen
}