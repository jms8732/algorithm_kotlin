package programmers.kakao.blind_2021

/*
신규 아이디 추천
풀이 방법: 시뮬레이션이므로 본인이 쉽게 구현할 수 있는 방법으로 진행한다.

 */
fun main(args : Array<String>){
    val sol = Solution()
    println(sol.solution("...!@BaT#*..y.abcdefghijklm"))
}

class Solution {
    fun solution(new_id: String): String {
        var temp = new_id.toLowerCase()
            .filter {
                it in 'a' .. 'z' || it in '0' .. '9' || it == '-' || it == '_' || it == '.'
            }
            .replace("[.]*[.]".toRegex(),".")
            //.replaceAll()
            .removePrefix(".")
            .removeSuffix(".")


        if(temp.isEmpty())
            temp = "a"

        if(temp.length >= 16){
            temp = temp.substring(0,15).removeSuffix(".")
        }

        if(temp.length <= 2)
            temp = temp.padEnd(3,temp.last())

        return temp
    }

    private fun String.replaceAll() : String{
        var ret = this
        while(ret.indexOf("..") != -1)
            ret = ret.replace("..",".")

        return ret
    }
}