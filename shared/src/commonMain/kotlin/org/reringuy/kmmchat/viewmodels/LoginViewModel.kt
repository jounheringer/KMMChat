package org.reringuy.kmmchat.viewmodels

import org.koin.core.annotation.Factory
import org.reringuy.kmmchat.helper.BaseViewModel
import org.reringuy.kmmchat.viewmodels.login.LoginReducer

@Factory
class LoginViewModel : BaseViewModel<LoginReducer.LoginState, LoginReducer.LoginEvents, LoginReducer.LoginEffects>(
    initialState = LoginReducer.LoginState.initial(),
    reducer = LoginReducer()
) {

    fun onEvent(event: LoginReducer.LoginEvents) {
        when (event) {
            is LoginReducer.LoginEvents.OnLoginLoading -> {
                sendEventForEffect(event)
            }
            is LoginReducer.LoginEvents.ShowPassword -> {
                sendEvent(event)
            }

            is LoginReducer.LoginEvents.OnLoginPressed -> {
                event.sucess = false
                sendEventForEffect(event)
            }
        }
    }

}