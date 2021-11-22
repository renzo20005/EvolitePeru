package com.mapsalud.evoliteperu

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("get_affiliate")
    fun fetchAllUsers() : Call<List<User>>
}