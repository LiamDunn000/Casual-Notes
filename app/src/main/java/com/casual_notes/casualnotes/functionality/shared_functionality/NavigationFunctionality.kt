package com.casual_notes.casualnotes.functionality.shared_functionality

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_states.modifyNoteScreenStates
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_states.fileSelectionScreenStates
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_states.moveFileScreenStates
import com.casual_notes.casualnotes.data.shared_data.fileStates
import com.casual_notes.casualnotes.functionality.file_functionality.createFileFunctionality
import com.casual_notes.casualnotes.functionality.file_functionality.manageFileFunctionality
import com.casual_notes.casualnotes.functionality.file_functionality.updateFileFunctionality
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File

// Global Instance of Navigation Functionality
val navigationFunctionality = NavigationFunctionality()

class NavigationFunctionality: ViewModel() {

    // Navigate To Next Folder
    fun navigateToNextMoveFolder(
        context: Context,
        file: File) {

        when { file !in fileStates.selectedFileList -> {
            generalFunctionality.vibrateOnButtonClick(context = context)
            updateFileFunctionality.updateCurrentMoveFolder(file = file)
            updateFileFunctionality.recomposeMoveFileList()
    }}}

    // Navigate To Previous Folder
    fun navigateToPreviousFolderWithinMoveFileScreen(context: Context) {

        when {
            moveFileScreenStates.currentMoveFolder.name != "Home" -> {
                generalFunctionality.vibrateOnButtonClick(context = context)
                moveFileScreenStates.currentMoveFolder = moveFileScreenStates.currentMoveFolder.parentFile!!
                updateFileFunctionality.recomposeMoveFileList()
            }
    }}

    // Navigate To Previous Folder
    fun navigateToPreviousFolder(context: Context) {

        // Vibrate On Button Click
        generalFunctionality.vibrateOnButtonClick(context = context)

        // Conditional That Navigates To Parent Folder If It Is Not Named Home
        when {
            fileStates.currentFolder.name != "Home"
                && !fileSelectionScreenStates.isFileEditPanelOpenVisible-> {
            fileStates.currentFolder = fileStates.currentFolder.parentFile!!
            updateFileFunctionality.recomposeFileList()
            fileSelectionScreenStates.isBackButtonPressed = true

        }
            // Conditional That Closes File Edit Panel And Clears Selected File List
            fileSelectionScreenStates.isFileEditPanelOpenVisible -> {
                interfaceVisibilityFunctionality.closeFileEditPanel()
            }

            // Conditional That Closes App If It Is Named Home
            else -> {
                generalFunctionality.minimizeApplication(context = context)}
        }
    }

    // Navigate To File Selection Screen
    fun navigateToFileSelectionScreen(
        context: Context,
        navController: NavController) {

        // Vibrate On Button Click
        generalFunctionality.vibrateOnButtonClick(context = context)

        // Navigate To File Selection Screen
        navController.navigate(fileSelectionScreenStates.fileSelectionScreenDestination)

    }

    // Navigate To Create And Edit File Screen
    fun navigateToModifyNoteScreen(
        context: Context,
        navController: NavController) {

        // Vibrate On Button Click
        generalFunctionality.vibrateOnButtonClick(context = context)


        navController.navigate(modifyNoteScreenStates.createAndEditFileScreenDestination)

        when{
            modifyNoteScreenStates.isNoteBeingEdited -> {
                modifyNoteScreenStates.noteTitleTextFieldValue = fileStates.currentFile.name
                modifyNoteScreenStates.noteContentTextFieldValue = fileStates.currentFile.readText()
            }
        }
    }

    // Navigate To File Selection Screen And Save File
    fun navigateToFileSelectionScreenAndSaveFile(
        context: Context,
        navController: NavController) {

        generalFunctionality.vibrateOnButtonClick(context = context)

        modifyNoteScreenStates.isTextFieldReadOnly = false
        modifyNoteScreenStates.fileContentTextFieldValueHistory.clear()

        // Navigate To File Selection Screen
        navController.navigate(fileSelectionScreenStates.fileSelectionScreenDestination)
        fileSelectionScreenStates.isCreateFileButtonPressed = false

        viewModelScope.launch {

            // Conditional That Determines If Note Is Being Created Or Edited
            when {

                // Update Note
                modifyNoteScreenStates.isNoteBeingEdited -> {
                    updateFileFunctionality.updateNote(context = context)

                    delay(10)
                    modifyNoteScreenStates.isTextValueChanged = false
                }

                // Create Note
                else -> { createFileFunctionality.createNote(context = context) } }

            delay(10)

            // Reset Note Text Field States
            modifyNoteScreenStates.noteTitleTextFieldValue = ""
            modifyNoteScreenStates.noteContentTextFieldValue = ""

            // Unselect Current File
            manageFileFunctionality.unselectCurrentFile()
        }
    }


    // Navigate To Move File Screen
    fun navigateToMoveFileScreen(
        context: Context,
        navController: NavController) {

        // Vibrate On Button Click
        generalFunctionality.vibrateOnButtonClick(context = context)

        // Navigate To Move File Screen
        navController.navigate(moveFileScreenStates.moveFileScreenDestination)

        // Update Current Move Folder To Current Folder
        moveFileScreenStates.currentMoveFolder = fileStates.currentFolder

        // Recompose Move File List With Current Folder
        updateFileFunctionality.recomposeMoveFileList(directory = fileStates.currentFolder)

    }


}