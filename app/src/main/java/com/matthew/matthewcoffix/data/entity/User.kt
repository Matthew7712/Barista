package com.matthew.matthewcoffix.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME = "users"

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,

    @ColumnInfo("email")
    var email: String = "",

    @ColumnInfo("password")
    var password: String = "",

    @ColumnInfo("firstName")
    var firstName: String = "",

    @ColumnInfo("lastName")
    var lastName: String = "",

    @ColumnInfo("phoneNumber")
    var phoneNumber: String = "",

    @ColumnInfo("isAuth")
    var isAuth: Boolean = false
)
