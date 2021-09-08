package programmers.skill

import kotlin.math.pow

//스킬 체크 테스트 level 1
fun main(args: Array<String>) {
    val sol = Solution()
    println(sol.solution2(
        arrayOf(
            arrayOf("yellowhat","headgear"),
            arrayOf("bluesunglasses","headgear"),
            arrayOf("green_turban","eyewear")
        )
    ))
}

class Solution {
    fun solution(seoul: Array<String>): String = seoul.indexOfFirst { it == "Kim" }.run {
        "김서방은 ${this}에 있다"
    }

    fun solution(n: Int): Int {
        val reversed = getThird(n)

        return reversed.foldRightIndexed(0){index , c , total ->
            ((c - '0') * 3.0.pow(index.toDouble()) + total).toInt()
        }
    }

    private fun getThird(num : Int) : String{
        return StringBuilder().apply{
            var div = num
            while(div / 3 != 0){
                val mod = div % 3
                div /= 3

                append(mod)
            }
            append(div)
        }.toString().reversed()
    }


    //skill check level 2
    fun solution2(n: Int): Int {
        val array = IntArray(n+1).apply {
            this[0] = 0
            this[1] = 1
        }

        for(i in 2 until array.size){
            array[i] = (array[i-1] + array[i-2]) % 1234567
        }

        return array[n]
    }

    fun solution2(clothes: Array<Array<String>>): Int {
        val map = clothes.groupBy { it[1] }

        var ret = map.values.fold(0){total, list ->
            total + list.size
        }

        if(map.size > 1)
            ret += map.values.fold(1) { total, list ->
                total * list.size
            }

        return ret

    }
}