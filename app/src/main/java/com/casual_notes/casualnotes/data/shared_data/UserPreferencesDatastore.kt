package com.casual_notes.casualnotes.data.shared_data

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("User Preferences Datastore")

class UserPreferencesDatastore(private val context: Context) {

    /* KEYS---------------------------------------------------------------------------------------*/
    // Show Toasts Key
    val showToastsKey = booleanPreferencesKey("Show Toasts Key")

    // Vibration Level Key
    val vibrationLevelKey = stringPreferencesKey("Vibration Level Key")
    // ---------------------------------------------------------------------------------------------

    /* LOAD FUNCTIONS-----------------------------------------------------------------------------*/
    // Load Show Toasts
    fun loadShowToasts(key: Preferences.Key<Boolean>): Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[key] ?: userPreferencesStates.showToasts }

    // Load Vibration Level
    fun loadVibrationLevel(key: Preferences.Key<String>): Flow<String> = context.dataStore.data.map { preferences ->
        preferences[key] ?: userPreferencesStates.selectedVibrationLevel }
    // ---------------------------------------------------------------------------------------------

    /* SAVE FUNCTIONS-----------------------------------------------------------------------------*/
    // Save Show Toasts
    suspend fun saveShowToasts(key: Preferences.Key<Boolean>, data: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[key] = data }}

    // Save Vibration Level
    suspend fun saveVibrationLevel(key: Preferences.Key<String>, data: String) {
        context.dataStore.edit { preferences ->
            preferences[key] = data }}
    // ---------------------------------------------------------------------------------------------

}