package com.casual_notes.casualnotes.functionality.file_functionality

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.casual_notes.casualnotes.data.modify_folder_dialog_data.modify_folder_dialog_states.modifyFolderDialogStates
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_states.modifyNoteScreenStates
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_states.moveFileScreenStates
import com.casual_notes.casualnotes.data.shared_data.fileStates
import com.casual_notes.casualnotes.functionality.shared_functionality.generalFunctionality
import com.casual_notes.casualnotes.functionality.shared_functionality.interfaceVisibilityFunctionality
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File
import kotlin.random.Random

// Global Instance of Update File Functionality
val updateFileFunctionality = UpdateFileFunctionality()

class UpdateFileFunctionality: ViewModel() {

    // Recompose File List
    fun recomposeFileList(directory: File = fileStates.currentFolder) {
        fileStates.currentFileList = directory.listFiles()?.toList() ?: listOf()
    }

    // Recompose Move File List
    fun recomposeMoveFileList(directory: File = moveFileScreenStates.currentMoveFolder) {
        moveFileScreenStates.currentMoveFileList = directory.listFiles()?.toList() ?: listOf()
    }

    // Update Current Directory
    fun updateCurrentFolder(file: File) {
        fileStates.currentFolder = file
    }

    // Update Current File
    fun updateCurrentFile(file: File) {
        fileStates.currentFile = file
    }

    fun updateCurrentMoveFolder(file: File) {
        moveFileScreenStates.currentMoveFolder = file
    }

    fun manageFileEditPanelState(
        file: File,
        selectFile: () -> Unit,
        unSelectFile: () -> Unit) {

        // Conditional That Determines File Edit Panel State
        when {

            // Open File Edit Panel If Selected File List Is Not Empty
            fileStates.selectedFileList.isNotEmpty() -> {
                interfaceVisibilityFunctionality.openFileEditPanel()

                // Closes File Edit Panel If Selected File List Is Empty
            } else -> {
            interfaceVisibilityFunctionality.closeFileEditPanel()}}

        // Conditional That Unselects File If Selected File List Is Empty
        when {
            fileStates.selectedFileList.isEmpty() -> {unSelectFile()}
        }

        // Conditional That Selects File If File Is In Selected File List
        when {file in fileStates.selectedFileList -> {selectFile()}}

    }

    // Edit Folder
    fun editFile(context: Context) {

        // Vibrate
        generalFunctionality.vibrateOnButtonClick(context = context)

        modifyFolderDialogStates.isFolderBeingEdited = true

        // Conditional That Opens Modify Folder Dialog
        when{modifyFolderDialogStates.isFolderBeingEdited -> {
            interfaceVisibilityFunctionality.openModifyFolderDialog(context = context)
            modifyFolderDialogStates.folderTitleTextFieldValue =
                fileStates.selectedFileList[0].name
        }
        }
    }

    // Rename File
    fun renameFile(context: Context) {

        // Create New Folder To Rename To
        val newFolder = File(fileStates.currentFolder, modifyFolderDialogStates.folderTitleTextFieldValue)
        newFolder.mkdir()

        // Conditional That Renames Folder If New Folder Does Not Exist
        when{newFolder.name != fileStates.selectedFileList[0].name -> {

            // Nested Conditional That Deletes New Folder If New File Exists
            when{newFolder.exists() -> newFolder.delete()}

            // Rename Folder
            fileStates.selectedFileList[0].renameTo(newFolder)

            // Recompose File List
            updateFileFunctionality.recomposeFileList()

            // Close Modify Folder Dialog
            interfaceVisibilityFunctionality.closeModifyFolderDialog(context = context)

            // Close File Edit Panel
            interfaceVisibilityFunctionality.closeFileEditPanel()

            // Display Toast
            generalFunctionality.displayToast(
                context = context,
                message = "File Renamed")
            }
        }
    }


    // Update Note
    fun updateNote(context: Context) {

        when {
            modifyNoteScreenStates.isTextValueChanged -> {

        // Create New Note To Rename To
        val updatedNote = File(fileStates.currentFolder,

            // Conditional That Determines Updated Note Name
            when {

                // Rename Note To Untitled If Text Field Is Empty
                modifyNoteScreenStates.noteTitleTextFieldValue == "" -> {
                    "Untitled (${Random.nextInt(0, 10000)})"
                }

                // Rename Note To Text Field Value If Text Field Is Not Empty
                else -> {
                    modifyNoteScreenStates.noteTitleTextFieldValue}
            })
        updatedNote.mkdir()

        viewModelScope.launch {

        // Conditional That Renames Note If New Note Does Not Exist
        when{updatedNote.name != fileStates.currentFile.name -> {

            // Nested Conditional That Deletes New Note If New Note Exists
            when {
                updatedNote.exists() -> updatedNote.delete()
            }

            // Rename Note
            fileStates.currentFile.renameTo(updatedNote)

            // Reset Note Edit State
            modifyNoteScreenStates.isNoteBeingEdited = false

            // Recompose File List
            updateFileFunctionality.recomposeFileList()

            }

        }
            // Update Note Content
            delay(2)
            updatedNote.writeText(modifyNoteScreenStates.noteContentTextFieldValue)

            // Display Toast
            generalFunctionality.displayToast(
                context = context,
                message = "Note Updated"
            )
        }

    }}

        }}
