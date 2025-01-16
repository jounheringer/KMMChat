package org.reringuy.kmmchat

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController { app(
    darkTheme = isSystemInDarkTheme(),
    dynamicColor = false
) }