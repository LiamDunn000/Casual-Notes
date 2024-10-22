package com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.casual_notes.casualnotes.data.shared_data.fileStates
import java.io.File

// Global Instance Of Move File Screen States
val moveFileScreenStates = MoveFileScreenStates()

class MoveFileScreenStates: ViewModel() {


    // Move File Screen Destination
    var moveFileScreenDestination = "Move File Screen"

    // Current Move Folder
    var currentMoveFolder by mutableStateOf(File(""))

    // Current Move File List
    var currentMoveFileList by mutableStateOf<List<File>>(fileStates.currentFolder.listFiles()?.toList() ?: listOf())

    // Folder Search Bar Text Field Value
    var folderSearchBarTextFieldValue by mutableStateOf("")

    var selectedDestination by mutableStateOf(File(""))

}