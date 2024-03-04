package com.kodex.news.domain.usercases.news

import com.kodex.news.data.local.NewsDao
import com.kodex.news.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
            newsDao.upsert(article)
    }
}