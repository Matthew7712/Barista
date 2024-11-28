package com.matthew.matthewcoffix.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.matthew.matthewcoffix.data.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    fun createUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM users WHERE email = :email AND password = :password LIMIT 1")
    fun auth(email: String, password: String): User?

    @Query("SELECT * FROM users ORDER BY email ASC")
    fun getUsersSortedByEmail(): Flow<List<User>>

    @Query("SELECT * FROM users ORDER BY password ASC")
    fun getUsersSortedByPassword(): Flow<List<User>>

    @Query("SELECT * FROM users ORDER BY phoneNumber ASC")
    fun getUsersSortedByPhoneNumber(): Flow<List<User>>
}