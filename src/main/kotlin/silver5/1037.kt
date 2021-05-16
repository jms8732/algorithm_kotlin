package silver5

//약수
fun main(args: Array<String>) {
    var n = readLine()?.toInt()!!

    readLine()?.split(" ")?.let { item ->
        var list = Array<Int>(n) { 0 }

        for (i in list.indices) {
            list[i] = item[i].toInt()
        }

        list.sort()

        println(list[0] * list[list.size-1])
    }
}