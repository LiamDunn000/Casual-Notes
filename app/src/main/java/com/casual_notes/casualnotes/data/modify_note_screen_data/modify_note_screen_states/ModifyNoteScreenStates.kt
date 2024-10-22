package com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// Global Instance of Create And Edit File Screen States
val modifyNoteScreenStates = ModifyNoteScreenStates()

class ModifyNoteScreenStates: ViewModel() {

    // Is Create And Edit File Screen Visible
    val createAndEditFileScreenDestination = "Create And Edit File Screen"

    // File Title Text Field Value
    var noteTitleTextFieldValue by mutableStateOf("")

    // File Content Text Field Value
    var noteContentTextFieldValue by mutableStateOf("")

    var fileContentTextFieldValueHistory = mutableStateListOf<String>()

    var currentIndex by mutableIntStateOf(fileContentTextFieldValueHistory.size)

    var isTextBeingDocumented by mutableStateOf(false)

    // Is File Being Edited
    var isNoteBeingEdited by mutableStateOf(false)

    // Is Text Field Read Only
    var isTextFieldReadOnly by mutableStateOf(false)

    // Is Text Value Changed
    var isTextValueChanged by mutableStateOf(false)

}