package com.desire.figmadatabaseapi.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LoginDao {

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun addLoginData(userLoginTable: UserLoginTable)

        @Query("SELECT * FROM user_login_table WHERE emailId LIKE:email AND password LIKE:pass")
        suspend fun getLoginData(email : String, pass : String): UserLoginTable
}