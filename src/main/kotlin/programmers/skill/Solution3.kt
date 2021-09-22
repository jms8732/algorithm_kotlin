package programmers.skill

fun main(args : Array<String>){
    val sol = Solution3()
    println(sol.solution(intArrayOf(1,1,1,1,1),3))
}

class Solution3 {
    var num = 0
    fun solution(numbers: IntArray, target: Int): Int {
        recursive(
            numbers,
            0,
            0,
            target
        )
        return num
    }

    private fun recursive(numbers : IntArray, index : Int , tar : Int, target : Int ){
        if(index == numbers.size){
            if(tar == target)
               num++

            return
        }

        recursive(
            numbers = numbers,
            index = index + 1,
            tar = tar + numbers[index],
            target = target
        )

        recursive(
            numbers = numbers,
            index = index + 1,
            tar = tar - numbers[index],
            target = target
        )

    }
}