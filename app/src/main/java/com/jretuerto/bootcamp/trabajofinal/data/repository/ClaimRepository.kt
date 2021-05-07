package pe.com.bootcamp.jretuerto.data.repository

import com.jretuerto.bootcamp.trabajofinal.data.entities.ClaimResponse
import pe.com.bootcamp.jretuerto.data.remote.ClaimDataSource
import pe.com.bootcamp.jretuerto.data.remote.Result

import javax.inject.Inject

class ClaimRepository @Inject constructor(
    private val remoteDataSource: ClaimDataSource
) {
    suspend fun getClaim(): Result<ClaimResponse> = remoteDataSource.getClaim()

}


