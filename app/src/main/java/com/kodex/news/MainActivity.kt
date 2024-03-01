package com.kodex.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.kodex.news.presentation.onboarding.OnBoardingScreen
import com.kodex.news.ui.theme.NewsCompouseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        installSplashScreen()
        setContent {
            NewsCompouseTheme {
                Box(modifier = Modifier
                    .background(color = MaterialTheme
                        .colorScheme.background)) {
                    OnBoardingScreen()
                }
            }
        }
    }
}