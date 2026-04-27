package com.example.town.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.town.MainViewModel
import com.example.town.navigation.TownNavHost
import com.example.town.ui.components.BottomNavBar
import com.example.town.ui.components.DrawerContent
import com.example.town.ui.components.TopAppBar
import com.example.town.ui.utils.ScreenTitleProvider
import kotlinx.coroutines.launch
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TownApp(
    viewModel: MainViewModel = viewModel()
) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val currentCategory by viewModel.currentCategory.collectAsState()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val topBarTitle = ScreenTitleProvider.getTitleForRoute(currentRoute)

    val configuration = LocalConfiguration.current
    val isTablet = configuration.screenWidthDp >= 600


    val drawerContent = @Composable {
        DrawerContent(
            currentCategory = currentCategory,
            onCategoriesClick = {
                navController.navigate("categories")
            },
            onCategorySelected = { categoryId ->
                viewModel.selectCategory(categoryId)
                navController.navigate("main/$categoryId") {
                    popUpTo("home") { inclusive = false }
                }
            },

            onAboutClick = { navController.navigate("about") },
            onSettingsClick = { navController.navigate("settings") },
            onCloseDrawer = { scope.launch { drawerState.close() } }
        )
    }

    val mainContent = @Composable {
        Scaffold(
            topBar = {
                TopAppBar(
                    onMenuClick = {
                        if (!isTablet) {
                            scope.launch { drawerState.open() }
                        }
                    },
                    title = topBarTitle
                )
            },
            bottomBar = {
                BottomNavBar(
                    currentRoute = currentRoute,
                    onNavigate = { route ->
                        navController.navigate(route) {
                            popUpTo("home") { inclusive = false }
                        }
                    }
                )
            }
        ) { innerPadding ->
            TownNavHost(
                navController = navController,
                startCategoryId = currentCategory,
                viewModel = viewModel,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }

    if (isTablet) {
        Row {
            PermanentDrawerSheet(
                modifier = Modifier.width(300.dp)
            ) {
                drawerContent()
            }
            mainContent()
        }
    } else {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    drawerContent()
                }
            }
        ) {
            mainContent()
        }
    }
}