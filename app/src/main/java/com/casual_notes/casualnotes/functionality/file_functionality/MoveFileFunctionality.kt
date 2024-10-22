package com.casual_notes.casualnotes.functionality.file_functionality

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_states.fileSelectionScreenStates
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_states.moveFileScreenStates
import com.casual_notes.casualnotes.data.shared_data.fileStates
import com.casual_notes.casualnotes.functionality.shared_functionality.generalFunctionality
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File

// Global Instance of Move File Functionality
val moveFileFunctionality = MoveFileFunctionality()

class MoveFileFunctionality: ViewModel() {

    // Move Selected Files
    fun moveSelectedFiles(
        context: Context,
        navController: NavController
        ) {

        // Vibrate On Button Click
        generalFunctionality.vibrateOnButtonClick(context = context)

        when {fileStates.selectedFileList.isNotEmpty() -> {

            // Move Files In Selected File List
            fileStates.selectedFileList.forEach {
                it.renameTo(File(moveFileScreenStates.selectedDestination, it.name))
                }

            viewModelScope.launch {

                // Recompose File List
                updateFileFunctionality.recomposeFileList(directory = moveFileScreenStates.selectedDestination)

                delay(2)

                // Unselect Destination And Display Toast
               moveFileScreenStates.selectedDestination = File("")
                generalFunctionality.displayToast(
                    context = context,
                    message = when { fileStates.selectedFileList.size == 1 ->
                        "1 File Moved" else -> "${fileStates.selectedFileList.size} Files Moved"}
                )


                delay(1)

                // Navigate Back To File Selection Screen And Clear Selected File List
                navController.navigate(fileSelectionScreenStates.fileSelectionScreenDestination)
                fileStates.selectedFileList.clear()

                }
            }
        }

    }

    // Select Destination To Move Files To
    fun selectDestinationToMoveFilesTo(
        context: Context,
        file: File) {

        when {file !in fileStates.selectedFileList -> {

            // Vibrate On Button Click
            generalFunctionality.vibrateOnButtonClick(context = context)

            // Select Destination To Move Files To
            moveFileScreenStates.selectedDestination = file

        } }
    }

}