package programmers

fun main(args: Array<String>) {
    val numbers = intArrayOf(1,1,1,1,1)

    solution(numbers,3)
}

fun solution(numbers: IntArray, target: Int): Int {
    val ret = calculate(numbers, 0, target, 0)
    return ret
}

tailrec fun calculate(numbers: IntArray, position: Int, target: Int, value: Int) : Int{
    if (position == numbers.size) {
        if (target == value)
            return 1
        return 0
    }

    var count = 0
    count += calculate(numbers, position + 1, target, value + numbers[position])
    count += calculate(numbers, position + 1, target, value - numbers[position])

    return count
}
