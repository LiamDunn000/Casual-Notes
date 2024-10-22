package com.casual_notes.casualnotes.presentation.delete_file_confirmation_dialog.delete_file_confirmation_dialog_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casual_notes.casualnotes.R
import com.casual_notes.casualnotes.data.delete_file_confirmation_dialog_data.delete_file_confirmation_dialog_colors.deleteFileConfirmationDialogColors
import com.casual_notes.casualnotes.data.delete_file_confirmation_dialog_data.delete_file_confirmation_dialog_dimensions.DeleteFileConfirmationDialogDimensions

@Composable
fun FilesSelectedForDeletionListPanel(
    fileName: String,
    fileLastModifiedTimestamp: String
) {

    // Files Selected For Deletion List Panel Layout
    Column(
        modifier = Modifier
            .background(Color(deleteFileConfirmationDialogColors.selectedFileForDeletionListItemBackgroundColor))
            .width(DeleteFileConfirmationDialogDimensions().filesSelectedForDeletionListItemWidth.dp)
    ) {

        // Selected File For Deletion Name
        Text(
            text = fileName,
            color = Color(deleteFileConfirmationDialogColors.selectedFileForDeletionNameTextColor),
            fontSize = DeleteFileConfirmationDialogDimensions().fileSelectedForDeletionListNameFontSize.sp,
            fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        // Selected File For Deletion Last Modified
        Text(
            text = fileLastModifiedTimestamp,
            color = Color(deleteFileConfirmationDialogColors.selectedFileForDeletionLastModifiedTextColor),
            fontSize = DeleteFileConfirmationDialogDimensions().filesSelectedForDeletionListLastModifiedFontSize.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
    }
}