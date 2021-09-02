package programmers.summer_winter_coding


/*
소수 만들기
풀이 방법:
1. 에라토스테네스 체를 이용하여 소수를 구함
2. 재귀를 이용해서 3개의 수를 더한 뒤, 1번에서 구한 소수에 포함 되는 지 판단

 */

fun main(args : Array<String>){
    val solution = Solution()
    println(solution.solution(intArrayOf(1,2,3,4)))
}

class Solution {
    lateinit var check: BooleanArray
    private val primeChecked = BooleanArray(3001)
    private val prime = mutableListOf<Int>()
    private var count = 0

    fun solution(nums: IntArray): Int {
        check = BooleanArray(nums.size)

        for (i in 2 until primeChecked.size) {
            if (!primeChecked[i]) {
                primeChecked[i] = true
                prime.add(i)
                for (j in i..primeChecked.size step (i)) {
                    primeChecked[j] = true
                }
            }
        }

        recursive(0,0,0,nums)
        return count
    }

    private fun recursive(depth: Int, sum: Int, next: Int, nums: IntArray) {
        if (depth == 3) {
            if (prime.contains(sum))
                count++
            return
        }

        for (i in next until nums.size) {
            recursive(
                depth = depth + 1,
                sum = nums[i] + sum,
                next = i + 1,
                nums = nums
            )
        }
    }
}