package programmers.kakao.blind_2021

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import okhttp3.internal.addHeaderLenient
import programmers.kakao.blind_2021.network.Api
import programmers.kakao.blind_2021.network.RetrofitClient
import programmers.kakao.blind_2021.network.model.*
import java.util.concurrent.TimeUnit
import javax.swing.ScrollPaneConstants
import kotlin.random.Random

val client = RetrofitClient.instance()
val api = client.create(Api::class.java)

var auth_key: String? = null
var finished = false
var command: Command? = null
var temp = 6
var map = Array(5) { x ->
    temp -= 2
    IntArray(5) { y ->
        x + temp + y * 5
    }
}


fun main(args: Array<String>) {
    Observable.concat(api.postStart(1),
        Observable.zip(api.getLocations(), api.getTrucks()) { location, truck ->

            Command(
                mutableListOf<CommandX>().apply {
                    for (i in truck.trucks.indices) {
                        add(
                            CommandX(
                                listOf(0,0,0,0,0), truck.trucks[i].id
                            )
                        )
                    }

                }
            )
        }.concatMap { api.simulate(it) }
            .repeatUntil { finished }, api.getScore()
    )
        .observeOn(Schedulers.io())
        .subscribe {
            if (it is Start)
                auth_key = it.auth_key

            if(it is Simulate){
                if(it.time == 360)
                    println(it)

                finished = it.status == "finished"
            }

            if(it is Score)
                println(it)
        }
}