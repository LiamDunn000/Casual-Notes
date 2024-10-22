package com.casual_notes.casualnotes.functionality.shared_functionality

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.casual_notes.casualnotes.data.shared_data.userPreferencesStates

// Global Instance of General Functionality
val generalFunctionality = GeneralFunctionality()

class GeneralFunctionality: ViewModel() {

    // Minimize Application
    fun minimizeApplication(context: Context) {
        (context as? Activity)?.moveTaskToBack(true)
    }

    // Vibrate On Button Click
    fun vibrateOnButtonClick(context: Context){

        // Conditional That Vibrates Device When Button Is Clicked Depending On Build Version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator.vibrate(VibrationEffect.createOneShot(
                userPreferencesStates.vibrationLevel, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(userPreferencesStates.vibrationLevel) }}

    // Manage Vibration Level
    fun manageVibrationLevel(context: Context) {

        // Vibrate On Button Click
        vibrateOnButtonClick(context = context)

        // Conditional That Changes Vibration Level Depending On Selected Vibration Level
        when (userPreferencesStates.selectedVibrationLevel) {
            "Off" -> userPreferencesStates.vibrationLevel = 1
            "Low" -> userPreferencesStates.vibrationLevel = 30
            "High" -> userPreferencesStates.vibrationLevel = 60
        }
    }

    // Display Toast
    fun displayToast(context: Context, message: String) {

        when {userPreferencesStates.showToasts ->
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}