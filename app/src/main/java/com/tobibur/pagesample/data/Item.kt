package com.tobibur.pagesample.data


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("default_branch")
    val defaultBranch: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("forks")
    val forks: Int,
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("private")
    val `private`: Boolean,
    @SerializedName("url")
    val url: String
)