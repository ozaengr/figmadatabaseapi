package com.desire.figmadatabaseapi.database

import androidx.lifecycle.LiveData
import com.desire.figmadatabaseapi.database.EntityData
import androidx.room.Dao

class Repository (private val loginDao: LoginDao) {

    var readAllData : LiveData<List<EntityData>> = loginDao.readAllUsers()

    suspend fun addUser(entityData: EntityData){
        loginDao.insertLoginData(entityData)
    }

    suspend fun updateUser(entityData: EntityData){
        loginDao.updateUser(entityData)
    }

    suspend fun deleUser(entityData: EntityData){
        loginDao.deleteUser(entityData)
    }

    suspend fun deleteAll(){
        loginDao.deleteAll()
    }

    suspend fun getUser(email : String,password : String): EntityData {
        return loginDao.getLoginData(email,password)

    }
}