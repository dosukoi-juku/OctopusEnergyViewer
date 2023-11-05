package io.github.dosukoijuku.octopusenergychecker.android.view.compose.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.dosukoijuku.octopusenergychecker.android.R
import io.github.dosukoijuku.octopusenergychecker.android.view.compose.common.LoginStateCard
import io.github.dosukoijuku.octopusenergychecker.android.view.compose.common.LoginStateCardUiState
import io.github.dosukoijuku.octopusenergychecker.android.view.theme.OctopusTheme

@Composable
fun SettingScreen() {

    //TODO ViewModelに吸収させる
    val loginStateCardUiState by remember { mutableStateOf(LoginStateCardUiState.NotLoggedIn) }

    Scaffold(
        topBar = { SettingScreenTopBar() }
    ) {
        Column(
            modifier =
            Modifier
                .padding(it)
                .fillMaxWidth(),
        ) {
            LoginStateCard(
                uiState = loginStateCardUiState
            )
        }
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