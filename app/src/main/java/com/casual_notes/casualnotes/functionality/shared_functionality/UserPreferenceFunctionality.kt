package com.casual_notes.casualnotes.functionality.shared_functionality

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.casual_notes.casualnotes.data.shared_data.UserPreferencesDatastore
import com.casual_notes.casualnotes.data.shared_data.userPreferencesStates
import kotlinx.coroutines.launch

// Global Instance of User Preference Functionality
val userPreferenceFunctionality = UserPreferenceFunctionality()

class UserPreferenceFunctionality: ViewModel() {

    // Save Vibration Level
    fun saveVibrationLevel(datastore: UserPreferencesDatastore) {
        viewModelScope.launch {
        datastore.saveVibrationLevel(
            datastore.vibrationLevelKey,
            userPreferencesStates.selectedVibrationLevel)
        }
    }

    // Load Vibration Level
    fun loadVibrationLevel(vibrationLevel: String){

        userPreferencesStates.selectedVibrationLevel = vibrationLevel }

    fun saveShowToasts(datastore: UserPreferencesDatastore) {
        viewModelScope.launch {
            datastore.saveShowToasts(
                datastore.showToastsKey,
                userPreferencesStates.showToasts)
        }
    }

    fun loadShowToasts(showToasts: Boolean) {
        userPreferencesStates.showToasts = showToasts
    }
}