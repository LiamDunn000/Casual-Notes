package com.casual_notes.casualnotes.presentation.modify_note_screen.modify_note_screen_composables

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.casual_notes.casualnotes.R
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_colors.modifyNoteScreenColors
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_dimensions.ModifyNoteScreenDimensions
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_states.modifyNoteScreenStates
import com.casual_notes.casualnotes.data.shared_data.colors
import com.casual_notes.casualnotes.data.shared_data.undoAndRedoFunctionality

@Composable
fun ModifyNoteScreenTopAppBar(
    context: Context,
    navController: NavController) {

    // Modify Note Screen Top App Bar Layout
    Row(
        modifier = Modifier
            .background(color = Color(modifyNoteScreenColors.modifyNoteScreenTopAppBarBackgroundColor))
            .fillMaxWidth()
            .height(
                height = ModifyNoteScreenDimensions().modifyNoteScreenTopAppBarHeight.dp
            )
            .padding(
                top = ModifyNoteScreenDimensions().modifyNoteScreenTopAppBarTopPadding.dp,
                start = ModifyNoteScreenDimensions().modifyNoteScreenTopAppBarHorizontalPadding.dp,
                end = ModifyNoteScreenDimensions().modifyNoteScreenTopAppBarHorizontalPadding.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Note Title Text Field
        NoteTitleTextField(
            context = context,
            modifier = Modifier.weight(ModifyNoteScreenDimensions().noteTitleTextFieldWeight),
            navController = navController)

        // Undo Button
        ModifyNoteScreenTopAppBarButton(
            modifier = Modifier.weight(ModifyNoteScreenDimensions().undoAndRedoButtonWeight),
            icon = R.drawable.undo_button,
            size = ModifyNoteScreenDimensions().undoAndRedoButtonSize.toInt(),
            onClick = {
                undoAndRedoFunctionality.undoText()
            }
        )

        // Toggle Read Only Button
        ModifyNoteScreenTopAppBarButton(
            modifier = Modifier.weight(ModifyNoteScreenDimensions().undoAndRedoButtonWeight),
            icon = R.drawable.open_book__1_,
            color = when {
                modifyNoteScreenStates.isTextFieldReadOnly -> Color(colors.lightGray)
                else -> Color(modifyNoteScreenColors.modifyNoteScreenTopAppBarButtonColor)},
            size = ModifyNoteScreenDimensions().undoAndRedoButtonSize.toInt(),
            onClick = {
                modifyNoteScreenStates.isTextFieldReadOnly = !modifyNoteScreenStates.isTextFieldReadOnly
            }
        )
    }
}