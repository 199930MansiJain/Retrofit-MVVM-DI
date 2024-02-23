package com.example.retrofitdependencinjection.core.common

sealed class Resource <T>(val data : T? = null,val msg : String? = null) {
    class Success<T>(data: T?) : Resource<T>(data = data)
    class Error<T>(msg: String?) : Resource<T>(msg= msg)
    class Loading<T> : Resource<T>()
}

sealed class LocalResponseResult {
    data class Success<T>(val data : T,val daoType: Int):LocalResponseResult()
    data class Error(val errorMsg:String?):LocalResponseResult()

}
