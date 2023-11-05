package io.github.dosukoijuku.octopusenergychecker.android.view.compose.setting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.dosukoijuku.octopusenergychecker.android.R
import io.github.dosukoijuku.octopusenergychecker.android.view.theme.OctopusTheme

@Composable
fun SettingScreen() {
    Scaffold(
        topBar = { SettingScreenTopBar() }
    ) {
        Box(modifier = Modifier.padding(it))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SettingScreenTopBar() {
    TopAppBar(
        title = {
            Text(stringResource(id = R.string.nav_setting_title))
        }
    )
}

@Preview
@Composable
private fun SettingScreenPreview() {
    OctopusTheme {
        SettingScreen()
    }
}