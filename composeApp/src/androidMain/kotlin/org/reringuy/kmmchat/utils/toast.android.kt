package org.reringuy.kmmchat.utils

import android.widget.Toast

actual fun showToast(message: String) {
    Toast.makeText(appContext, message, Toast.LENGTH_SHORT).show()
}