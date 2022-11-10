package com.example.cardview_recyclerview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class User(
    var firstName : String,
    var lastName : String,
    var userName : String,
    var age : Int,
    var aboutMe : String,
    var image : String

)