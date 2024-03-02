package com.kodex.news.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kodex.news.domain.model.Article
import com.kodex.news.domain.model.Source
import com.kodex.news.presentation.onboarding.Dimens.ArticleCardSize
import com.kodex.news.presentation.onboarding.Dimens.ExtraSmallPadding
import com.kodex.news.presentation.onboarding.Dimens.ExtraSmallPadding2
import com.kodex.news.presentation.onboarding.Dimens.SmallIconSize
import com.kodex.news.ui.theme.NewsAppTheme
import com.kodex.newscompouse.R
import dagger.Provides

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick:()-> Unit
){
    val context = LocalContext.current

    Row(modifier = modifier.clickable { onClick()}){
        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
         //   contentScale = ContentScale.Crop
        )
        Column(verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)) {
            // текст
            Text(text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)
            //2 ряд
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body))
                    //отступ
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                    //часы
                Icon(painter = painterResource(id = R.drawable.ic_time), contentDescription = null, modifier = Modifier.size(SmallIconSize), tint = colorResource(id = R.color.body))
                    //отступ
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                    // часов
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(
                        id = R.color.body)
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview(){
NewsAppTheme {
    ArticleCard(article = Article(
        author = "",
        content = "",
        description = "",
        publishedAt = "2 часа",
        source = Source(id = "", name = "РИА"),
        title = "Для путешествия вы можете найти подходящий номер и выгодно забронировать его без комиссии и без переплаты. Это можно сделать с любого устройства буквально в два-три клика.",
        url = "",
        urlToImage = ""
         //urlToImage = "https://ichef.bbci.co.uk/live-experience/cps/624/cpsprodpb/11787/production/_124395517_bbcbreakingnewsgraphic.jpg"
    )) {

    }
}
}

