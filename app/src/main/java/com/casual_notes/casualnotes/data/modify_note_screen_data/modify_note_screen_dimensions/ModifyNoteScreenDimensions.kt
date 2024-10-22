package com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_dimensions

import com.casual_notes.casualnotes.data.shared_data.screenDimensions

class ModifyNoteScreenDimensions {

    // Create And Edit File Screen Top App Bar Dimensions
    val modifyNoteScreenTopAppBarHeight = screenDimensions.screenSize * 0.07f
    val modifyNoteScreenTopAppBarTopPadding = screenDimensions.screenSize * 0.02
    val modifyNoteScreenTopAppBarHorizontalPadding = screenDimensions.screenSize * 0.012

    // File Title Text Field Dimensions
    val noteTitleTextFieldWeight = 0.22f
    val fileTitleTextFieldFontSize = screenDimensions.screenSize * 0.020
    val backButtonIconSize = fileTitleTextFieldFontSize

    // Undo And Redo Button Dimensions
    val undoAndRedoButtonSize = screenDimensions.screenSize * 0.022
    val undoAndRedoButtonWeight = 0.032f

    // File Content Text Field Dimensions
    val fileContentTextFieldPadding = screenDimensions.screenSize * 0.008
    val fileContentTextFieldFontSize = screenDimensions.screenSize * 0.018
}