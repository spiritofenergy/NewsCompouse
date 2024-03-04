package com.kodex.news.presentation.search

import androidx.paging.PagingData
import androidx.room.Query
import com.kodex.news.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState (
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
){
}