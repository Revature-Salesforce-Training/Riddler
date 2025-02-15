package com.example.riddler

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetroApiInterface {
    //singleton
    /*@GET("api.php?amount={amount}&category={category}&difficulty={difficulty}&type={type}")
    suspend fun getAllTriviaQuestions(@Path("amount") amount:Int, @Path("category") category:Int,
    @Path("difficulty") difficulty:String, @Path("type") type:String): Response<TriviaQuestions>*/

    @GET("api.php")
    suspend fun getAllTriviaQuestions(@Query("amount") amount:Int, @Query("category") category:Int,
                                      @Query("difficulty") difficulty:String, @Query("type") type:String): Response<TriviaQuestions>

    companion object {
        var BASE_URL = "https://opentdb.com/"
        fun create(): RetroApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetroApiInterface::class.java)
        }
    }
}