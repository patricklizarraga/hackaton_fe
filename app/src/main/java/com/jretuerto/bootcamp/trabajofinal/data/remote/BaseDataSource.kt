package pe.com.bootcamp.jretuerto.data.remote


import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import pe.com.bootcamp.jretuerto.data.ErrorObjectResponse
import pe.com.bootcamp.jretuerto.data.NetworkMessage
import pe.com.bootcamp.jretuerto.util.AppUtils
import pe.com.bootcamp.jretuerto.util.Constants
import retrofit2.Response


open class BaseDataSource {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Result<T> {

        return safeApiResult(call)

    }

    private suspend fun <T : Any> safeApiResult(call: suspend () -> Response<T>): Result<T> {

        try {
            val response = call.invoke()


            Log.i(Constants.GENERAL_LOG_APP_TAG, response.raw().toString())
            Log.i(Constants.GENERAL_LOG_APP_TAG, response.message())
            Log.i(Constants.GENERAL_LOG_APP_TAG, response.body().toString())
            Log.i(Constants.GENERAL_LOG_APP_TAG, response.raw().networkResponse.toString())

            if (response.isSuccessful) return Result.Success(response.body()!!)


            val jsonObject = JSONObject(response.errorBody()!!.string())
            val message: ErrorObjectResponse = AppUtils.fromJson(jsonObject.toString())


            var networkMessage = NetworkMessage("", 0)

            message.exceptionMessage.let {
                networkMessage =
                    NetworkMessage(it, response.raw().code)
            }


            return Result.ApiError(networkMessage)
        } catch (e: JSONException) {
            return Result.ApiError(NetworkMessage("", 0))
        }
    }

    suspend fun <T : Any> safeApiWatsonCall(call: suspend () -> Response<T>): Result<T> {

        return safeApiWatsonResult(call)

    }

    private suspend fun <T : Any> safeApiWatsonResult(call: suspend () -> Response<T>): Result<T> {

        try {
            val response = call.invoke()


            Log.i(Constants.GENERAL_LOG_APP_TAG, response.raw().toString())
            Log.i(Constants.GENERAL_LOG_APP_TAG, response.message())
            Log.i(Constants.GENERAL_LOG_APP_TAG, response.body().toString())
            Log.i(Constants.GENERAL_LOG_APP_TAG, response.raw().networkResponse.toString())

            if (response.isSuccessful) return Result.Success(response.body()!!)


            val jsonObject = JSONObject(response.errorBody()!!.string())
            val message: ErrorObjectResponse = AppUtils.fromJson(jsonObject.toString())


            var networkMessage = NetworkMessage("", 0)

            message.exceptionMessage.let {
                networkMessage =
                    NetworkMessage(it, response.raw().code)
            }


            return Result.ApiError(networkMessage)
        } catch (e: JSONException) {
            return Result.ApiError(NetworkMessage("", 0))
        }
    }

}

sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()

    /**
     * Failure response with body
     */
    data class ApiError(val exception: NetworkMessage) : Result<Nothing>()


    /**
     * For example, json parsing error
     */
    //data class UnknownError(val error: Throwable?) : Result<Nothing>()
}