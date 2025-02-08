package org.reringuy.kmmchat.viewmodels

import org.koin.core.annotation.Singleton
import org.reringuy.kmmchat.helper.BaseViewModel
import org.reringuy.kmmchat.viewmodels.login.LoginReducer

@Singleton(createdAtStart = true)
class LoginViewModel : BaseViewModel<LoginReducer.LoginState, LoginReducer.LoginEvents, LoginReducer.LoginEffects>(
    initialState = LoginReducer.LoginState.initial(),
    reducer = LoginReducer()
) {

    fun onEvent(event: LoginReducer.LoginEvents) {
        sendEvent(event)
    }

}