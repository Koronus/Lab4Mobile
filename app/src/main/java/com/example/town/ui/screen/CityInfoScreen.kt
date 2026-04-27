package com.example.town.ui.screen


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.town.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityInfoScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { stringResource(R.string.app_name)},
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                }
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
            Text(
                text = stringResource(R.string.town_info),
                style = MaterialTheme.typography.displaySmall
            )

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding)),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.verticalArr12))
                ) {
                    Text(
                        text = stringResource(R.string.founded),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = stringResource(R.string.population),
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = stringResource(R.string.decription_town),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}