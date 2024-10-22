package com.casual_notes.casualnotes.presentation.file_selection_screen.file_selection_screen_composables

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoveUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_colors.fileSelectionScreenColors
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_dimensions.FileSelectionScreenDimensions
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_states.fileSelectionScreenStates
import com.casual_notes.casualnotes.data.shared_data.fileStates
import com.casual_notes.casualnotes.functionality.file_functionality.updateFileFunctionality
import com.casual_notes.casualnotes.functionality.shared_functionality.interfaceVisibilityFunctionality
import com.casual_notes.casualnotes.functionality.shared_functionality.navigationFunctionality

@Composable
fun FileEditPanel(
    context: Context,
    navController: NavController
    ) {

    val editFileButtonEnabledCondition = when {
        fileStates.selectedFileList.size > 1 -> false
        else -> true
    }

    // File Edit Panel Layout
    AnimatedVisibility(visible = fileSelectionScreenStates.isFileEditPanelOpenVisible,
        enter = slideInVertically (animationSpec = tween(
            durationMillis = 100
        ), initialOffsetY = { it }),
        exit = slideOutVertically (animationSpec = tween(
            durationMillis = 100
        ), targetOffsetY = { it })) {

        Row(
            modifier = Modifier
                .background(color = Color(fileSelectionScreenColors.fileEditPanelBackgroundColor))
                .fillMaxWidth()
                .height(FileSelectionScreenDimensions().fileEditPanelHeight.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Move File Button
            FileEditPanelButton(
                icon = Icons.Filled.MoveUp,
                text = " Move",
                onClick = {
                    navigationFunctionality.navigateToMoveFileScreen(
                        context = context,
                        navController = navController)
                }
            )

            // Delete File Button
            FileEditPanelButton(
                icon = Icons.Filled.Delete,
                text = "Delete",
                onClick = { interfaceVisibilityFunctionality.openDeleteFileConfirmationDialog(
                    context = context
                ) }
            )

            // Edit File Button
            FileEditPanelButton(
                icon = Icons.Filled.Edit,
                text = "Edit",
                enabled = editFileButtonEnabledCondition,
                onClick = {
                    updateFileFunctionality.editFile(context = context)

                }
            )
        }
    }
}