package com.casual_notes.casualnotes.presentation.modify_folder_dialog.modify_folder_dialog_composables

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
import com.casual_notes.casualnotes.data.modify_folder_dialog_data.modify_folder_dialog_colors.createAndEditDirectoryDialogColors
import com.casual_notes.casualnotes.data.modify_folder_dialog_data.modify_folder_dialog_dimensions.ModifyFolderDialogDimensions

@Composable
fun CreateAndEditDirectoryDialogButton(
    text: String,
    color: Color,
    onClick: () -> Unit
) {

    Button(
        onClick = {onClick()},
        modifier = Modifier
            .width(ModifyFolderDialogDimensions().modifyFolderDialogButtonWidth.dp)
            .height(ModifyFolderDialogDimensions().modifyFolderDialogButtonHeight.dp),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
    ) {
        Text(
            text = text,
            color = Color(createAndEditDirectoryDialogColors.createAndEditDirectoryDialogButtonTextColor),
            fontSize = ModifyFolderDialogDimensions().createAndEditDirectoryDialogButtonFontSize.sp,
        )
    }
}