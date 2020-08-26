package com.wl.aacdemo

import android.os.Handler


/**
 * Created by KY5680 on 26,08,2020
 */
class DataModel {

    interface onDataReadyCallback {
        fun onDataReady(data: String?)
    }

    fun retrieveData(callback: onDataReadyCallback){
        Handler().postDelayed({ callback.onDataReady("New Data") }, 1500)
    }
}