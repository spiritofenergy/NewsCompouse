package com.kodex.news.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kodex.news.presentation.common.NewsButton
import com.kodex.news.presentation.common.NewsTextButton
import com.kodex.news.presentation.common.PagerIndicator
import com.kodex.news.presentation.onboarding.Dimens.MediumPadding2
import com.kodex.news.presentation.onboarding.components.OnBoardingPage
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
event: (OnBoardingEvent) ->Unit
) {
        Column(modifier = Modifier.fillMaxSize()) {
            val pagerState = rememberPagerState(initialPage = 0) {
                pages.size
            }
            val buttonState = remember {
                derivedStateOf {
                    when(pagerState.currentPage){
                        0 -> listOf("", "Вперед")
                        1 -> listOf("Назад", "Вперед")
                        2 -> listOf("Назад", "Начать")
                        else -> listOf("", "")
                    }
                }
            }
            HorizontalPager(state = pagerState) { index ->
                OnBoardingPage(page = pages[index])
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MediumPadding2)
                    .navigationBarsPadding(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                PagerIndicator(
                    modifier = Modifier.width(52.dp),
                    pagesSize = pages.size,
                    selectedPage = pagerState.currentPage
                )

            Row(verticalAlignment = Alignment.CenterVertically) {

                val scope = rememberCoroutineScope()



                if (buttonState.value[0].isNotEmpty()){
                    NewsTextButton(text = buttonState.value[0],
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                        }

                    }
                )

                }
                NewsButton(
                    text = buttonState.value[1],
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage == 2) {
                                    event(OnBoardingEvent.SaveAppEntry)
                            }else{
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )

                            }
                        }
                })

            }

        }
            Spacer(modifier = Modifier.weight(0.5f))
    }
}