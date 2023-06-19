package com.desire.figmadatabaseapi.retrofit

import com.desire.figmadatabaseapi.home.RcvModel
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    //https://fakestoreapi.com/products
    @GET("products")
    fun getData(): Call<ArrayList<RcvModel>>



    //https://fakestoreapi.com/products/1

    @GET("products/{id}")
    fun getproductwithpid(@Path("id") id:Int):Call<RcvModel>

}
