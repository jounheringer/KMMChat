package org.reringuy.kmmchat.utils

import platform.Foundation.NSProcessInfo

actual object PlatformConfig {
    actual val isDebug: Boolean
        get() = NSProcessInfo.processInfo.environment["DEBUG"] == "true"
}