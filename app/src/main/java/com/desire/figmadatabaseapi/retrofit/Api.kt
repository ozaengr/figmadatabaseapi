package com.desire.figmadatabaseapi.retrofit

import com.desire.figmadatabaseapi.responce.DeleteProductResponce
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("products")
    fun getData(): Call<ArrayList<User>>

    @DELETE("products/{id}")
    fun deleteProduct(@Path("id")id : Int) : Call<DeleteProductResponce>
}
