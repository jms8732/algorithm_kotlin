package gold5

import java.lang.Integer.min
import java.lang.StringBuilder
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.max
import kotlin.math.sqrt

var answer = -1

fun main(args : Array<String>){
    var n = 0
    var m = 0
    readLine()?.split(" ")?.run {
        n = this[0].toInt()
        m = this[1].toInt()
    }

    val board = arrayListOf<String>()
    for(i in 0 until  n){
        readLine()?.let {
            board.add(it)
        }
    }


    val big = min(m,n)
    //1부터 big까지 반복문 시행
    for(size in 1 .. big){
        val cols = IntArray(size)
        for(step in 1 .. big) {
            selectColNumber(n, m, board,step,0,size,0,cols)
        }
    }

    println(answer)
}

private fun selectColNumber(N : Int, M : Int, board : ArrayList<String>, step : Int, depth: Int, size : Int, next : Int
,cols : IntArray){
    if(depth == size){
        //열 숫자 선택 완료
        val rows = IntArray(size)
        selectRowNumber(N,board, step,0,size,0,rows,cols)

        return
    }

    for(i in next until M step step){
        cols[depth] = i
        selectColNumber(N,M, board, step, depth + 1, size, i, cols)
    }
}

private fun selectRowNumber(N : Int, board : ArrayList<String>, step : Int, depth : Int, size : Int, next : Int, rows: IntArray,
cols: IntArray){
    if(depth == size){
        //행 숫자 선택 완료

        //숫자 만들기
        makeNumber(board, rows, cols).toDouble().run {
            val temp = floor(sqrt(this)).toInt()
            val temp1 = ceil(sqrt(this)).toInt()
            if(temp == temp1)
                answer= max(answer,this.toInt())

        }
        return
    }

    for(i in next until N step  step){
        rows[depth] = i
        selectRowNumber(N, board, step, depth+1, size, next, rows,cols)
    }
}

private fun makeNumber(board : ArrayList<String>, rows : IntArray, cols : IntArray) : Int{
    return StringBuilder().apply {
        for (i in rows.indices) {
            append(board[rows[i]][cols[i]])
        }
    }.toString().toInt()
}



