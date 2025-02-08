package org.reringuy.kmmchat.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.reringuy.kmmchat.helper.rememberFlowWithLifecycle
import org.reringuy.kmmchat.viewmodels.LoginViewModel
import org.reringuy.kmmchat.viewmodels.login.LoginReducer

@Composable
fun LoginWrapper() {
    val viewModel = getViewModel(
        key = "login-screen",
        factory = viewModelFactory {
            LoginViewModel()
        }
    )

    val state by viewModel.state.collectAsStateWithLifecycle()
    val effects = rememberFlowWithLifecycle(viewModel.effect)

    LaunchedEffect(viewModel) {
        effects.collect {
            when (it){
                LoginReducer.LoginEffects.Login -> {  }
                LoginReducer.LoginEffects.LoginError -> {  }
            }
        }
    }

    LoginScreen(
        state = state,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun LoginScreen(
    state: LoginReducer.LoginState,
    onEvent: (LoginReducer.LoginEvents) -> Unit
) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = username.value,
                onValueChange = { username.value = it },
                label = { Text(text = "Usuario") },
                placeholder = { Text(text = "Reringuy") }
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                visualTransformation = if (!state.showPassword) PasswordVisualTransformation() else VisualTransformation.None,
                trailingIcon = {
                    IconToggleButton(
                        checked = state.showPassword,
                        onCheckedChange = { onEvent(LoginReducer.LoginEvents.ShowPassword(!state.showPassword)) }
                    ) {
                        Icon(
                            modifier = Modifier.size(48.dp),
                            contentDescription = "Mostrar senha",
                            imageVector = if (!state.showPassword)
                                Icons.Outlined.Close
                            else
                                Icons.Outlined.Check
                        )
                    }
                },
                label = { Text(text = "Usuario") },
                placeholder = { Text(text = "Reringuy") }
            )
        }
    }

}
