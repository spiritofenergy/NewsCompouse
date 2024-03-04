package com.kodex.news.domain.repository

import android.app.DownloadManager.Query
import androidx.paging.PagingData
import com.kodex.news.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String> ): Flow<PagingData<Article>>

    fun searchNews(searchQuery: String, sources: List<String> ): Flow<PagingData<Article>>
}