package com.tobibur.pagesample.data


import com.google.gson.annotations.SerializedName
import com.tobibur.pagesample.data.Item

data class RepositoryResponse(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total_count")
    val totalCount: Int
)