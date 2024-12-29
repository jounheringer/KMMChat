package org.reringuy.kmmchat

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform