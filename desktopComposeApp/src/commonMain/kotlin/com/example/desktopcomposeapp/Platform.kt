package com.example.desktopcomposeapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform