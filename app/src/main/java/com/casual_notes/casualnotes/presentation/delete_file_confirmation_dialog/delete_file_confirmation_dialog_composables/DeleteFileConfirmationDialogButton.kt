package com.casual_notes.casualnotes.presentation.delete_file_confirmation_dialog.delete_file_confirmation_dialog_composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casual_notes.casualnotes.data.delete_file_confirmation_dialog_data.delete_file_confirmation_dialog_colors.deleteFileConfirmationDialogColors
import com.casual_notes.casualnotes.data.delete_file_confirmation_dialog_data.delete_file_confirmation_dialog_dimensions.DeleteFileConfirmationDialogDimensions

@Composable
fun DeleteFileConfirmationDialogButton(
    text: String,
    color: Color,
    onClick: () -> Unit
) {

    // Delete File Confirmation Dialog Button
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .width(DeleteFileConfirmationDialogDimensions().deleteFileConfirmationDialogButtonWidth.dp)
            .height(DeleteFileConfirmationDialogDimensions().deleteFileConfirmationDialogButtonHeight.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(10)
        ) {

        Text(
            text = text,
            color = Color(deleteFileConfirmationDialogColors.deleteFileConfirmationDialogButtonTextColor),
            fontSize = DeleteFileConfirmationDialogDimensions().deleteFileConfirmationDialogButtonFontSize.sp
        )
    }
}