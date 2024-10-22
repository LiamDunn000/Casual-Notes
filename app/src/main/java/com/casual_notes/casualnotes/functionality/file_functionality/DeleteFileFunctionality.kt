package com.casual_notes.casualnotes.functionality.file_functionality

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_states.fileSelectionScreenStates
import com.casual_notes.casualnotes.data.shared_data.fileStates
import com.casual_notes.casualnotes.functionality.shared_functionality.generalFunctionality
import com.casual_notes.casualnotes.functionality.shared_functionality.interfaceVisibilityFunctionality
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Global Instance of Delete File Functionality
val deleteFileFunctionality = DeleteFileFunctionality()

class DeleteFileFunctionality: ViewModel() {

    // Delete Selected Files
    fun deleteSelectedFiles(context: Context) {

        generalFunctionality.vibrateOnButtonClick(context = context)

        // Iterate Through Selected Files And Delete Recursively
        fileStates.selectedFileList.forEach {
            it.deleteRecursively()
        }

        // Recompose File List
        updateFileFunctionality.recomposeFileList()

        // Close Delete File Confirmation Dialog
        interfaceVisibilityFunctionality.closeDeleteFileConfirmationDialog(context = context)

        viewModelScope.launch {

            // Display Toast
            generalFunctionality.displayToast(
                context = context,
                message = when{
                    fileStates.selectedFileList.size == 1 -> {
                        "1 File Deleted"
                    }
                    else -> {
                        "${fileStates.selectedFileList.size} Files Deleted"

                    }                }
            )

            delay(2)

            // Close File Edit Panel
            interfaceVisibilityFunctionality.closeFileEditPanel()
        }

    }

}