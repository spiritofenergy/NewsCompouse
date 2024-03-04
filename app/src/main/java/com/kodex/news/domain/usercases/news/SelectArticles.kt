package com.kodex.news.domain.usercases.news

import com.kodex.news.data.local.NewsDao
import com.kodex.news.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles (
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
       return newsDao.getArticles()
    }
}