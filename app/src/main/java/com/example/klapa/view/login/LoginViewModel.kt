package com.example.klapa.view.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.klapa.data.UserRepository
import com.example.klapa.data.pref.UserModel
import kotlinx.coroutines.launch

class LoginViewModel (private val repository: UserRepository):ViewModel(){
    fun saveSession(user: UserModel){
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }
}