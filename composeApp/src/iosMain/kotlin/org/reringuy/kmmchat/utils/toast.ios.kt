package org.reringuy.kmmchat.utils

import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIApplication

actual fun showToast(message: String) {
    val alert = UIAlertController.alertControllerWithTitle(
        "Notification", message, UIAlertControllerStyleAlert
    )

    alert.addAction(
        UIAlertAction.actionWithTitle("OK", UIAlertActionStyleDefault, null)
    )

    val window = UIApplication.sharedApplication.keyWindow
    window?.rootViewController?.presentViewController(alert, animated = true, completion = null)

}