package programmers.kakao.blind_2021.network.model

data class Locations(
    val locations: List<Location>,
)


data class Location(
    val id : Int,
    val located_bikes_count : Int
)