package com.kodex.news.di

import android.app.Application
import com.kodex.news.data.manager.LocalUserManagerImpl
import com.kodex.news.domain.manager.LocalUserManager
import com.kodex.news.domain.usercases.app_entry.AppEntryUseCases
import com.kodex.news.domain.usercases.app_entry.ReadAppEntry
import com.kodex.news.domain.usercases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}