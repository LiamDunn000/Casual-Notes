package com.casual_notes.casualnotes.functionality.file_functionality

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_states.fileSelectionScreenStates
import com.casual_notes.casualnotes.data.shared_data.fileStates
import com.casual_notes.casualnotes.functionality.shared_functionality.generalFunctionality
import java.io.File

// Global Instance of Manage File Functionality
val manageFileFunctionality = ManageFileFunctionality()

class ManageFileFunctionality: ViewModel() {

    // Unselect Current File
    fun unselectCurrentFile() {
        fileStates.currentFile = File("")
    }

    // Manage Saved File Panel On Click State
    fun manageSavedFilePanelOnClickState(
        context: Context,
        navController: NavController,
        file: File,
        isFileSelected: Boolean,
        selectFile: () -> Unit,
        unselectFile: () -> Unit
    ) {

        generalFunctionality.vibrateOnButtonClick(context = context)

        // Conditional That Determines Saved File Panel On Click State
        when {

            // Unselect File If File Is Selected And Remove File To Selected File List
            isFileSelected -> {
                unselectFile()
                fileStates.selectedFileList.remove(file)
            }

            // Select File If File Is Not Selected And Add File To Selected File List
            fileSelectionScreenStates.isFileEditPanelOpenVisible -> {
                selectFile()
                fileStates.selectedFileList.add(file)
                fileSelectionScreenStates.isCreateFileButtonPressed = false
            }

            // Display File Contents When File Is Not Being Edited
            else -> { loadFileFunctionality.displayFileContents(
                context = context,
                navController = navController,
                file = file)
            }
        }
    }

    // Manage Saved File Panel On Long Click State
    fun manageSavedFilePanelOnLongClickState(
        context: Context,
        file: File,
        isFileSelected: Boolean,
    ){

        generalFunctionality.vibrateOnButtonClick(context = context)

        // Conditional That Determines Saved File Panel On Long Click State
        when {

            // Add File To Selected File List If File Is Selected
            isFileSelected -> {
                fileStates.selectedFileList.add(file)
                fileSelectionScreenStates.isCreateFileButtonPressed = false
        }

            // Remove File From Selected File List If File Is Not Selected
            else -> { fileStates.selectedFileList.remove(file)
            }
        }

    }
}