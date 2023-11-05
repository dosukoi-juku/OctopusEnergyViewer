package io.github.dosukoijuku.octopusenergychecker.android.view.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.github.dosukoijuku.octopusenergychecker.android.view.compose.top.TopScreen
import io.github.dosukoijuku.octopusenergychecker.android.view.theme.OctopusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OctopusTheme {
                TopScreen()
            }
        }
    }
}