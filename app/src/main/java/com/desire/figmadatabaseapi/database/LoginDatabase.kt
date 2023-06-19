package com.desire.figmadatabaseapi.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.desire.figmadatabaseapi.App


@Database(entities = [EntityData::class], version = 1, exportSchema = false)
abstract class LoginDatabase : RoomDatabase() {
     abstract fun loginDao() : LoginDao

     companion object {
          @Volatile
          private var INSTANCE:LoginDatabase ?=null;

          fun getDatabase() : LoginDatabase {
               val temp = INSTANCE
               if (temp != null) {
                    return temp
               }
               synchronized(this) {
                    val instance = Room.databaseBuilder(
                         App.applicationContext(),
                         LoginDatabase::class.java,
                         "login_Data"
                    ).build()

                    INSTANCE = instance
                    return instance
               }
          }
     }
}