package com.example.cardo_moon.data.api

import com.example.cardo_moon.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {

    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>

}