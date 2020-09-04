package com.wl.aacdemo.data.model

import androidx.annotation.NonNull
import com.google.gson.annotations.SerializedName

/**
 * Created by KY5680 on 04,09,2020
 */
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