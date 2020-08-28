package com.wl.aacdemo.api

import com.wl.aacdemo.data.model.RepoSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by KY5680 on 27,08,2020
 */
interface GithubService {
    @GET("search/repositories")
    fun searchRepos(@Query("q") query: String): Call<RepoSearchResponse>?
}