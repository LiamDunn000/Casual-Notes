package com.casual_notes.casualnotes.functionality.file_functionality

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.casual_notes.casualnotes.data.modify_folder_dialog_data.modify_folder_dialog_states.modifyFolderDialogStates
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_states.modifyNoteScreenStates
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_states.moveFileScreenStates
import com.casual_notes.casualnotes.data.shared_data.fileStates
import com.casual_notes.casualnotes.functionality.shared_functionality.generalFunctionality
import com.casual_notes.casualnotes.functionality.shared_functionality.interfaceVisibilityFunctionality
import java.io.File
import kotlin.random.Random

// Global Instance of Create File Functionality
val createFileFunctionality = CreateFileFunctionality()

class CreateFileFunctionality: ViewModel() {

    // Manage Create And Edit Directory Dialog Button States
    fun manageModifyFolderDialogButtonStates(context: Context) {

        generalFunctionality.vibrateOnButtonClick(context = context)

        // Conditional That Determines If A Directory Is Being Created Or Edited
        when {

            // Update Directory
            modifyFolderDialogStates.isFolderBeingEdited -> {
                updateFileFunctionality.renameFile(context = context)
            }

        // Create Directory
        else -> {createFolder(context = context)}}
    }

    // Create Folder
    fun createFolder(context: Context) {

        when {
            modifyFolderDialogStates.folderTitleTextFieldValue != "" -> {

        // Create New Folder
        val newFolder = File(when{
            fileStates.selectedFileList.isNotEmpty() -> {
                moveFileScreenStates.currentMoveFolder
            } else -> {
                fileStates.currentFolder
            }
            },

            // Conditional That Determines New Folder Name
            modifyFolderDialogStates.folderTitleTextFieldValue
             )

        // Conditional That Displays A Toast If Folder Name Is Already Taken
        when {
            newFolder.exists() -> {
                newFolder.renameTo(File(fileStates.currentFolder,
                    "${(modifyFolderDialogStates.folderTitleTextFieldValue)} (${Random.nextInt(0, 10000)})"))
            }
        }

        // Initialize New Folder
        newFolder.mkdir()

        // Create Placeholder Note And Add Text
        val placeHolderNote = File(newFolder, "!n#o)$")
        placeHolderNote.writeText("This is a placeholder note")

        // Recompose File List
        updateFileFunctionality.recomposeFileList()
        updateFileFunctionality.recomposeMoveFileList()

        // Display Toast
        generalFunctionality.displayToast(
            context = context,
            message = "Folder Created"
        )

     // Conditional That Displays A Toast If Folder Name Is Untitled
    } else -> {
            generalFunctionality.displayToast(
                context = context,
                message = "Nothing To Save"
            )
        }
    }
        // Close Create And Edit Directory Dialog
        interfaceVisibilityFunctionality.closeModifyFolderDialog(context = context)
    }

    // Create Note
    fun createNote(context: Context) {

        when { modifyNoteScreenStates.noteTitleTextFieldValue != "" ||
                modifyNoteScreenStates.noteContentTextFieldValue != "" -> {

           when { !modifyNoteScreenStates.isNoteBeingEdited -> {
                // New Note
                val newNote = File(
                    fileStates.currentFolder,

                    // Conditional That Determines New Note Name
                    when {

                        // If New Note Name Is Untitled Append Random Number To Title
                        modifyNoteScreenStates.noteTitleTextFieldValue == ""
                        -> {
                            "Untitled (${Random.nextInt(0, 10000)})"
                        }

                        // If New Note Name Is Not Untitled Return New Note Name
                        else -> {
                            modifyNoteScreenStates.noteTitleTextFieldValue
                        }
                    }
                )

                // Conditional That Displays A Toast If Note Name Is Already Taken
                when {
                    newNote.exists() -> {
                        newNote.renameTo(File(fileStates.currentFolder,
                            "${(modifyNoteScreenStates.noteTitleTextFieldValue)} (${Random.nextInt(0, 10000)})"))
                    } else -> {
                        generalFunctionality.displayToast(
                            context = context,
                            message = "Note Created"
                        )
                    }
                }
                // Save Contents To New Note
                newNote.writeText(modifyNoteScreenStates.noteContentTextFieldValue)

                // Unselect Current File
                manageFileFunctionality.unselectCurrentFile()

                // Recompose File List
                updateFileFunctionality.recomposeFileList()
            }
        }} else -> {
            generalFunctionality.displayToast(
                context = context,
                message = "Nothing To Save"
            )
        }

    }

}}