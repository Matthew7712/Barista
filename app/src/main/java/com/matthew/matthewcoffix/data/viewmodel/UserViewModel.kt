package com.matthew.matthewcoffix.data.viewmodel

import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matthew.matthewcoffix.data.SortType
import com.matthew.matthewcoffix.data.dao.UserDao
import com.matthew.matthewcoffix.data.entity.User
import com.matthew.matthewcoffix.data.event.UserEvent
import com.matthew.matthewcoffix.data.state.UserState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(private val userDao: UserDao) : ViewModel() {
    private val _sortType = MutableStateFlow(SortType.EMAIL)
    private val _contacts = _sortType
        .flatMapLatest { sortType ->
            when(sortType) {
                SortType.EMAIL -> userDao.getUsersSortedByEmail()
                SortType.PASSWORD -> userDao.getUsersSortedByPassword()
                SortType.PHONE_NUMBER -> userDao.getUsersSortedByPhoneNumber()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(UserState())
    val state = combine(_state, _sortType, _contacts) { state, sortType, contacts ->
        state.copy(
            users = contacts,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UserState())

    fun authenticateUser(email: String, password: String, onSuccess: () -> Unit, onError: () -> Unit) {
        val isAuth: Boolean = true
        viewModelScope.launch {
            val user = withContext(Dispatchers.IO) {
                userDao.auth(email, password)
            }
            if (user != null) {
                onSuccess() // Успешная аутентификация
            } else {
                onError() // Ошибка аутентификации
            }
        }
    }

    fun onEvent(event: UserEvent) {
        when(event) {
            is UserEvent.AddUser -> {
                val newUser = User(
                    email = event.email,
                    password = event.password,
                    firstName = "",
                    lastName = "",
                    phoneNumber = "",
                    isAuth = true
                )
                viewModelScope.launch(Dispatchers.IO) {
                    userDao.createUser(newUser)
                }
            }
            is UserEvent.DeleteUser -> {
                viewModelScope.launch(Dispatchers.IO) {
                    userDao.deleteUser(event.user)
                }
            }
            UserEvent.SaveUser -> {
                val email = state.value.email
                val password = state.value.password
                if(email.isBlank() || password.isBlank()) {
                    return
                }

                val user = User(
                    email = email,
                    password = password,
                    isAuth = true
                )
                viewModelScope.launch(Dispatchers.IO) {
                    userDao.createUser(user)
                }
                _state.update { it.copy(
                    isAddingContact = false,
                    email = "",
                    password = "",
                ) }
            }
            is UserEvent.SetEmail -> {
                _state.update { it.copy(
                    firstName = event.email
                ) }
            }

            is UserEvent.SetAuth -> {
                _state.update { it.copy(
                    isAuth = true
                ) }
            }
            is UserEvent.SetPassword -> {
                _state.update { it.copy(
                    lastName = event.password
                ) }
            }
            is UserEvent.SetFirstName -> {
                _state.update { it.copy(
                    firstName = event.firstName
                ) }
            }
            is UserEvent.SetLastName -> {
                _state.update { it.copy(
                    lastName = event.lastName
                ) }
            }
            is UserEvent.SetPhoneNumber -> {
                _state.update { it.copy(
                    phoneNumber = event.phoneNumber
                ) }
            }
            is UserEvent.SortUsers -> {
                _sortType.value = event.sortType
            }
        }
    }
}