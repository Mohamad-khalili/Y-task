package com.mkh.news.task.data

import com.mkh.news.task.models.RepositoriesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {


    @GET("search/repositories")
    suspend fun getRepositories(@Query("q")q: String ) : Response<RepositoriesModel>
}