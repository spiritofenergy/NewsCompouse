package com.kodex.news.domain.usercases.news

import com.kodex.news.domain.model.Article
import com.kodex.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles (
    private val newsRepository: NewsRepository
) {

    operator fun invoke(): Flow<List<Article>> {
       return newsRepository.selectArticle()
    }
}