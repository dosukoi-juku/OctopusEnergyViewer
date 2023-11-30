package io.github.dosukoijuku.octopusenergychecker.android.view.compose.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import io.github.dosukoijuku.octopusenergychecker.android.R
import io.github.dosukoijuku.octopusenergychecker.android.view.theme.OctopusTheme

@Composable
fun LoginStateCard(
    uiState: LoginStateCardUiState
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(R.string.title_login_status),
                style = MaterialTheme.typography.headlineMedium
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    Text(text = stringResource(R.string.to_check))
                }
                when (uiState) {
                    LoginStateCardUiState.UnChecked -> {} //Nothing
                    LoginStateCardUiState.Loading -> {
                        CircularProgressIndicator()
                    }

                    LoginStateCardUiState.NotLoggedIn -> {
                        Text(text = stringResource(R.string.not_login_message))
                    }

                    is LoginStateCardUiState.LoggedIn -> {
                        Text(text = stringResource(R.string.logged_in_message, uiState.name))
                    }
                }
            }
        }
    }
}

sealed class LoginStateCardUiState {
    data object UnChecked : LoginStateCardUiState()
    data object Loading : LoginStateCardUiState()
    data class LoggedIn(
        val name: String
    ) : LoginStateCardUiState()

    data object NotLoggedIn : LoginStateCardUiState()
}

@Preview
@Composable
private fun LoginStateCardPreview(
    @PreviewParameter(provider = PreviewLoginStateCardUiStateProvider::class) uiState: LoginStateCardUiState
) {
    OctopusTheme {
        LoginStateCard(
            uiState = uiState
        )
    }
}

private class PreviewLoginStateCardUiStateProvider :
    PreviewParameterProvider<LoginStateCardUiState> {
    override val values: Sequence<LoginStateCardUiState>
        get() = sequenceOf(
            LoginStateCardUiState.UnChecked,
            LoginStateCardUiState.Loading,
            LoginStateCardUiState.LoggedIn(name = "土酢 個伊"),
            LoginStateCardUiState.NotLoggedIn
        )
}