package programmers


fun main(args: Array<String>) {
    val array = intArrayOf(1, 1, 1, 1, 1)

    println(solution(array, 3))
}

var answer = 0
fun solution(numbers: IntArray, target: Int): Int {
    recursive(numbers, 0, 0, target)
    return answer
}

fun recursive(numbers: IntArray, index: Int, value: Int, target: Int) {
    if(index == numbers.size) {
        if (value == target) {
            answer++
        }
        return
    }

    val temp = numbers[index]
    recursive(numbers, index + 1, value + temp, target)
    recursive(numbers, index + 1, value - temp, target)
}
