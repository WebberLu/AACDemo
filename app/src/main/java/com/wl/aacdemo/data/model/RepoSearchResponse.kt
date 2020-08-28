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

class Repo {

    val id = 0

    @SerializedName("name")
    @NonNull
    val name: String? = null

    @SerializedName("full_name")
    val fullName: String? = null

    @SerializedName("description")
    val description: String? = null

    @SerializedName("stargazers_count")
    val stars = 0

    @SerializedName("owner")
    val owner: Owner? = null

}

class Owner {
    @SerializedName("login")
    val login: String? = null

    @SerializedName("avatar_url")
    val avatarUrl: String? = null

    @SerializedName("url")
    val url: String? = null

}