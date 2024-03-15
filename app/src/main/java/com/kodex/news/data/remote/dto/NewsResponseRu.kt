package com.kodex.news.data.remote.dto


import com.google.gson.annotations.SerializedName

data class NewsResponseRu(
    @SerializedName("articles")
    var articles: List<Article>,
    @SerializedName("status")
    var status: String,
    @SerializedName("totalResults")
    var totalResults: Int
)