package com.wl.aacdemo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by KY5680 on 27,08,2020
 */
class RetrofitManager {

    private var githubService: GithubService

    companion object {
        private val mInstance = RetrofitManager()
        fun getAPI(): GithubService = mInstance.githubService
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        githubService = retrofit.create(GithubService::class.java)
    }
}