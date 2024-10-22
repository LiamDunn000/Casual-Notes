package com.casual_notes.casualnotes.presentation.delete_file_confirmation_dialog.delete_file_confirmation_dialog_composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.casual_notes.casualnotes.R
import com.casual_notes.casualnotes.data.delete_file_confirmation_dialog_data.delete_file_confirmation_dialog_colors.deleteFileConfirmationDialogColors
import com.casual_notes.casualnotes.data.delete_file_confirmation_dialog_data.delete_file_confirmation_dialog_dimensions.DeleteFileConfirmationDialogDimensions

@Composable
fun DeleteFileConfirmationHeader(
) {

    // Delete File Confirmation Header Text
    Text(
        text = "Are you sure you want to delete the following files?",
        color = Color(deleteFileConfirmationDialogColors.deleteFileConfirmationDialogHeaderTextColor),
        fontSize = DeleteFileConfirmationDialogDimensions().deleteFileConfirmationDialogHeaderFontSize.sp,
        fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
        textAlign = TextAlign.Center,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}