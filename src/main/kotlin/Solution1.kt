fun main(args: Array<String>) {
    val sol = Solution1()

    sol.solution(
        arrayOf("muzi","frodo","apeach","neo"),
        arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"),
        2
    ).forEach{
        print("$it ")
    }
}

class Solution1 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val map = LinkedHashMap<String, Value>()

        id_list.forEach {
            map.put(it, Value(0, HashSet<String>()))
        }

        report.forEach {
            val split = it.split(" ")

            val id = split[0]
            val reported_id = split[1]

            val value = map[reported_id]
            val value1 = map[id]

            if (value1?.set?.contains(reported_id) == false)
                value?.count = value?.count?.plus(1)!!

            value1?.set?.add(reported_id)
        }

        val ret = IntArray(id_list.size)
        var index = 0

        map.keys.forEach {
            map[it]?.set?.forEach {
                if(map[it]?.count!! >= k)
                    ret[index] +=1
            }
            index++
        }

        return ret
    }

    data class Value(
        var count: Int,
        var set: HashSet<String>
    )
}