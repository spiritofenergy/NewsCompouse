package com.kodex.news.presentation.details.component

import com.kodex.news.domain.model.Article


sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect :DetailsEvent()
}