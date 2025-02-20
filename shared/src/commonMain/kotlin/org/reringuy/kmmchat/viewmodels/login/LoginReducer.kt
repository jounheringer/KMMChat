package org.reringuy.kmmchat.viewmodels.login

import androidx.compose.runtime.Immutable
import org.reringuy.kmmchat.helper.Reducer

class LoginReducer :
    Reducer<LoginReducer.LoginState, LoginReducer.LoginEvents, LoginReducer.LoginEffects> {
    @Immutable
    sealed class LoginEvents : Reducer.ViewEvent {
        data class OnLoginPressed(var sucess: Boolean) : LoginEvents()
        data class OnLoginLoading(val isLoading: Boolean) : LoginEvents()
        data class ShowPassword(val showPassword: Boolean) : LoginEvents()
    }

    @Immutable
    sealed class LoginEffects : Reducer.ViewEffect {
        data object Login : LoginEffects()
        data object LoginError : LoginEffects()
    }

    @Immutable
    data class LoginState(
        val loading: Boolean,
        val showPassword: Boolean
    ) : Reducer.ViewState {
        companion object {
            fun initial() = LoginState(
                loading = true,
                showPassword = false
            )
        }
    }

    override fun reduce(
        previousState: LoginState,
        event: LoginEvents
    ): Pair<LoginState, LoginEffects?> {
        when (event) {
            is LoginEvents.OnLoginLoading -> {
                return previousState.copy(
                    loading = event.isLoading
                ) to null
            }

            is LoginEvents.ShowPassword -> {
                return previousState.copy(
                    showPassword = event.showPassword
                ) to null
            }

            is LoginEvents.OnLoginPressed -> {
                return previousState to if (event.sucess)
                    LoginEffects.Login
                else
                    LoginEffects.LoginError
            }
        }
    }
}