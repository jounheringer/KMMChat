package org.reringuy.kmmchat

import androidx.compose.ui.window.ComposeUIViewController
import org.reringuy.kmmchat.screens.login.LoginWrapper
import org.reringuy.kmmchat.theme.ui.theme.AppTheme
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

fun LoginViewController() = ComposeUIViewController {
    AppTheme(
        darkTheme = UIScreen.mainScreen.traitCollection.userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark,
        dynamicColor = false
    ){
        LoginWrapper()
    }
}