package com.matthew.matthewcoffix.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.matthew.matthewcoffix.data.dao.UserDao
import com.matthew.matthewcoffix.data.entity.User

@Database(
    entities = [User::class],
    version = 1,
)
abstract class DatabaseConnection : RoomDatabase() {
    abstract val userDao: UserDao
}