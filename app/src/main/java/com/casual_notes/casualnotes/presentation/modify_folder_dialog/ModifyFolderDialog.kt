package com.casual_notes.casualnotes.presentation.modify_folder_dialog

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.casual_notes.casualnotes.R
import com.casual_notes.casualnotes.data.modify_folder_dialog_data.modify_folder_dialog_colors.createAndEditDirectoryDialogColors
import com.casual_notes.casualnotes.data.modify_folder_dialog_data.modify_folder_dialog_dimensions.ModifyFolderDialogDimensions
import com.casual_notes.casualnotes.data.modify_folder_dialog_data.modify_folder_dialog_states.modifyFolderDialogStates
import com.casual_notes.casualnotes.data.shared_data.fileStates
import com.casual_notes.casualnotes.functionality.file_functionality.createFileFunctionality
import com.casual_notes.casualnotes.functionality.shared_functionality.interfaceVisibilityFunctionality
import com.casual_notes.casualnotes.presentation.modify_folder_dialog.modify_folder_dialog_composables.CreateAndEditDirectoryDialogButton
import com.casual_notes.casualnotes.presentation.modify_folder_dialog.modify_folder_dialog_composables.DirectoryNameTextField

@Composable
fun ModifyFolderDialog(
    context: Context
) {

    // Modify Folder Dialog Header Text
    val createAndEditDirectoryDialogHeaderText = when {

        // Changes Header To Rename Folder
        modifyFolderDialogStates.isFolderBeingEdited && fileStates.selectedFileList[0].isDirectory -> { "Rename Folder"}


        // Changes Header To Rename Note
        modifyFolderDialogStates.isFolderBeingEdited && !fileStates.selectedFileList[0].isDirectory -> { "Rename Note" }


        // Changes Header To Create A New Folder
        else -> "Create A New Folder"
    }

    // Modify Folder Dialog Button Text
    val createAndEditDirectoryButtonText = when {

        // Changes Button Text To Rename
        modifyFolderDialogStates.isFolderBeingEdited -> "Rename"

        // Changes Button Text To Create
        else -> "Create"
    }

    when {
        modifyFolderDialogStates.isModifyFolderDialogVisible -> {

        // Modify Folder Dialog Layout
        Dialog(onDismissRequest = { interfaceVisibilityFunctionality.closeModifyFolderDialog(context = context) }) {

            Column(
                modifier = Modifier
                    .background(color = Color(createAndEditDirectoryDialogColors.createAndEditDirectoryDialogBackgroundColor))
                    .width(ModifyFolderDialogDimensions().modifyFolderDialogWidth.dp)
                    .height(ModifyFolderDialogDimensions().modifyFolderDialogHeight.dp)
                    .padding(horizontal = ModifyFolderDialogDimensions().modifyFolderDialogHorizontalPadding.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                // Modify Folder Dialog Header
                Text(
                    text = createAndEditDirectoryDialogHeaderText,
                    color = Color(createAndEditDirectoryDialogColors.createAndEditDirectoryDialogHeaderTextColor),
                    fontSize = ModifyFolderDialogDimensions().modifyFolderDialogHeaderFontSize.sp,
                    fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
                    )

                // Folder Name Text Field
                DirectoryNameTextField()

                // Modify Folder Dialog Button Panel
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    // Create Or Update Folder Button
                    CreateAndEditDirectoryDialogButton(
                        text = createAndEditDirectoryButtonText,
                        color = Color(createAndEditDirectoryDialogColors.createAndUpdateDirectoryButtonBackgroundColor),
                        onClick = {
                            // Manage Create And Edit Directory Dialog Button States
                            createFileFunctionality.manageModifyFolderDialogButtonStates(context = context)
                        }
                    )

                    // Close Modify Folder Dialog Button
                    CreateAndEditDirectoryDialogButton(
                        text = "Cancel",
                        color = Color(createAndEditDirectoryDialogColors.closeCreateAndEditDirectoryDialogButtonBackgroundColor),
                        onClick = {
                            // Close Create And Edit Directory Dialog
                            interfaceVisibilityFunctionality.closeModifyFolderDialog(context = context)
                        }
                    )
                }
            }
    }

    }
}}