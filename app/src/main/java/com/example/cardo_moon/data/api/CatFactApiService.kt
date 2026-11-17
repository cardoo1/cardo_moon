package com.example.cardo_moon.data.api

import com.example.cardo_moon.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {

    @GET("fact")
    suspend fun getCatFact(): CatFactModel

}