package com.example.town.ui.utils
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.Composable
import com.example.town.R
object ScreenTitleProvider {
    @Composable
    fun getTitleForRoute(currentRoute: String?): String {
        return when {
            currentRoute == "categories" -> stringResource(R.string.label_nav_category)
            currentRoute?.startsWith("main/") == true -> stringResource(R.string.label_nav_place)
            currentRoute?.startsWith("detail/") == true -> stringResource(R.string.label_nav_detail)
            currentRoute == "about" -> stringResource(R.string.label_nav_about)
            currentRoute == "settings" -> stringResource(R.string.setting)
            else -> stringResource(R.string.app_name)
        }
    }
}