package programmers.kakao.blind_2021.network.model

data class Simulate(
    val status : String,
    val time : Int,
    val failed_requests_count : Int,
    val distance : String
)