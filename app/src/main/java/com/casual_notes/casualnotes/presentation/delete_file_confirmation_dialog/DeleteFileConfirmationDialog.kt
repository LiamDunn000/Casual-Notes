package com.casual_notes.casualnotes.presentation.delete_file_confirmation_dialog

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.casual_notes.casualnotes.data.delete_file_confirmation_dialog_data.delete_file_confirmation_dialog_colors.deleteFileConfirmationDialogColors
import com.casual_notes.casualnotes.data.delete_file_confirmation_dialog_data.delete_file_confirmation_dialog_dimensions.DeleteFileConfirmationDialogDimensions
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_states.fileSelectionScreenStates
import com.casual_notes.casualnotes.functionality.file_functionality.deleteFileFunctionality
import com.casual_notes.casualnotes.functionality.shared_functionality.interfaceVisibilityFunctionality
import com.casual_notes.casualnotes.presentation.delete_file_confirmation_dialog.delete_file_confirmation_dialog_composables.DeleteFileConfirmationDialogButton
import com.casual_notes.casualnotes.presentation.delete_file_confirmation_dialog.delete_file_confirmation_dialog_composables.DeleteFileConfirmationHeader
import com.casual_notes.casualnotes.presentation.delete_file_confirmation_dialog.delete_file_confirmation_dialog_composables.FilesSelectedForDeletionList

@Composable
fun DeleteFileConfirmationDialog(context: Context) {

    when {
        fileSelectionScreenStates.isDeleteFileConfirmationDialogVisible -> {

            // Delete File Confirmation Dialog Layout
            Dialog(onDismissRequest = { interfaceVisibilityFunctionality.closeDeleteFileConfirmationDialog(context = context) }) {
                Column(
                    modifier = Modifier
                        .background(color = Color(deleteFileConfirmationDialogColors.deleteFileConfirmationDialogBackgroundColor))
                        .width(DeleteFileConfirmationDialogDimensions().deleteFileConfirmationDialogWidth.dp)
                        .height(DeleteFileConfirmationDialogDimensions().deleteFileConfirmationDialogHeight.dp)
                        .padding(horizontal = DeleteFileConfirmationDialogDimensions().deleteFileConfirmationDialogHorizontalPadding.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    // Delete File Confirmation Header Question
                    DeleteFileConfirmationHeader()

                    // Files Selected For Deletion List
                    FilesSelectedForDeletionList()

                    // Confirmation File Deletion Button
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        DeleteFileConfirmationDialogButton(
                            text = "Confirm",
                            color = Color(deleteFileConfirmationDialogColors.confirmationFileDeletionButtonBackgroundColor),
                            onClick = { deleteFileFunctionality.deleteSelectedFiles(context = context)}
                        )

                        // Cancel File Deletion Button
                        DeleteFileConfirmationDialogButton(
                            text = "Cancel",
                            color = Color(deleteFileConfirmationDialogColors.cancelFileDeletionButtonBackgroundColor),
                            onClick = { interfaceVisibilityFunctionality.closeDeleteFileConfirmationDialog(context = context) }
                        )
                    }
                }
            }
        }
    }}