package com.casual_notes.casualnotes.presentation.modify_folder_dialog.modify_folder_dialog_composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.casual_notes.casualnotes.R
import com.casual_notes.casualnotes.data.modify_folder_dialog_data.modify_folder_dialog_colors.createAndEditDirectoryDialogColors
import com.casual_notes.casualnotes.data.modify_folder_dialog_data.modify_folder_dialog_dimensions.ModifyFolderDialogDimensions
import com.casual_notes.casualnotes.data.modify_folder_dialog_data.modify_folder_dialog_states.modifyFolderDialogStates

@Composable
fun DirectoryNameTextField() {

    // Directory Name Text Field
    TextField(
        value = modifyFolderDialogStates.folderTitleTextFieldValue,
        onValueChange = {
            modifyFolderDialogStates.folderTitleTextFieldValue = it
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(createAndEditDirectoryDialogColors.directoryNameTextFieldBackgroundColor),
            focusedContainerColor = Color(createAndEditDirectoryDialogColors.directoryNameTextFieldBackgroundColor),
            unfocusedIndicatorColor = Color(createAndEditDirectoryDialogColors.directoryNameTextFieldIndicatorColor),
            focusedIndicatorColor = Color(createAndEditDirectoryDialogColors.directoryNameTextFieldIndicatorColor)
        ),
        textStyle = TextStyle(
            color = Color(createAndEditDirectoryDialogColors.directoryNameTextFieldTextColor),
            fontSize = ModifyFolderDialogDimensions().directoryNameTextFieldFontSize.sp,
            fontFamily = FontFamily(Font(R.font.alegreya_sans_medium))
        ),
        placeholder = {
            Text(
                text = "Enter Folder Name",
                color = Color(createAndEditDirectoryDialogColors.directoryNameTextFieldTextColor),
                fontSize = ModifyFolderDialogDimensions().directoryNameTextFieldFontSize.sp,
                fontFamily = FontFamily(Font(R.font.alegreya_sans_medium))
            )
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}