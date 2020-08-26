package com.wl.aacdemo

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.wl.aacdemo.DataModel.onDataReadyCallback


/**
 * Created by KY5680 on 26,08,2020
 */
class MainViewModel {

    val mData = ObservableField<String>()

    val isLoading = ObservableBoolean(false)

    private val dataModel = DataModel()

    fun refresh() {
        isLoading.set(true)

        dataModel.retrieveData(object : onDataReadyCallback {
            override fun onDataReady(data: String?) {
                mData.set(data)
                isLoading.set(false)
            }
        })
    }
}