package com.kodex.news.domen.usercases

import com.kodex.news.domen.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}