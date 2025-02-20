package org.reringuy.kmmchat.utils

import android.content.Context

lateinit var appContext: Context

fun initializeContext(context: Context) {
    appContext = context
}