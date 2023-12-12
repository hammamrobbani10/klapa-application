package com.example.klapa.di

import android.content.Context
import com.example.klapa.data.UserRepository
import com.example.klapa.data.pref.UserPreference
import com.example.klapa.data.pref.dataStore

object Injection {
    fun provideRepository(context:Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(pref)
    }
}