package com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

// Global Instance of Note Selection Screen States
val fileSelectionScreenStates = FileSelectionScreenStates()

class FileSelectionScreenStates {

    // File Selection Screen Destination
    val fileSelectionScreenDestination = "File Selection Screen"

    // Search Bar Text Field Value
    var searchBarTextFieldValue by mutableStateOf("")

    // Is Create File Button Pressed
    var isCreateFileButtonPressed by mutableStateOf(false)

    // Is Delete File Confirmation Box Visible
    var isDeleteFileConfirmationDialogVisible by mutableStateOf(false)

    // Is Back Button Pressed
    var isBackButtonPressed by mutableStateOf(false)

    // Is File Edit Panel Open Visible
    var isFileEditPanelOpenVisible by mutableStateOf(false)

    // Is Options Menu Visible
    var isOptionsMenuVisible by mutableStateOf(false)
}