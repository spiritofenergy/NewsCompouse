package com.kodex.news.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.kodex.news.domain.model.Article

data class NewsResponse(
    @SerializedName("articles")
    var articles: List<Article>,
    @SerializedName("status")
    var status: String,
    @SerializedName("totalResults")
    var totalResults: Int
)