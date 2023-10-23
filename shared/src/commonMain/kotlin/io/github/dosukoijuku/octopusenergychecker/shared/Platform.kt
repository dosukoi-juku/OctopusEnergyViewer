package io.github.dosukoijuku.octopusenergychecker.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform