package com.example.town

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.town.ui.TownApp
import com.example.town.ui.theme.TownTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TownTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    TownApp(viewModel = viewModel)
                }
            }
        }
    }
}