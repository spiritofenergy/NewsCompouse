package com.kodex.news.domain.usercases.news

import com.kodex.news.data.local.NewsDao
import com.kodex.news.domain.model.Article
import com.kodex.news.domain.repository.NewsRepository

class UpsertArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article){
            newsRepository.upsertArticle(article)
    }
}