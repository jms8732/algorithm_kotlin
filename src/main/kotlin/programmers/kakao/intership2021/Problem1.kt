package programmers.kakao.intership2021

import programmers.solution
import java.lang.StringBuilder

/*
숫자 문자열과 영단어
풀이 방법: 1) 한 문자 씩 읽으면서 분기 처리, 2) replace 메소드 이용
 */

fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.solution1("23four5six7"))
}

class Solution {
    fun solution(s: String): Int {
        val sb = StringBuilder()
        var i = 0
        while(i < s.length) {
            val char = s[i]
            sb.append(
                when (char) {
                    'o' -> {
                        i += 3
                        1
                    }
                    't' ->{
                        when(s[i+1]){
                            'w' -> {
                                i+= 3
                                2
                            }
                            else ->{
                                i += 5
                                3
                            }
                        }
                    }
                    'f' -> {
                        when(s[i+1]){
                            'o' -> {
                                i += 4
                                4
                            }
                            else -> {
                                i += 4
                                5
                            }
                        }
                    }
                    's' ->{
                        when(s[i+1]){
                            'i' -> {
                                i +=3
                                6
                            }
                            else ->{
                                i += 5
                                7
                            }
                        }
                    }
                    'e' ->{
                        i += 5
                        8
                    }
                    'n' ->{
                        i +=4
                        9
                    }
                    'z' ->{
                        i +=4
                        0
                    }
                    else -> {
                        i++
                        char
                    }
                }
            )
        }

        return sb.toString().toInt()
    }

    fun solution1(s: String) : Int = s.replace("one","1").replace("two","2")
        .replace("three","3")
        .replace("four","4")
        .replace("five","5")
        .replace("six","6")
        .replace("seven","7")
        .replace("eight","8")
        .replace("nine","9")
        .replace("zero","0").toInt()
}