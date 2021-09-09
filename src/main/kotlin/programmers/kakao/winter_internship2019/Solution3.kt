package programmers.kakao.winter_internship2019

import java.util.*
import kotlin.collections.HashSet

/*
호텔 방 배정
풀이 방법: Tree set, linkedHashSet

LinkedHashSet을 쓴 이유 -> contains 메소드를 이용할 때, array 보다 더 빠르다.
반대로 array를 이용해서 진행할 경우, 효율성에서 시간 초과가 발생한다.

역으로 방의 개수를 대상으로 하나씩 방이 채워질 때마다 원소를 제거한다. -> 그러기에는 k의 값이 너무 크다 K^12
 */
fun main(args: Array<String>) {
    val sol = Solution3()
    sol.solution(10, longArrayOf(7, 6, 5, 1, 1, 1)).forEach {
        print("$it ")
    }
}

class Solution3 {
    val nextRoom = TreeSet<Long>()

    fun solution(k: Long, room_number: LongArray): LongArray {
        val ret = LinkedHashSet<Long>()

        for (i in room_number.indices) {
            val current = room_number[i]

            //현재 방이 찼는 지 확인
            if (ret.contains(current)) {
                //현재 방이 찬 경우
                val nRoom = nextRoom.ceiling(current) ?: current + 1

                //다음 방을 배정
                ret.add(nRoom)
                nextRoom.remove(nRoom)

                if (!ret.contains(nRoom + 1))
                    nextRoom.add(nRoom + 1)

            } else {
                //현재 방이 안 찬 경우
                ret.add(current)

                nextRoom.remove(current)

                //다음 빈 방을 넣는다.
                if (!ret.contains(current + 1))
                    nextRoom.add(current + 1)
            }
        }

        return ret.toTypedArray().toLongArray()
    }
}

