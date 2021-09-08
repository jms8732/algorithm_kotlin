package programmers.kakao.winter_internship2019

/*
불량 사용자
풀이 방법: 순열 + Set
combination이 안되는 이유: user_id를 조합으로 찾았을 경우, banned_id와 매칭하기 위해서는 banned_id도 조합을 진행해야 한다.
 */

fun main(args: Array<String>) {
    val sol = Solution2()
    println(
        sol.solution(
            arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"),
            arrayOf("*rodo", "*rodo", "******")
        )
    )
}

class Solution2 {
    /*
    순열을 이용하게 되면 원소의 값은 동일하고 순서만 다른 경우가 발생하게 된다. (중복 발생)
    중복을 막기 위한 장치로 set을 이용
     */
    var set = mutableSetOf<MutableSet<String>>()
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        permutation(
            depth = 0,
            visited = BooleanArray(user_id.size),
            candidate = Array<String>(banned_id.size) { "" },
            banned_id = banned_id,
            user_id = user_id
        )
        return set.size
    }

    /*
    순열 이용
    조합을 사용하지 않는 이유: 조합을 이용할 경우, 유저 아이디 조합, 정지된 아이디 조합 두 개의 조합을 만들어야 한다. => 시간 초과 발생
     */
    private fun permutation(
        depth: Int,
        visited: BooleanArray,
        user_id: Array<String>,
        candidate: Array<String>,
        banned_id: Array<String>
    ) {
        if (depth == banned_id.size) {
            if (matching(candidate, banned_id)) {

            }
            return
        }

        for (i in user_id.indices) {
            if (!visited[i]) {
                visited[i] = true
                permutation(
                    depth = depth + 1,
                    visited = visited,
                    user_id = user_id,
                    candidate = candidate.apply {
                        this[depth] = user_id[i]
                    },
                    banned_id = banned_id
                )
                visited[i] = false
            }
        }
    }


    private fun matching(candidate: Array<String>, banned_id: Array<String>): Boolean {
        for (i in candidate.indices) {
            val id = candidate[i]
            val bId = banned_id[i]

            if (id.length != bId.length)
                return false

            id.zip(bId) { c1, c2 ->
                if (c1 != c2) {
                    if (c2 != '*')
                        return false
                }
            }
        }

        set.add(candidate.toMutableSet())
        return true

    }
}