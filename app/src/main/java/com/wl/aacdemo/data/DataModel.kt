package com.wl.aacdemo.data

import com.wl.aacdemo.data.model.Repo
import com.wl.aacdemo.data.model.RepoSearchResponse
import com.wl.aacdemo.api.GithubService
import com.wl.aacdemo.api.RetrofitManager
import retrofit2.Call
import retrofit2.Response


/**
 * Created by KY5680 on 26,08,2020
 */
class DataModel {

    private val githubService: GithubService = RetrofitManager.getAPI()

    interface onDataReadyCallback {
        fun onDataReady(data: List<Repo?>?)
    }

    fun searchRepo(query: String, callback: onDataReadyCallback) {
        githubService.searchRepos(query)?.enqueue(object : retrofit2.Callback<RepoSearchResponse> {
            override fun onResponse(
                call: Call<RepoSearchResponse>,
                response: Response<RepoSearchResponse>
            ) {
                callback.onDataReady(response.body()?.getItems())
            }

            override fun onFailure(call: Call<RepoSearchResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}