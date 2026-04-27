package com.example.town.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.town.R
import com.example.town.data.CategoryData
import com.example.town.model.Category
import com.example.town.ui.components.Item

@Composable
fun CategoriesScreen(
    onCategoryClick: (Category) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding)),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(dimensionResource(R.dimen.verticalArr))
    ) {
        items(CategoryData.categories) { category ->
            Item(
                icon = painterResource(category.iconId),
                title = stringResource(category.title),
                description = stringResource(category.description),
                onClick = { onCategoryClick(category) }
            )
        }
    }
}