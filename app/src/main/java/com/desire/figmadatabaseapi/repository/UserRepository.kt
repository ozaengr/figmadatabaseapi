package com.desire.figmadatabaseapi.repository

import android.os.AsyncTask
import androidx.loader.content.AsyncTaskLoader
import com.desire.figmadatabaseapi.database.LoginDao
import com.desire.figmadatabaseapi.database.LoginUser

class UserRepository (private val loginDao: LoginDao){

    suspend fun addUser(loginUser: LoginUser){
        loginDao.addLoginData(loginUser)
    }


    suspend fun getUser(email : String, pass : String): LoginUser{
        return loginDao.getLoginData(email,pass)
    }

    suspend fun deleteUser(user: LoginUser){
        loginDao.deleteUser(user.id)
    }

    suspend fun readAllData(): List<LoginUser> {
        return loginDao.readAllUsers()
        }

}