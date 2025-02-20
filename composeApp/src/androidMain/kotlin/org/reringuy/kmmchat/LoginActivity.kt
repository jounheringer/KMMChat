package org.reringuy.kmmchat

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module
import org.reringuy.kmmchat.screens.login.LoginWrapper
import org.reringuy.kmmchat.utils.initializeContext

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeContext(this)

        startKoin {
            androidContext(this@LoginActivity)
            androidLogger()
            modules(SharedModule().module)
        }

        setContent {
            LoginWrapper()
        }
    }
}