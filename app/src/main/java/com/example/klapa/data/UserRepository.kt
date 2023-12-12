package com.example.klapa.data

import com.example.klapa.data.pref.UserModel
import com.example.klapa.data.pref.UserPreference
import kotlinx.coroutines.flow.Flow

class UserRepository private constructor(
    private val userPreference: UserPreference
) {
    suspend fun saveSession(user : UserModel){
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel>{
        return userPreference.getSession()
    }
    suspend fun logout(){
        userPreference.logout()
    }
    companion object{
        @Volatile
        private var instance : UserRepository? = null
        fun getInstance(
            UserPreference: UserPreference
        ): UserRepository =
            instance ?: synchronized(this){
                instance ?: UserRepository(UserPreference)
            }.also { instance = it }
    }
}