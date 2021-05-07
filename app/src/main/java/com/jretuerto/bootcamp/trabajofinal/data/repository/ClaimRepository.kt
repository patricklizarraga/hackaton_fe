package pe.com.bootcamp.jretuerto.data.repository

import com.jretuerto.bootcamp.trabajofinal.data.entities.Claim
import com.jretuerto.bootcamp.trabajofinal.data.entities.pokemon.PokemonResponse
import pe.com.bootcamp.jretuerto.data.remote.BCPRemoteDataSource
import pe.com.bootcamp.jretuerto.data.remote.ClaimDataSource
import pe.com.bootcamp.jretuerto.data.remote.Result

import javax.inject.Inject

class ClaimRepository @Inject constructor(
    private val remoteDataSource: ClaimDataSource
) {
    suspend fun getClaim(customerId: String): Result<Claim> = remoteDataSource.getClaim(customerId)

}


