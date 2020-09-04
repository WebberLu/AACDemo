package com.wl.aacdemo.data.model

import androidx.annotation.NonNull
import com.google.gson.annotations.SerializedName


/**
 * Created by KY5680 on 27,08,2020
 */
class RepoSearchResponse {

    @SerializedName("total_count")
    private var total = 0

    @SerializedName("items")
    private var items: List<Repo?>? = null

    fun getTotal(): Int {
        return total
    }

    fun setTotal(total: Int) {
        this.total = total
    }

    fun getItems(): List<Repo?>? {
        return items
    }

    fun setItems(items: List<Repo?>?) {
        this.items = items
    }
}