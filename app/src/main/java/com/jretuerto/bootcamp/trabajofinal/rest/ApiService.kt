package com.jretuerto.bootcamp.rest

import com.jretuerto.bootcamp.trabajofinal.data.entities.pokemon.PokemonResponse

import retrofit2.Response
import retrofit2.http.*


interface ApiService {
    @GET("pokemon-form/{id}/")
    suspend fun searchPokemonById(@Path("id") pokemonId: String): Response<PokemonResponse>

    @GET("pokemon-form/{name}/")
    suspend fun searchPokemonByName(@Path("name") pokemonName: String): Response<PokemonResponse>

}