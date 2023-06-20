package com.desire.figmadatabaseapi.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "user_login_table")
data class UserLoginTable(

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var name : String = "",
    var emailId : String = "",
    var password : String = "",

): Parcelable
