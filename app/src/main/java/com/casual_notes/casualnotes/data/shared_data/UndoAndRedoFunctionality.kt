package com.casual_notes.casualnotes.data.shared_data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_states.modifyNoteScreenStates
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Global Instance of Undo And Redo Functionality
val undoAndRedoFunctionality = UndoAndRedoFunctionality()

class UndoAndRedoFunctionality: ViewModel() {

    // Launch Text Tracking Timer
    fun launchTextTrackingTimer() {

        viewModelScope.launch {
            modifyNoteScreenStates.isTextBeingDocumented = true
            delay(1000)
            modifyNoteScreenStates.isTextBeingDocumented = false

        }
    }

    // Determine If Text Is Being Documented
    fun determineIfTextIsBeingDocumented() {

        viewModelScope.launch {
        if (modifyNoteScreenStates.isTextBeingDocumented) {
            modifyNoteScreenStates.fileContentTextFieldValueHistory.add(
                modifyNoteScreenStates.noteContentTextFieldValue
            )
delay(1000)
            modifyNoteScreenStates.fileContentTextFieldValueHistory.size + 1
            modifyNoteScreenStates.currentIndex = modifyNoteScreenStates.fileContentTextFieldValueHistory.size
            modifyNoteScreenStates.isTextBeingDocumented = false
        }
    }}

    // Undo Text
    fun undoText() {
        if (modifyNoteScreenStates.fileContentTextFieldValueHistory.isNotEmpty() && !modifyNoteScreenStates.isTextBeingDocumented){
            modifyNoteScreenStates.noteContentTextFieldValue = modifyNoteScreenStates.fileContentTextFieldValueHistory.removeAt(modifyNoteScreenStates.currentIndex - 1)
            modifyNoteScreenStates.currentIndex--
    }}

    // Redo Text
    fun redoText() {
        if (modifyNoteScreenStates.currentIndex < modifyNoteScreenStates.fileContentTextFieldValueHistory.size - 1){
            modifyNoteScreenStates.noteContentTextFieldValue = modifyNoteScreenStates.fileContentTextFieldValueHistory[modifyNoteScreenStates.currentIndex + 1]
            modifyNoteScreenStates.currentIndex++}
    }

}