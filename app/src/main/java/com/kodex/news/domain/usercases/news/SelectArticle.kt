package com.kodex.news.domain.usercases.news

import com.kodex.news.data.local.NewsDao
import com.kodex.news.domain.model.Article

class SelectArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return  newsDao.getArticle(url)
    }
}

