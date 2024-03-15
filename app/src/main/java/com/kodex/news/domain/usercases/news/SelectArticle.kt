package com.kodex.news.domain.usercases.news

import com.kodex.news.domain.model.Article
import com.kodex.news.domain.repository.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(url: String): Article?{
        return  newsRepository.selectArticle(url)
    }
}

