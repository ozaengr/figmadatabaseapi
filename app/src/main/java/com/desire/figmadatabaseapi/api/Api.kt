package com.desire.figmadatabaseapi.api

import com.desire.figmadatabaseapi.response.DeleteProductResponce
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {


    //https://fakestoreapi.com/products

    @GET("products")
    fun getData() : Call<ArrayList<User>>

    @DELETE("products/{id}")
    fun deleteProduct(@Path("id")id : Int) : Call<Unit>
}