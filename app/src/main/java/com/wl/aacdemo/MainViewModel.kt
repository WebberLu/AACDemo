package com.wl.aacdemo

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wl.aacdemo.DataModel.onDataReadyCallback


/**
 * Created by KY5680 on 26,08,2020
 */
class MainViewModel : ViewModel() {

    var mData: MutableLiveData<String> = MutableLiveData()

    var mToastText: SingleLiveEvent<String> = SingleLiveEvent()

    val isLoading = ObservableBoolean(false)

    private val dataModel = DataModel()

    fun refresh() {
        isLoading.set(true)

        dataModel.retrieveData(object : onDataReadyCallback {
            override fun onDataReady(data: String?) {
                mData.postValue(data)
                mToastText.postValue(data)
                isLoading.set(false)
            }
        })
    }
}