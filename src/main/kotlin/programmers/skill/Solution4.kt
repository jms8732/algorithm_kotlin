package programmers.skill

import java.awt.CardLayout
import java.util.*

fun main(args : Array<String>){
    val sol = Solution4()
    println(sol.solution(""))

}

class Solution4 {
    var stack = Stack<Char>()

    fun solution(s: String): Int {
        var temp = s
        var answer = 0

        for(i in temp.indices){
            println(temp)
            if(check(temp))
                answer++

            temp = temp.moveLeft()
            stack.clear()
        }

        return answer
    }

    private fun String.moveLeft() : String{
        val temp = this.first()
        val sub = this.substring(1,this.length)

        return sub + temp
    }

    private fun check(s : String) : Boolean{
        s.forEach {
            if(it == '[' || it == '(' || it == '{')
                stack.push(it)
            else if(it == ']' || it == '}' || it == ')'){
                if(it == ']'){
                    if(stack.isNotEmpty() && stack.peek() == '[')
                        stack.pop()
                    else
                        return false
                }else if(it == '}'){
                    if(stack.isNotEmpty() && stack.peek() == '{')
                        stack.pop()
                    else
                        return false
                }else{
                    if(stack.isNotEmpty() && stack.peek() == '(')
                        stack.pop()
                    else
                        return false
                }
            }
        }

        return stack.isEmpty()
    }
}