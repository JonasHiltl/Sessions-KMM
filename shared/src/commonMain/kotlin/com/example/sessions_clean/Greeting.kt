package com.example.sessions_clean

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}