package com.kodex.news.domain.usercases.app_entry

import com.kodex.news.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
     operator fun invoke() : Flow<Boolean> {
      return  localUserManager.readAppEntry()

    }
}