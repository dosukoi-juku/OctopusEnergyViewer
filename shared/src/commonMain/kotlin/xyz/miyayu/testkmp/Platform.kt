package xyz.miyayu.testkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform