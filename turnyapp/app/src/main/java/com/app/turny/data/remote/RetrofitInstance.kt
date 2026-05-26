package com.app.turny.data.remote

import com.app.turny.data.remote.api.AppointmentApiService
import com.app.turny.data.remote.api.AppointmentBusinessApiService
import com.app.turny.data.remote.api.AuthApiService
import com.app.turny.data.remote.api.ProfileApiService
import com.app.turny.data.remote.api.BusinessApiService
import com.app.turny.data.remote.api.FavoriteApiService
import com.app.turny.data.remote.api.ProfileBusinessApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL =
        "https://skillful-tranquility-production-bca4.up.railway.app/"

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

    val businessApi: BusinessApiService by lazy {

        retrofit.create(BusinessApiService::class.java)
    }

    val appointmentApi: AppointmentApiService by lazy {

        retrofit.create(
            AppointmentApiService::class.java
        )
    }
    val favoriteApi: FavoriteApiService by lazy {

        retrofit.create(
            FavoriteApiService::class.java
        )
    }

    val appointmentBusinessApi:
            AppointmentBusinessApiService by lazy {

        retrofit.create(
            AppointmentBusinessApiService::class.java
        )
    }

    val profileBusinessApi:
            ProfileBusinessApiService by lazy {

        retrofit.create(
            ProfileBusinessApiService::class.java
        )
    }

}