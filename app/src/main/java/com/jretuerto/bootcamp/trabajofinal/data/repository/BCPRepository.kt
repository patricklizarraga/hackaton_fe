package pe.com.bootcamp.jretuerto.data.repository

import com.jretuerto.bootcamp.trabajofinal.data.entities.pokemon.PokemonResponse
import pe.com.bootcamp.jretuerto.data.remote.BCPRemoteDataSource
import pe.com.bootcamp.jretuerto.data.remote.Result

import javax.inject.Inject

class BCPRepository @Inject constructor(
    private val remoteDataSource: BCPRemoteDataSource
) {
    suspend fun searchPokemonById(pokemonId: String): Result<PokemonResponse> = remoteDataSource.searchPokemonById(pokemonId)
    suspend fun searchPokemonByName(pokemonName: String): Result<PokemonResponse> = remoteDataSource.searchPokemonByName(pokemonName)

}


