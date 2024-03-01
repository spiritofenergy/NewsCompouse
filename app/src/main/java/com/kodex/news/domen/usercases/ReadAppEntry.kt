package com.kodex.news.domen.usercases

import com.kodex.news.domen.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
     operator fun invoke() : Flow<Boolean> {
      return  localUserManager.readAppEntry()

    }
}