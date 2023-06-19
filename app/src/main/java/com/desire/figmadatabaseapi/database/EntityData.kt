package com.desire.figmadatabaseapi.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "login_data")
data class EntityData(

    @PrimaryKey(autoGenerate = true)
    var id : Long = 0,
    var name : String = "",
    var emailId : String = "",
    var password : String = "",
): Parcelable