package com.example.town.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.town.R

import androidx.compose.material.icons.filled.List
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource


@Composable
fun DrawerContent(
    currentCategory: Int,
    onCategoriesClick: () -> Unit,

    onAboutClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onCloseDrawer: () -> Unit
) {
    ModalDrawerSheet {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding))
        ) {
            Text(
                text = stringResource(R.string.title_nav),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding))
            )


            NavigationDrawerItem(
                icon = { Icon(Icons.Default.List, contentDescription = null) },
                label = { Text(stringResource(R.string.label_nav_category)) },
                selected = false,
                onClick = {
                    onCategoriesClick()
                    onCloseDrawer()
                }
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = dimensionResource(R.dimen.verticalArr16)))


            NavigationDrawerItem(
                icon = { Icon(Icons.Default.Info, contentDescription = null) },
                label = { Text(stringResource(R.string.label_nav_about)) },
                selected = false,
                onClick = {
                    onAboutClick()
                    onCloseDrawer()
                }
            )


            NavigationDrawerItem(
                icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                label = { Text(stringResource( R.string.label_nav_setting)) },
                selected = false,
                onClick = {
                    onSettingsClick()
                    onCloseDrawer()
                }
            )
        }
    }
}