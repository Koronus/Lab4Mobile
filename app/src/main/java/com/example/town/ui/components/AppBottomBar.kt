package com.example.town.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.town.R

@Composable
fun BottomNavBar(
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {
    val selectedItem = getSelectedBottomBarItem(currentRoute)

    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = stringResource(R.string.main_home)) },
            label = { Text(stringResource(R.string.main_home)) },
            selected = selectedItem == "home",
            onClick = { onNavigate("home") }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Info, contentDescription = stringResource(R.string.label_nav_about)) },
            label = { Text(stringResource(R.string.label_nav_about)) },
            selected = selectedItem == "about",
            onClick = { onNavigate("about") }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.LocationCity, contentDescription = stringResource(R.string.label_nav_about_town)) },
            label = { Text(stringResource(R.string.label_nav_about_town)) },
            selected = selectedItem == "city",
            onClick = { onNavigate("city") }
        )
    }
}

fun getSelectedBottomBarItem(route: String?): String {
    return when {
        route == "home" -> "home"
        route == "about" -> "about"
        route == "city" -> "city"
        route == "categories" -> "home"
        route?.startsWith("main/") == true -> "home"
        route?.startsWith("detail/") == true -> "home"
        else -> "home"
    }
}

