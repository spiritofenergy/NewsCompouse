package com.kodex.news.presentation.bookmark

import com.kodex.news.domain.model.Article

data class BookMarkState (
    val articles : List<Article> = emptyList()
        )

