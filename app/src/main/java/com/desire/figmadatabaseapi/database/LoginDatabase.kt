package com.desire.figmadatabaseapi.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.desire.figmadatabaseapi.App
import com.desire.figmadatabaseapi.api.User

@Database(entities = [LoginUser::class], version = 1, exportSchema = false)
abstract class LoginDatabase : RoomDatabase() {

    abstract fun loginDao(): LoginDao

    companion object {
        @Volatile
        private var INSTANCE: LoginDatabase ?= null

        fun getDatabase(): LoginDatabase {
            var temp = INSTANCE
            if (temp != null) {
                return temp
            }
            synchronized(lock = this) {
                var instance = Room.databaseBuilder(
                    App.applicationContext(),
                    LoginDatabase::class.java,
                    "user_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}