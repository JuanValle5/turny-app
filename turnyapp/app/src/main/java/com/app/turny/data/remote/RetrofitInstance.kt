package com.app.turny.data.remote

import com.app.turny.data.remote.api.AuthApiService
import com.app.turny.data.remote.api.ProfileApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL =
        "http://192.168.1.16:8080/"

    // INSTANCIA GLOBAL RETROFIT
    private val retrofit: Retrofit by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    // AUTH API
    val api: AuthApiService by lazy {

        retrofit.create(AuthApiService::class.java)
    }

    // PROFILE API
    val profileApi: ProfileApiService by lazy {

        retrofit.create(ProfileApiService::class.java)
    }
}