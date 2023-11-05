package io.github.dosukoijuku.octopusenergychecker.android.view.compose.home

import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {
    Text(
        text = "Hello World", color = MaterialTheme.colorScheme.onBackground
    )
}