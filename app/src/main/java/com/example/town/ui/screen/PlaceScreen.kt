package com.example.town.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.town.R
import com.example.town.model.Place
import com.example.town.ui.components.Item
import com.example.town.MainViewModel

@Composable
fun PlaceScreen(
    places: List<Place>,
    viewModel: MainViewModel,
    onClick: (Place) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding)),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(dimensionResource(R.dimen.verticalArr12))
    ) {
        items(places) { place ->
            Item(
                icon = painterResource(place.iconId),
                title = stringResource(place.name),
                description = stringResource(place.description),
                onClick = {
                    viewModel.selectPlace(place.id)
                    onClick(place)
                }
            )
        }
    }
}