package com.casual_notes.casualnotes.data.modify_folder_dialog_data.modify_folder_dialog_colors

import androidx.lifecycle.ViewModel
import com.casual_notes.casualnotes.data.shared_data.colors

// Global Instance of Create And Edit Directory Dialog Colors
val createAndEditDirectoryDialogColors = CreateAndEditDirectoryDialogColors()

class CreateAndEditDirectoryDialogColors: ViewModel() {

    // Create And Edit Directory Dialog Background Color
    var createAndEditDirectoryDialogBackgroundColor = colors.white

    // Create And Edit Directory Dialog Button Colors
    var createAndUpdateDirectoryButtonBackgroundColor = colors.lightBlue
    var closeCreateAndEditDirectoryDialogButtonBackgroundColor = colors.lightRed
    var createAndEditDirectoryDialogButtonTextColor = colors.white

    // Create And Edit Directory Dialog Header Color
    var createAndEditDirectoryDialogHeaderTextColor = colors.lightBlue

    // Create And Edit Directory Dialog Text Field Colors
    var directoryNameTextFieldBackgroundColor = colors.transparent
    var directoryNameTextFieldTextColor = colors.lightGray
    var directoryNameTextFieldIndicatorColor = colors.lightGray
}