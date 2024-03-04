package com.kodex.news.domain.usercases.news

import androidx.paging.PagingData
import com.kodex.news.data.remote.SearchNewsPagingSource
import com.kodex.news.domain.model.Article
import com.kodex.news.domain.repository.NewsRepository
import com.kodex.news.presentation.search.SearchEvent
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {


    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>{
        return newsRepository.searchNews(searchQuery = searchQuery, sources = sources)
    }
}