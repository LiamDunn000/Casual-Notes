package com.casual_notes.casualnotes.data.shared_data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.io.File

// Global Instance of File States
val fileStates = FileStates()

class FileStates: ViewModel() {

    var currentFolder by mutableStateOf(File(defaultDirectories.homeDirectory, defaultDirectories.homeDirectory.name))
    var currentFileList by mutableStateOf<List<File>>(currentFolder.listFiles()?.toList() ?: listOf())
    var currentFile by mutableStateOf(File(""))
    var selectedFileList = mutableStateListOf<File>()

}