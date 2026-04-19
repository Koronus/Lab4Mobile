package com.example.town.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.town.data.PlaceData
import com.example.town.ui.screen.*

@Composable
fun TownNavHost(
    navController: NavHostController,
    startCategoryId: Int,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {

        composable("home") {
            HomeScreen()
        }


        composable("categories") {
            CategoriesScreen(
                onCategoryClick = { category ->
                    navController.navigate("main/${category.id}")
                }
            )
        }


        composable("main/{categoryId}") { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")?.toIntOrNull() ?: 1
            val places = PlaceData.getPlacesByCategory(categoryId)

            PlaceScreen(
                places = places,
                onClick = { place ->
                    navController.navigate("detail/${place.id}")
                }
            )
        }


        composable("detail/{placeId}") { backStackEntry ->
            val placeId = backStackEntry.arguments?.getString("placeId")?.toIntOrNull()
            DetailScreen(
                placeId = placeId,
                onBack = { navController.popBackStack() }
            )
        }

        composable("about") {
            AboutScreen(onBack = { navController.popBackStack() })
        }

        composable("city") {
            CityInfoScreen(onBack = { navController.popBackStack() })
        }

        composable("settings") {
            SettingsScreen(onBack = { navController.popBackStack() })
        }
    }
}