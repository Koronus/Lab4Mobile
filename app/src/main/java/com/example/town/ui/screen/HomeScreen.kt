package com.example.town.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.town.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.main_home)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(dimensionResource(R.dimen.padding)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.verticalArr16))
        ) {

            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = stringResource(R.string.logo_home),
                modifier = Modifier.size(dimensionResource(R.dimen.mode_home_screen))
            )

            Text(
                text = stringResource(R.string.welcome_home),
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = stringResource(R.string.town_name),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding)),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.verticalArr))
                ) {
                    Text(
                        text = stringResource(R.string.weclome_app_home),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = stringResource(R.string.full_descr_home),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding)),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.verticalArr))
                ) {
                    Text(
                        text = stringResource(R.string.user_for),
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(stringResource(R.string.hint_home_1))
                    Text(stringResource(R.string.hint_home_2))
                    Text(stringResource(R.string.hint_home_3))
                }
            }
        }
    }
}