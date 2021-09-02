import java.net.CacheRequest

//다리 놓기
lateinit var cache: Array<Array<Int>>
var n: Int = 0
var m: Int = 0

fun main(args: Array<String>) {
    var N = readLine()?.toInt()!!

    for (i in 0 until N) {
        readLine()?.split(" ")?.let {
            n = it[0].toInt() //서쪽
            m = it[1].toInt() //동쪽
            cache = Array<Array<Int>>(n, { Array<Int>(m, { -1 }) })

            println(recursion(0,0))
        }
    }
}

fun recursion(w: Int, e: Int)  : Int {
    if (w == n)
        return 1

    if(e == m)
        return 0


    if (cache[w][e] != -1)
        return cache[w][e]

    var ret : Int = 0
    for (i in e until m) {
        ret += recursion(w+1,i+1)
    }

    cache[w][e] = ret
    return ret
}