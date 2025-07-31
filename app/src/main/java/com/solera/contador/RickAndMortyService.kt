package com.solera.contador

import retrofit2.http.GET
import retrofit2.Call

interface RickAndMortyService {
    @GET("character")
    fun getCharacters(): Call<CharacterResponse>

}