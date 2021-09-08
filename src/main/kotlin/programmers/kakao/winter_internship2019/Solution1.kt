package programmers.kakao.winter_internship2019


/*
튜플
풀이 방법: 본인이 편한 방법으로 구현 진행
kotlin extension을 이용

 */
fun main(args: Array<String>) {
    val sol = Solution1()
    sol.solution1("{{2},{2,1},{2,1,3},{2,1,3,4}}")
}

class Solution1 {
    fun solution(s: String): IntArray {
        val set = mutableSetOf<Int>()
        s.removePrefix("{")
            .removeSuffix("}")
            .split()
            .forEach {
                it.split(",").forEach {
                    set.add(it.toInt())
                }
            }

        return set.toTypedArray().toIntArray()
    }

    private fun String.split(): List<String> {
        val list = mutableListOf<String>()

        var startIndex = 0
        var endIndex = -1

        while (++endIndex < this.length) {
            if (this[endIndex] == '}') {
                list.add(
                    this.substring(startIndex, endIndex)
                        .removeSuffix("}").removePrefix("{")
                )
                startIndex = endIndex + 2
            }
        }

        list.sortBy { it.length }

        return list.toList()
    }


    //다른 사람 풀이
    fun solution1(s: String): IntArray {
        return s.substring(2, s.length - 2)
            .split("},{")
            .asSequence()
            .map {
                it.split(",").map {
                    it.toInt()
                }
            }
            .toList()
            .sortedBy { it.size }
            .fold(setOf<Int>()) { acc, list ->
                acc.union(list)
            }.toIntArray()
    }
}