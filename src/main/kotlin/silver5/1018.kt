package silver5

import java.util.*

//체스판 다시 칠하기
lateinit var board : Array<CharArray>
fun main(args : Array<String>){
    readLine()?.split(" ")?.let{
        var n= it[0].toInt()
        var m = it[1].toInt()

        board = Array<CharArray>(n,{ CharArray(m) })

        for(i in  0 until n){
            board[i] = readLine()?.toCharArray()!!
        }

        var ret = Int.MAX_VALUE
        for(i in 0  .. n - 8){
            for(j in 0 .. m - 8){
                ret = ret.coerceAtMost(chessBoardCheck(i,j))
            }
        }
        println(ret)
    }
}

fun chessBoardCheck(x : Int, y : Int) : Int{
    var color = arrayOf('B','W')

    var ret = 0

    for(i in x until x + 8){
        for(j in y until y + 8){
            var current = board[i][j]

            if(color[(i+j) % 2] != current)
                ret += 1
        }
    }

    color = arrayOf('W','B')
    var ret1 = 0

    for(i in x until x + 8){
        for(j in y until y + 8){
            var current = board[i][j]

            if(color[(i+j) % 2] != current)
                ret1 += 1
        }
    }

    return ret.coerceAtMost(ret1)
}