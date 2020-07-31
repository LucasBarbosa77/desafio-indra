package com.lucas.barbosa.desafioindra.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val api_key = "2792abea94591dcedcf8cfd640aabd96"

fun getRetrofitInstance(): Retrofit {
    return Retrofit.Builder()
        .client(retrofitTimeOut())
        .baseUrl("https://api.themoviedb.org/3/")
        .build()
}

fun retrofitTimeOut(): OkHttpClient {
    return OkHttpClient().newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS).build()
}

fun getJsonConverter(): GsonConverterFactory {
    val gsonFactory = GsonBuilder().setLenient().serializeNulls().create()
    return GsonConverterFactory.create(gsonFactory)
}

fun provideApi(retrofit: Retrofit): ApiEndPoint = retrofit.create(ApiEndPoint::class.java)
