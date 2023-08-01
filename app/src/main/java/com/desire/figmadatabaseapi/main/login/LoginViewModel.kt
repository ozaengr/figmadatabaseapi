package com.desire.figmadatabaseapi.main.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desire.figmadatabaseapi.database.LoginDatabase
import com.desire.figmadatabaseapi.database.LoginUser
import com.desire.figmadatabaseapi.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val repo : UserRepository

    init {
        val userDao = LoginDatabase.getDatabase().loginDao()
        repo = UserRepository(userDao)
    }

    fun getData(email : String, pass : String): MutableLiveData<LoginUser> {
        val observer = MutableLiveData<LoginUser>()
        viewModelScope.launch (Dispatchers.IO){
            observer.postValue(repo.getUser(email, pass))
        }
        return observer
    }
}