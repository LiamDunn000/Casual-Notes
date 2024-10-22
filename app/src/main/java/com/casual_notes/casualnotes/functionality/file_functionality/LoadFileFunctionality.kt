package com.casual_notes.casualnotes.functionality.file_functionality

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.casual_notes.casualnotes.data.modify_folder_dialog_data.modify_folder_dialog_states.modifyFolderDialogStates
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_states.modifyNoteScreenStates
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_states.fileSelectionScreenStates
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_states.moveFileScreenStates
import com.casual_notes.casualnotes.data.shared_data.fileStates
import com.casual_notes.casualnotes.functionality.shared_functionality.navigationFunctionality
import java.io.File

// Global Instance of Load File Functionality
val loadFileFunctionality = LoadFileFunctionality()

class LoadFileFunctionality: ViewModel() {

    // Display File Contents
    fun displayFileContents(
        context: Context,
        navController: NavController,
        file: File
    ) {

        // Update Current File
        updateFileFunctionality.updateCurrentFile(file = file)

        // Conditional That Displays File Contents
        when {

            // Display Folder Contents If File Is A Folder
            fileStates.currentFile.isDirectory -> {
            updateFileFunctionality.updateCurrentFolder(file = file)
            updateFileFunctionality.recomposeFileList(directory = file)
        }

            // Display Note Contents If File Is A Note
            else -> {

                // Navigate To Modify Note Screen
                navigationFunctionality.navigateToModifyNoteScreen(
                    context = context,
                    navController = navController
                )

                // Note Is Being Edited
                modifyNoteScreenStates.isNoteBeingEdited = true

                // Load Note Content
                loadNoteContent(file = file)
            }
        }
    }

    // Search Folder Files
    fun searchFolderFiles() {

        // Conditional Search Folder Files
        when {
            fileSelectionScreenStates.searchBarTextFieldValue == ""  -> {
                updateFileFunctionality.recomposeFileList()
            } else -> {
            fileStates.currentFileList = fileStates.currentFileList.filter { it.name.contains(
                fileSelectionScreenStates.searchBarTextFieldValue, ignoreCase = true) }
        }
        }
    }

    // Search Folder Files Within Move File Screen
    fun searchFolders() {

        // Conditional Search Folder Files Within Move File Screen
        when {
            moveFileScreenStates.folderSearchBarTextFieldValue == ""  -> {
                updateFileFunctionality.recomposeMoveFileList()
            } else -> {
            moveFileScreenStates.currentMoveFileList = moveFileScreenStates.currentMoveFileList.filter { it.name.contains(
                moveFileScreenStates.folderSearchBarTextFieldValue, ignoreCase = true) }
        }
        }
    }

    // Load Note Content
    fun loadNoteContent(file: File) {

        // Loads Note Title Into Note Title Text Field
        modifyNoteScreenStates.noteTitleTextFieldValue = file.name

        // Loads Note Content Into Note Content Text Field
        modifyNoteScreenStates.noteContentTextFieldValue = file.readText()
    }
}