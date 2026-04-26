package com.example.town.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.town.data.PlaceData
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import com.example.town.R
import com.example.town.MainViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    placeId: Int?,
    viewModel: MainViewModel,
    onBack: () -> Unit
) {
    val savedPlaceId by viewModel.selectedPlaceId.collectAsState()

    val actualPlaceId = placeId ?: savedPlaceId

    val place = actualPlaceId?.let { PlaceData.getPlaceById(it) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(place?.let { stringResource(it.name) } ?: stringResource(R.string.detail)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        if (place == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(stringResource(R.string.null_place))
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    painter = painterResource(id = place.imageId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(R.dimen.height))
                        .clip(RoundedCornerShape(dimensionResource(R.dimen.rounded))),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = stringResource(place.name),
                    style = MaterialTheme.typography.headlineMedium
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
                        DetailRow(stringResource(R.string.adress_name_detail), stringResource(place.address))
                        DetailRow(stringResource(R.string.hour_work), stringResource(place.workingHours))
                        DetailRow(stringResource(R.string.raiting_name), stringResource(place.rating))
                    }
                }

                Text(
                    text = stringResource(R.string.description_detail),
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = stringResource(place.fullDescription),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}