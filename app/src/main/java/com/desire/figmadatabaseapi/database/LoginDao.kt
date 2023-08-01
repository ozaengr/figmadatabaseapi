package com.desire.figmadatabaseapi.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LoginDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLoginData(loginUser: LoginUser)

    @Query("SELECT * FROM user_login_table WHERE emailId LIKE:email AND password LIKE:password")
    suspend fun getLoginData(email: String, password : String): LoginUser

    @Query("DELETE FROM user_login_table WHERE id =:id")
    suspend fun deleteUser(id : Int?)

    @Query("SELECT * FROM user_login_table ORDER BY id ASC")
    fun readAllUsers(): MutableList<LoginUser>
}