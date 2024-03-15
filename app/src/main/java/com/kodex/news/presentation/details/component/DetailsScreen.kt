package com.kodex.news.presentation.details.component

import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kodex.news.domain.model.Article
import com.kodex.news.domain.model.Source
import com.kodex.news.presentation.onboarding.Dimens
import com.kodex.news.presentation.onboarding.Dimens.ArticleImageHeight
import com.kodex.news.presentation.onboarding.Dimens.MediumPadding1
import com.kodex.news.ui.theme.NewsAppTheme
import com.kodex.newscompouse.R

@Composable
fun DetailsScreen(
    article: Article,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
        ) {
        DetailsTopBar(
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(article.url)
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onBookmarkClick = { event(DetailsEvent.UpsertDeleteArticle(article)) },
            onBackClick = navigateUp
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = MediumPadding1,
                end = MediumPadding1,
                top = MediumPadding1
            )
        ){
            item {
                AsyncImage(
                    model = ImageRequest.Builder(context = context).data(article.urlToImage).build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ArticleImageHeight)
                        .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(MediumPadding1))

                Text(text = article.title,
                style = MaterialTheme.typography.displaySmall,
                color = colorResource(id = R.color.text_title)
                )
              Row(verticalAlignment = Alignment.CenterVertically) {
                  Text(text = "Author: " + article.source.name,
                      style = MaterialTheme.typography.bodyLarge.
                      copy(fontWeight = FontWeight.Bold),
                      color = colorResource(id = R.color.body))
                  //отступ
                  Spacer(modifier = Modifier.width(Dimens.ExtraSmallPadding2))
                  //часы
                  Icon(painter = painterResource(id = R.drawable.ic_time), contentDescription = null, modifier = Modifier.size(
                      Dimens.SmallIconSize
                  ), tint = colorResource(id = R.color.body))
                  //отступ
                  Spacer(modifier = Modifier.width(Dimens.ExtraSmallPadding2))
                  // часов
                  Text(
                      text = article.publishedAt,
                      style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                      color = colorResource(
                          id = R.color.body)
                  )
              }
                Spacer(modifier = Modifier.width(Dimens.ExtraSmallPadding2))

                Text(modifier = Modifier.height(ArticleImageHeight),
                text = article.content,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.body)
                )

            }
        }
    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DetailsScreenPreview (){
    NewsAppTheme(
        dynamicColor = false
    ) {
        DetailsScreen(article = Article(
            author = "",
            title = "Для путешествия вы можете найти",
            description = "Jetpack Compose Clean Architecture News App",
            content = "\n" +
                    "Все /v2/everything – выполняйте поиск по каждой статье, опубликованной более чем в 80 000 различных крупных и мелких источниках за последние 5 лет. Эта конечная точка идеально подходит для анализа новостей и поиска статей.\n" +
                    "Главные заголовки /v2/top-headlines – возвращает заголовки последних новостей для стран, категорий и отдельных издателей. Это идеально подходит для использования с тикерами новостей или в любом другом месте, где вы хотите использовать актуальные заголовки новостей.\n" +
                    "Существует также второстепенная конечная точка, которую можно использовать для получения небольшого подмножества издателей, которые мы можем сканировать:\n" +
                    "\n" +
                    "Источники /v2/top-headlines/sources – возвращает информацию (включая название, описание и категорию) о наиболее заметных источниках, доступных для получения главных заголовков. Этот список может быть передан непосредственно вашим пользователям при показе им некоторых доступных опций.Details Screen - Jetpack Compose Clean Architecture News App - part 14. Jetpack Compose Clean Architecture News App etpack Compose Clean Architecture News App - part 14. Jetpack Compose Clean Architecture News App - part ? Jetpack Compose Clean Architecture News App - part .Jetpack Compose Clean Architecture News App - part / Jetpack Compose Clean Architecture News App - part  Jetpack Compose Clean Architecture News App - part ",
            publishedAt = "2 часа",
            source = Source(id = "", name = "РИА"),

            url = "https://developer.android.com/jetpack/compose/tooling#preview",
            urlToImage = "https://market.yandex.ru/product--sorochka-nochnaia-zhenskaia/1933385080?sku=102394588544&do-waremd5=BlkZIHZ-bEUH8fgS3_kXkg&uniqueId=80879024"

        ), event = {}) {

        }

    }

}
