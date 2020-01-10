package com.tobibur.pagesample.network

import com.tobibur.pagesample.data.RepositoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/search/repositories")
    suspend fun getRepos(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") limit: Int = 10
    ): RepositoryResponse
}