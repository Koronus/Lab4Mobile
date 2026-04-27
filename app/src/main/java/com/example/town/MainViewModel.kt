package com.example.town

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _currentCategory = MutableStateFlow(1)
    val currentCategory: StateFlow<Int> = _currentCategory.asStateFlow()
    private val _selectedPlaceId = MutableStateFlow<Int?>(null)
    val selectedPlaceId: StateFlow<Int?> = _selectedPlaceId.asStateFlow()

    fun selectCategory(categoryId: Int) {
        viewModelScope.launch {
            _currentCategory.emit(categoryId)
        }
    }
    fun selectPlace(placeId: Int) {
        viewModelScope.launch {
            _selectedPlaceId.emit(placeId)
        }
    }
}