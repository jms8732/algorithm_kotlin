package programmers.dev_matching.`2021`



class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var correct = 0
        var zero_count = 0

        lottos.forEach {
            if(win_nums.contains(it)){
                correct++
            }

            if(it == 0)
                zero_count++
        }

        val max = correct + zero_count
        val min = correct

        return intArrayOf(rank(max),rank(min))
    }

    private fun rank(v : Int) = when(v){
        6 -> 1
        5 -> 2
        4 -> 3
        3 -> 4
        2 -> 5
        else -> 6
    }


    //다른 사람 풀이
    fun solution1(lottos: IntArray, win_nums: IntArray): IntArray{
        return intArrayOf(
            lottos.size.plus(1) - lottos.filter { win_nums.contains(it) || it == 0 }.size,
            lottos.size.plus(1) - lottos.filter { win_nums .contains(it)}.size
        ).map { if(it > 6) it - 1 else it}.toIntArray()
    }
}