package org.reringuy.kmmchat.utils

import org.reringuy.kmmchat.MainViewController
import platform.UIKit.UIApplication

actual fun navigateToMain() {
    val mainViewController = MainViewController()
    val rootViewController = UIApplication.sharedApplication.keyWindow?.rootViewController
    rootViewController?.presentViewController(mainViewController, animated = true, completion = null)
}