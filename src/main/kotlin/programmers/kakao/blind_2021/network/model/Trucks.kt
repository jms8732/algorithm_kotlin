package programmers.kakao.blind_2021.network.model

data class Trucks(
    val trucks : List<Truck>
)

data class Truck(
    val id : Int,
    val location_id : Int,
    val loaded_bikes_count : Int
)