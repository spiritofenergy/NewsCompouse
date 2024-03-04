package com.kodex.news.presentation.details.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.kodex.news.domain.model.Article


sealed class DetailsEvent {
    object SaveArticle : DetailsEvent()
}