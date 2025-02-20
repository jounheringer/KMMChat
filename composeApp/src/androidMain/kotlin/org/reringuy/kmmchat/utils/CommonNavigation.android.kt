package org.reringuy.kmmchat.utils

import android.content.Intent
import org.reringuy.kmmchat.MainActivity

actual fun navigateToMain() {
    val intent = Intent(appContext, MainActivity::class.java)
    appContext.startActivity(intent)
}