package com.kodex.news.di

import android.app.Application
import com.kodex.news.data.manager.LocalUserManagerImpl
import com.kodex.news.data.remote.NewsApi
import com.kodex.news.data.repository.NewsRepositoryImpl
import com.kodex.news.domain.manager.LocalUserManager
import com.kodex.news.domain.repository.NewsRepository
import com.kodex.news.domain.usercases.app_entry.AppEntryUseCases
import com.kodex.news.domain.usercases.app_entry.ReadAppEntry
import com.kodex.news.domain.usercases.app_entry.SaveAppEntry
import com.kodex.news.domain.usercases.news.GetNews
import com.kodex.news.domain.usercases.news.NewsUseCases
import com.kodex.news.domain.usercases.news.SearchNews
import com.kodex.news.ui.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)




    @Provides
    @Singleton
    fun provideNewsUseCase(
        newsRepository: NewsRepository
    ): NewsUseCases{
        return  NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }
}