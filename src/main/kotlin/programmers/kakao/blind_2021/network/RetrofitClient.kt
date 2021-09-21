package programmers.kakao.blind_2021.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var instance : Retrofit? = null
    private val base_url = "https://kox947ka1a.execute-api.ap-northeast-2.amazonaws.com/prod/users/"
    private val gson = GsonBuilder().setLenient().create()

    fun instance() : Retrofit{
        if(instance == null){
            val client = OkHttpClient.Builder()
                .addInterceptor(HeaderInterceptor())
               // .addInterceptor(HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BASIC) })
                .build()


            instance = Retrofit.Builder()
                .client(client)
                .baseUrl(base_url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }


        return instance!!
    }
}