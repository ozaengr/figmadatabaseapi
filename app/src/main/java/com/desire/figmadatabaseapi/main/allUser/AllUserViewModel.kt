package com.desire.figmadatabaseapi.main.allUser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desire.figmadatabaseapi.database.LoginDatabase
import com.desire.figmadatabaseapi.database.LoginUser
import com.desire.figmadatabaseapi.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllUserViewModel : ViewModel() {

    private val repo : UserRepository

    init {
        val loginDao = LoginDatabase.getDatabase().loginDao()
        repo = UserRepository(loginDao)
    }

    fun getData(): LiveData<List<LoginUser>>{
        val observer = MutableLiveData<List<LoginUser>>()
        viewModelScope.launch (Dispatchers.IO){
            observer.postValue(repo.readAllData())
        }
        return observer
    }
    fun deleteData(user: LoginUser): MutableLiveData<Boolean> {
        val observer = MutableLiveData<Boolean>()
        viewModelScope.launch(Dispatchers.IO){
            repo.deleteUser(user)
            observer.postValue(true)
        }
        return observer
    }
}