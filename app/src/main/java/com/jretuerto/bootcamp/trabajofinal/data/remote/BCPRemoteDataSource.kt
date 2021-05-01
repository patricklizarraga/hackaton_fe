package pe.com.bootcamp.jretuerto.data.remote

import com.jretuerto.bootcamp.rest.ApiService
import javax.inject.Inject

class BCPRemoteDataSource @Inject constructor(
    private val service: ApiService
) : BaseDataSource() {

    suspend fun searchPokemonById(pokemonId: String) = safeApiCall { service.searchPokemonById(pokemonId) }
    suspend fun searchPokemonByName(pokemonName: String) = safeApiCall { service.searchPokemonByName(pokemonName) }

}


