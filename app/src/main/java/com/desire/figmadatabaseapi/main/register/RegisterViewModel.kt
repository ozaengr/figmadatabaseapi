package com.desire.figmadatabaseapi.main.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desire.figmadatabaseapi.database.LoginDao
import com.desire.figmadatabaseapi.database.LoginDatabase
import com.desire.figmadatabaseapi.database.LoginUser
import com.desire.figmadatabaseapi.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel  : ViewModel(){

    private val repo : UserRepository

    init {
        var userDao : LoginDao = LoginDatabase.getDatabase().loginDao()
        repo = UserRepository(userDao)
    }

    fun addUser(loginUser: LoginUser){
        viewModelScope.launch(Dispatchers.IO) {
            repo.addUser(loginUser)
        }
    }
}