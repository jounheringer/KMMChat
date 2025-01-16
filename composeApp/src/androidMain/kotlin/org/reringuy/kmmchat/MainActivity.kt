package org.reringuy.kmmchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            app(
                darkTheme = isSystemInDarkTheme(),
                dynamicColor = false
            )
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    app(false, false)
}