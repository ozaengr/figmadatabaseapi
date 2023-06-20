package com.desire.figmadatabaseapi.main.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desire.figmadatabaseapi.database.LoginDatabase
import com.desire.figmadatabaseapi.database.UserLoginTable
import com.desire.figmadatabaseapi.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private var repo : UserRepository

    init {
        val userDao = LoginDatabase.getDatabase().loginDao()
        repo = UserRepository(userDao)
    }
    fun addUser(userLoginTable: UserLoginTable){
        viewModelScope.launch(Dispatchers.IO){
            repo.addUser(userLoginTable)
        }
    }
}