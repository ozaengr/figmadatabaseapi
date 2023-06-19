package com.desire.figmadatabaseapi.main.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desire.figmadatabaseapi.database.EntityData
import com.desire.figmadatabaseapi.database.LoginDatabase
import com.desire.figmadatabaseapi.database.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val repo : Repository

    init {
        val userDao = LoginDatabase.getDatabase().loginDao()
        repo = Repository(userDao)
    }

    fun addUser(entityData: EntityData){
        viewModelScope.launch(Dispatchers.IO) {
            repo.addUser(entityData)
        }
    }
}