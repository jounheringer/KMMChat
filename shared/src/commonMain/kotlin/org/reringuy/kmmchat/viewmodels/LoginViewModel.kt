package org.reringuy.kmmchat.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.annotation.Singleton
import org.reringuy.kmmchat.models.ResponseEntity

@Singleton(createdAtStart = true)
class LoginViewModel : ViewModel() {
    private val _loginState = MutableStateFlow<ResponseEntity<Boolean>>(ResponseEntity.Loading)

    val loginState = _loginState

    fun login() {
        _loginState.value = ResponseEntity.Success(true)
    }

    fun logged() = "Acredito que esteja logado"
}