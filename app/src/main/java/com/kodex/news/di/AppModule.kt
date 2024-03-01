package com.kodex.news.di

import android.app.Application
import com.kodex.news.data.manager.LocalUserManagerImpl
import com.kodex.news.domen.manager.LocalUserManager
import com.kodex.news.domen.usercases.AppEntryUseCases
import com.kodex.news.domen.usercases.ReadAppEntry
import com.kodex.news.domen.usercases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.lang.Appendable
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