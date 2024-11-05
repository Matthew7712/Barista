package com.matthew.matthewcoffix.data.event

import com.matthew.matthewcoffix.data.SortType
import com.matthew.matthewcoffix.data.entity.User

sealed interface UserEvent {
    object SaveUser: UserEvent
    data class AddUser(val email: String, val password: String): UserEvent
    data class SetEmail(val email: String): UserEvent
    data class SetAuth(val isAuth: Boolean): UserEvent
    data class SetPassword(val password: String): UserEvent
    data class SetFirstName(val firstName: String): UserEvent
    data class SetLastName(val lastName: String): UserEvent
    data class SetPhoneNumber(val phoneNumber: String): UserEvent
    data class SortUsers(val sortType: SortType): UserEvent
    data class DeleteUser(val user: User): UserEvent
}