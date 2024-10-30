package com.matthew.matthewcoffix.data.state

import com.matthew.matthewcoffix.data.SortType
import com.matthew.matthewcoffix.data.entity.User

data class UserState(
    val users: List<User> = emptyList(),
    val email: String = "",
    val password: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val isAddingContact: Boolean = false,
    val sortType: SortType = SortType.EMAIL
)