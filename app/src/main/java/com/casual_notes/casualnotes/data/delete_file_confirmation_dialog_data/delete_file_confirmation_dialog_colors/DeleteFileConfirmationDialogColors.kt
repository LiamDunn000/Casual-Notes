package com.casual_notes.casualnotes.data.delete_file_confirmation_dialog_data.delete_file_confirmation_dialog_colors

import com.casual_notes.casualnotes.data.shared_data.colors

// Global Instance Of Delete File Confirmation Dialog Colors
val deleteFileConfirmationDialogColors = DeleteFileConfirmationDialogColors()

class DeleteFileConfirmationDialogColors {

    // Delete File Confirmation Dialog Background Color
    val deleteFileConfirmationDialogBackgroundColor = colors.white

    // Delete File Confirmation Dialog Header Text Colors
    val deleteFileConfirmationDialogHeaderTextColor = colors.darkGray
    val deleteFileConfirmationDialogHeaderFileNameTextColor = colors.black

    // Delete File Confirmation Dialog Button Colors
    val confirmationFileDeletionButtonBackgroundColor = colors.lightBlue
    val cancelFileDeletionButtonBackgroundColor = colors.lightRed
    val deleteFileConfirmationDialogButtonTextColor = colors.white

    // Selected Files For Deletion List Colors
    val selectedFileForDeletionListItemBackgroundColor = colors.transparent
    val selectedFileForDeletionNameTextColor = colors.lightBlue
    val selectedFileForDeletionLastModifiedTextColor = colors.lightGray
}