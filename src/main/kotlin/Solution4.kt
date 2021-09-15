fun main(args: Array<String>) {
    val sol = Solution4()
    sol.solution(
        10,
        intArrayOf(0,0,0,0,0,0,0,0,3,4,3)
    ).forEach {
        print("$it ")
    }
}

class Solution4 {
    var max = 0
    var answer = intArrayOf()
    fun solution(n: Int, info: IntArray): IntArray {
        combination(
            remain = n,
            next = info.lastIndex,
            apeach = info,
            lion = IntArray(info.size)
        )

        if (answer.isEmpty())
            return intArrayOf(-1)
        return answer
    }

    private fun combination(remain: Int, next: Int, apeach: IntArray, lion: IntArray) {
        if (remain <= 0 || (next == -1 && remain >= 0)) {
            if(next == -1 && remain >= 0){
                lion[lion.lastIndex] = remain
            }

            if (remain < 0)
                return

            var lionResult = 0
            for (i in lion.indices) {
                lionResult += if (lion[i] != 0) 10 - i else 0
            }

            var apeachResult = 0
            for (i in apeach.indices) {
                apeachResult += if (apeach[i] != 0) 10 - i else 0
            }

         /*   if (lionResult - apeachResult >= max) {
                if ((lionResult - apeachResult) == max) {
                    println("===========")
                    answer.forEach{
                        print("$it ")
                    }
                    println()
                    lion.forEach{
                        print("$it ")
                    }
                    println("\n===========")

                    var previousResult = 0

                    for (i in answer.indices) {
                        previousResult += if (answer[i] != 0) 10 - i else 0
                    }

                    if (previousResult < lionResult) {
                        max = lionResult - apeachResult
                        answer = lion.clone()
                    }
                    return
                }
                max = lionResult - apeachResult
                answer = lion.clone()
                return
            }*/

            if(lionResult - apeachResult >= max){
                max = lionResult- apeachResult
                answer = lion.clone()
            }
            return
        }

        for (i in next downTo 0) {
            var temp = apeach[i]
            lion[i] = when (i == apeach.lastIndex) {
                true -> 0
                else -> apeach[i] + 1
            }

            //lion[i] = apeach[i] + 1
            apeach[i] = if (i == apeach.lastIndex) apeach[i] else 0
            //apeach[i] = 0
            combination(
                remain = remain - lion[i],
                next = i-1,
                apeach = apeach,
                lion = lion
            )
            lion[i] = 0
            apeach[i] = temp
        }
    }
}