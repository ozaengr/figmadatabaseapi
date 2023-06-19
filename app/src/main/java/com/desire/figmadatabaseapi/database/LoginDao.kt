package com.desire.figmadatabaseapi.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLoginData(entityData: EntityData)

    @Query("SELECT * FROM login_data WHERE emailId LIKE:email AND password LIKE:pass")
    suspend fun getLoginData(email : String, pass : String) : EntityData

    @Query("SELECT * FROM login_data ORDER BY id ASC")
    fun readAllUsers(): LiveData<List<EntityData>>

    @Insert
    suspend fun insertAll(vararg users: EntityData)

    @Update
    suspend fun updateUser(loginDataClass: EntityData)

    @Delete
    suspend fun deleteUser(loginDataClass: EntityData)

    @Query("DELETE FROM login_data")
    fun deleteAll()
}