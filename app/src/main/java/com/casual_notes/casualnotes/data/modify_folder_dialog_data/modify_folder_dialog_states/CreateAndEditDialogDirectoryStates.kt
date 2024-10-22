package com.casual_notes.casualnotes.data.modify_folder_dialog_data.modify_folder_dialog_states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// Global Instance of Create And Edit Dialog Directory States
val modifyFolderDialogStates = CreateAndEditDialogDirectoryStates()

class CreateAndEditDialogDirectoryStates: ViewModel() {

    // Is Create And Edit Directory Dialog Open
    var isModifyFolderDialogVisible by mutableStateOf(false)

    // Directory Name Text Field Value
    var folderTitleTextFieldValue by mutableStateOf("")

    // Is Directory Being Edited
    var isFolderBeingEdited by mutableStateOf(false)

    var wasFolderRenamed by mutableStateOf(false)

}