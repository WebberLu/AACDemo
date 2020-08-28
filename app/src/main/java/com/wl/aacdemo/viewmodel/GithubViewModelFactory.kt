package com.wl.aacdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wl.aacdemo.data.DataModel
import com.wl.aacdemo.ui.RepoViewModel


/**
 * Created by KY5680 on 27,08,2020
 */
class GithubViewModelFactory : ViewModelProvider.Factory {

    private val dataModel: DataModel

    constructor() {
        dataModel = DataModel()
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepoViewModel::class.java)) {
            return RepoViewModel(dataModel) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}