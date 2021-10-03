package programmers.skill

import java.util.*
import kotlin.collections.LinkedHashSet

/*
스킬 레벨 3
 */
fun main(args: Array<String>) {
    val sol = Solution6()
    println(sol.solution(8, 2, arrayOf("D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C")))
}

class Solution6 {
    val stack = Stack<Node>()

    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        val cached= Array(n) { Node(null, null,false) }
        for (i in 0 until n) {
            cached[i] = Node(null, null, false)
        }

        for (i in 1 until n) {
            cached[i].prev = cached[i - 1]
            cached[i - 1].next = cached[i]
        }

        var current = cached[k]


        cmd.forEach {
            val split = it.split(" ")
            val command = split[0]

            when (command) {
                "D" -> {
                    var step = split[1].toInt()
                    for(i in 0 until step){
                        current = current.next!!
                    }
                }
                "C" -> {
                    stack.add(current)
                    current.deleted = true
                    current.prev?.next = current.next
                    current.next?.prev = current.prev

                    if (current.next != null)
                        current = current.next!!
                    else
                        current = current.prev!!
                }
                "U" -> {
                    var step = split[1].toInt()
                    for(i in 0 until step){
                        current = current.prev!!
                    }
                }
                "Z" -> {
                    if (stack.isNotEmpty()) {
                        val temp = stack.pop()
                        temp.deleted= false

                        temp.prev?.next = temp
                        temp.next?.prev = temp
                    }
                }
            }
        }


        return StringBuilder().apply {
            cached.forEach {
                if (it.deleted) {
                    append("X")
                } else
                    append("O")
            }
        }.toString()
    }
}

data class Node(
    var prev: Node? = null,
    var next: Node? = null,
    var deleted : Boolean
)