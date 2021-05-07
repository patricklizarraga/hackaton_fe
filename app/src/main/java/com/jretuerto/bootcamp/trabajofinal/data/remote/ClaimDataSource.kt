package pe.com.bootcamp.jretuerto.data.remote

import com.jretuerto.bootcamp.rest.ApiService
import javax.inject.Inject

class ClaimDataSource @Inject constructor(
    private val service: ApiService
) : BaseDataSource() {

    suspend fun getClaim(customerId: String) = safeApiCall { service.getClaim(customerId) }

}


