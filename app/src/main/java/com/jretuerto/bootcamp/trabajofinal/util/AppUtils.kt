package pe.com.bootcamp.jretuerto.util


import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



class AppUtils {
    companion object {

        inline fun <reified T> fromJson(json: String): T {
            return Gson().fromJson(json, object : TypeToken<T>() {}.type)
        }


    }


}
