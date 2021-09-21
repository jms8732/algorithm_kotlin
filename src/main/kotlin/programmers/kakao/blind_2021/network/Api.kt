package programmers.kakao.blind_2021.network

import io.reactivex.Observable
import programmers.kakao.blind_2021.network.model.*
import retrofit2.http.*

interface Api {
    @POST("start")
    fun postStart(
        @Query("problem") problem : Int
    ) : Observable<Start>

    @GET("locations")
    fun getLocations() : Observable<Locations>

    @GET("trucks")
    fun getTrucks() : Observable<Trucks>

    @PUT("simulate")
    fun simulate(
        @Body commands : Command?
    ) : Observable<Simulate>

    @GET("score")
    fun getScore() : Observable<Score>
}