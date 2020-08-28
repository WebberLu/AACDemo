package com.wl.aacdemo.ui

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wl.aacdemo.data.DataModel
import com.wl.aacdemo.data.DataModel.onDataReadyCallback
import com.wl.aacdemo.data.model.Repo


/**
 * Created by KY5680 on 26,08,2020
 */
class RepoViewModel(private var dataModel: DataModel) : ViewModel() {

    var repos: MutableLiveData<List<Repo>> = MutableLiveData()

    val isLoading = ObservableBoolean(false)

    fun searchRepo(query: String) {
        isLoading.set(true)

        dataModel.searchRepo(query, object : onDataReadyCallback {
            override fun onDataReady(data: List<Repo?>?) {
                repos.postValue(data as List<Repo>?)
                isLoading.set(false)
            }
        })
    }

}