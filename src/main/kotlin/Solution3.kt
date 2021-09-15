import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.ceil

fun main(args: Array<String>) {
    val sol = Solution3()
    sol.solution(
        intArrayOf(180, 5000, 10, 600),
        arrayOf(
            "05:34 5961 IN",
            "06:00 0000 IN",
            "06:34 0000 OUT",
            "07:59 5961 OUT",
            "07:59 0148 IN",
            "18:59 0000 IN",
            "19:09 0148 OUT",
            "22:59 5961 IN",
            "23:00 5961 OUT"
        )
    ).forEach{
        print("$it ")
    }
}

class Solution3 {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val map = TreeMap<String, MutableList<String>>()

        records.forEach {
            val split = it.split(" ")

            if (map.containsKey(split[1])) {
                map[split[1]]?.add(split[0])
            } else {
                map[split[1]] = mutableListOf(split[0])
            }
        }

        var ret = mutableListOf<Int>()

        map.forEach { key, value ->
            if (value.size % 2 != 0) {
                value.add("23:59")
            }

            var i = 0
            var totalTime = 0
            while (i + 1 < value.size) {
                val inTime = value[i].convertTime()
                val outTime = value[i + 1].convertTime()

                totalTime += (outTime - inTime)
                i += 2
            }

            ret.add(calcTime(fees, totalTime))
        }

        return ret.toTypedArray().toIntArray()
    }

    private fun calcTime(fees: IntArray, totalTime: Int): Int {
        if (totalTime < fees[0])
            return fees[1]
        else {
            val basic = fees[1]
            val time = ceil(((totalTime.toDouble() - fees[0].toDouble()) / fees[2].toDouble())).toInt()
            return basic + time* fees[3]
        }
    }

    private fun String.convertTime(): Int {
        val split = this.split(":")
        val hour = split[0].toInt() * 60
        val minute = split[1].toInt()

        return hour + minute
    }
}