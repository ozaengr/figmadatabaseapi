package com.desire.figmadatabaseapi.repository

import com.desire.figmadatabaseapi.database.LoginDao
import com.desire.figmadatabaseapi.database.UserLoginTable

class UserRepository (private val loginDao : LoginDao){

    suspend fun addUser(userLoginTable: UserLoginTable){
        loginDao.addLoginData(userLoginTable)
    }

    suspend fun getUser(email : String, pass : String) : UserLoginTable{
        return loginDao.getLoginData(email,pass)
    }
}