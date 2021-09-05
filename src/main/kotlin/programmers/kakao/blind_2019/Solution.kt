package programmers.kakao.blind_2019

import java.lang.IllegalArgumentException

/*
오픈 채팅방
풀이 방법: 구현이므로 본인이 편한 방법으로 진행, chaining을 이용
 */

fun main(arg: Array<String>) {
    val sol = Solution()
        sol.solution1(
            arrayOf(
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
            )
        ).forEach {
            println(it)
        }

}


class Solution {
    fun solution(record: Array<String>): Array<String> {
        val id = HashMap<String, String>()

        return record.map {
            it.split(" ")
        }.map {
            val op = it[0]
            val userId = it[1]

            if (op != "Leave")
                id[userId] = it[2]

            when (op) {
                "Enter" -> "$op $userId"
                "Leave" -> "$op $userId"
                else -> null
            }
        }.mapNotNull {
            it?.split(" ")
        }.map {
            val op = it[0]
            val userId = it[1]

            when (op) {
                "Enter" -> "${id[userId]}님이 들어왔습니다."
                "Leave" -> "${id[userId]}님이 나갔습니다."
                else -> ""
            }
        }.toTypedArray()

    }

    //다른 사람 풀이
    fun solution1(record: Array<String>): Array<String> {
        val id = HashMap<String, String>()

        return record.map {
            val split = it.split(" ")
            val op = split[0]
            val userId = split[1]

            when(op){
                "Enter", "Change" -> id[userId] = split[2]
                else ->""
            }
            split
        }.asSequence()
            .filter { it[0] != "Change" }
            .map {
                val userId = it[1]

                when (it[0]) {
                    "Enter" -> "${id[userId]}님이 들어왔습니다."
                    "Leave" -> "${id[userId]}님이 나갔습니다."
                    else -> throw IllegalArgumentException()
                }

            }.toList().toTypedArray()
    }
}