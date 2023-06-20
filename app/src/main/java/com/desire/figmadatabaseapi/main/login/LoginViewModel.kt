package com.desire.figmadatabaseapi.main.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desire.figmadatabaseapi.database.LoginDatabase
import com.desire.figmadatabaseapi.database.UserLoginTable
import com.desire.figmadatabaseapi.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private var repo : UserRepository

    init {
        var userDao = LoginDatabase.getDatabase().loginDao()
        repo = UserRepository(userDao)
    }

    fun getUser(email : String, password : String) : MutableLiveData<UserLoginTable>{
        val observer = MutableLiveData<UserLoginTable>()
        viewModelScope.launch(Dispatchers.IO) { observer.postValue(repo.getUser(email,password)) }
        return observer
    }

}