package programmers.kakao.blind_2021.network

import okhttp3.Interceptor
import okhttp3.Response
import programmers.kakao.blind_2021.auth_key

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request = when (auth_key == null) {
             true -> {
                 request.newBuilder()
                     .addHeader("X-Auth-Token", "c29168ced63e37524e23543ec1bbed25")
                     .addHeader("Content-Type", "application/json")
                     .url(request.url)
                     .build()
             }
            else ->{
                request.newBuilder()
                    .addHeader("Authorization", auth_key!!)
                    .addHeader("Content-Type","application/json")
                    .url(request.url)
                    .build()
            }
        }

        return chain.proceed(request)
    }
}