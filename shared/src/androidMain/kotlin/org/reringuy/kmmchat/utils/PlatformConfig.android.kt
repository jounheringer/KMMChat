package org.reringuy.kmmchat.utils

import dev.icerock.moko.mvvm.core.BuildConfig

actual object PlatformConfig {
    actual val isDebug: Boolean
        get() = BuildConfig.DEBUG
}