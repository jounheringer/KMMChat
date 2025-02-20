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
import androidx.compose.material3.Button
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.reringuy.kmmchat.helper.rememberFlowWithLifecycle
import org.reringuy.kmmchat.utils.navigateToMain
import org.reringuy.kmmchat.utils.showToast
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

    val state by viewModel.state.collectAsState()
    val effects = rememberFlowWithLifecycle(viewModel.effect)

    LaunchedEffect(viewModel) {
        effects.collect {
            when (it) {
                LoginReducer.LoginEffects.Login -> {
                    navigateToMain()
                }

                LoginReducer.LoginEffects.LoginError -> {
                    showToast("Erro ao realizar login")
                }
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
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            loginForm(
                showPassword = state.showPassword,
                username = username,
                password = password,
                onEvent = { onEvent(LoginReducer.LoginEvents.ShowPassword(it)) }
            ) { auxUsername, auxPassword ->
                username = auxUsername
                password = auxPassword
            }

            loginButton{
                onEvent(LoginReducer.LoginEvents.OnLoginPressed(false))
                onEvent(LoginReducer.LoginEvents.OnLoginLoading(!state.loading))
            }
        }
    }
}

@Composable
fun loginButton(onEvent: () -> Unit) {
    Button(
        onClick = onEvent
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun loginForm(
    showPassword: Boolean,
    username: String,
    password: String,
    onEvent: (Boolean) -> Unit,
    onFormChange: (username: String, password: String) -> Unit
) {

    OutlinedTextField(
        value = username,
        onValueChange = { onFormChange(it, password) },
        label = { Text(text = "Usuario") },
        placeholder = { Text(text = "Reringuy") }
    )
    OutlinedTextField(
        value = password,
        onValueChange = { onFormChange(username, it) },
        visualTransformation = if (showPassword) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            IconToggleButton(
                checked = showPassword,
                onCheckedChange = { onEvent(!showPassword) }
            ) {
                Icon(
                    modifier = Modifier.size(48.dp),
                    contentDescription = "Mostrar senha",
                    imageVector = if (showPassword)
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
