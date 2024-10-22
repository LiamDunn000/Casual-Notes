package com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_colors

import androidx.lifecycle.ViewModel
import com.casual_notes.casualnotes.data.shared_data.colors

// Global Instance of Create And Edit File Screen Colors
val modifyNoteScreenColors = CreateAndEditFileScreenColors()

class CreateAndEditFileScreenColors: ViewModel() {

    // Create And Edit File Screen Top App Bar Background Color
    val modifyNoteScreenTopAppBarBackgroundColor = colors.lightBlue

    // File Title Text Field Colors
    val fileTitleTextFieldBackgroundColor = colors.transparent
    val fileTitleTextFieldTextColor = colors.white
    val fileTitleTextFieldIndicatorColor = colors.transparent

    // Create And Edit File Screen Top App Bar Background Color
    val modifyNoteScreenTopAppBarButtonColor = colors.white

    // File Content Text Field Colors
    val fileContentTextFieldBackgroundColor = colors.white
    val fileContentTextFieldTextColor = colors.darkGray
}