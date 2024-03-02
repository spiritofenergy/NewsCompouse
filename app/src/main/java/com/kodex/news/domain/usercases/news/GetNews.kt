package com.kodex.news.domain.usercases.news

import androidx.paging.PagingData
import com.kodex.news.domain.model.Article
import com.kodex.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow


class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}