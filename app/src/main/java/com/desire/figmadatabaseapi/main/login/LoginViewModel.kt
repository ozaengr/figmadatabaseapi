package com.desire.figmadatabaseapi.main.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desire.figmadatabaseapi.database.EntityData
import com.desire.figmadatabaseapi.database.LoginDatabase
import com.desire.figmadatabaseapi.database.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val repo : Repository

    init {
        val userDao = LoginDatabase.getDatabase().loginDao()
        repo = Repository(userDao)
    }
    fun getUser(email : String, password : String) : MutableLiveData<EntityData>{
        val observer = MutableLiveData<EntityData>()
        viewModelScope.launch(Dispatchers.IO){
            observer.postValue(repo.getUser(email,password))
        }
        return observer
    }
}