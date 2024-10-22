package com.casual_notes.casualnotes.data.shared_data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// Global Instance of User Preferences States
val userPreferencesStates = UserPreferencesStates()

class UserPreferencesStates: ViewModel() {

    // Toast Preferences
    var showToasts by mutableStateOf(true)

    var vibrationLevel by mutableLongStateOf(30)

    var selectedVibrationLevel by mutableStateOf("Low")

    var vibrationLevelList = listOf("Off", "Low", "High")
}