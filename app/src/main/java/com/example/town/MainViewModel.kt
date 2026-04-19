package com.example.town

import androidx.lifecycle.ViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainViewModel : ViewModel() {
    private val _currentCategory = MutableStateFlow(1)
    val currentCategory: StateFlow<Int> = _currentCategory.asStateFlow()

}