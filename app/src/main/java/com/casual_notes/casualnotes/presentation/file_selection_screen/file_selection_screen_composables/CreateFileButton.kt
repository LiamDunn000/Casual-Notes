package com.casual_notes.casualnotes.presentation.file_selection_screen.file_selection_screen_composables

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.casual_notes.casualnotes.R
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_colors.fileSelectionScreenColors
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_dimensions.FileSelectionScreenDimensions
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_states.fileSelectionScreenStates
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_states.modifyNoteScreenStates
import com.casual_notes.casualnotes.functionality.shared_functionality.interfaceVisibilityFunctionality
import com.casual_notes.casualnotes.functionality.shared_functionality.navigationFunctionality

@Composable
fun CreateFileButton(
    context: Context,
    navController: NavController
) {

    // Create Note Button Container Layout
    Column(
        modifier = Modifier
            .wrapContentSize(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {

        // File Type Selection Button Panel
        AnimatedVisibility(visible = fileSelectionScreenStates.isCreateFileButtonPressed) {

            Column(
                modifier = Modifier.padding(bottom = FileSelectionScreenDimensions().fileSelectionButtonPanelVerticalSpacing.dp),
                verticalArrangement = Arrangement.spacedBy(FileSelectionScreenDimensions().fileSelectionButtonPanelVerticalSpacing.dp),
            ) {

                Text(
                    text = "Note",
                    color = Color(fileSelectionScreenColors.fileTypeSelectionButtonTextColor),
                    fontSize = FileSelectionScreenDimensions().fileTypeSelectionButtonSize.sp,
                    fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
                    modifier = Modifier
                        .clickable {
                            modifyNoteScreenStates.isNoteBeingEdited = false
                            navigationFunctionality.navigateToModifyNoteScreen(
                                context = context,
                                navController = navController)
                        }
                )

                Text(
                    text = "Folder",
                    color = Color(fileSelectionScreenColors.fileTypeSelectionButtonTextColor),
                    fontSize = FileSelectionScreenDimensions().fileTypeSelectionButtonSize.sp,
                    fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
                    modifier = Modifier
                        .clickable {
                            interfaceVisibilityFunctionality.openModifyFolderDialog(context = context)
                        }
                    )
            }
        }

        // Create Note Button
        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(color = Color(fileSelectionScreenColors.createNoteButtonBackgroundColor))
                .size(size = FileSelectionScreenDimensions().createFileButtonSize.dp)
                .clickable { interfaceVisibilityFunctionality.toggleCreateFileButtonState(context = context) },
            contentAlignment = Alignment.Center
        ) {

            // Create Note Button Icon
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(0.5f),
                tint = Color(fileSelectionScreenColors.createNoteButtonIconColor)
            )
        }
    }
}