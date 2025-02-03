package org.reringuy.kmmchat.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.reringuy.kmmchat.viewmodels.LoginViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = koinViewModel()
) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val showPassword = remember { mutableStateOf(false) }
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = viewModel.logged())
        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text(text = "Usuario") },
            placeholder = { Text(text = "Reringuy") }
        )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            visualTransformation = PasswordVisualTransformation(),
            trailingIcon = {
                IconToggleButton(
                    checked = showPassword.value,
                    onCheckedChange = { showPassword.value = !showPassword.value }
                ) {
                    Icon(
                        modifier = modifier.size(48.dp),
                        contentDescription = "Mostrar senha",
                        imageVector = if (!showPassword.value)
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

@Composable
@Preview
fun LoginScreenPreview() {
    LoginScreen()
}