package com.casual_notes.casualnotes.presentation.modify_note_screen.modify_note_screen_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casual_notes.casualnotes.R
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_colors.modifyNoteScreenColors
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_states.modifyNoteScreenStates
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_dimensions.ModifyNoteScreenDimensions
import com.casual_notes.casualnotes.data.shared_data.undoAndRedoFunctionality

@Composable
fun NoteContentTextField() {

    LaunchedEffect(modifyNoteScreenStates.isTextBeingDocumented) {
       // delay(4000)
        undoAndRedoFunctionality.determineIfTextIsBeingDocumented()
    }

    // File Content Text Field
    Box(
        modifier = Modifier
            .background(Color(modifyNoteScreenColors.fileContentTextFieldBackgroundColor))
            .fillMaxSize()
            .padding(ModifyNoteScreenDimensions().fileContentTextFieldPadding.dp)
    ) {
        TextField(
            value = modifyNoteScreenStates.noteContentTextFieldValue,
            onValueChange = {
                 modifyNoteScreenStates.noteContentTextFieldValue = it
                modifyNoteScreenStates.isTextValueChanged = true
                undoAndRedoFunctionality.launchTextTrackingTimer()
                            },

            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(modifyNoteScreenColors.fileContentTextFieldBackgroundColor),
                focusedContainerColor = Color(modifyNoteScreenColors.fileContentTextFieldBackgroundColor),
            ),

            textStyle = TextStyle(
                color = Color(modifyNoteScreenColors.fileContentTextFieldTextColor),
                fontSize = ModifyNoteScreenDimensions().fileContentTextFieldFontSize.sp,
                fontFamily = FontFamily(Font(R.font.alegreya_sans_medium))
            ),

            readOnly = when{
                modifyNoteScreenStates.isTextFieldReadOnly -> true
                else -> false
            },

            modifier = Modifier.fillMaxSize(),
        )
    }
}