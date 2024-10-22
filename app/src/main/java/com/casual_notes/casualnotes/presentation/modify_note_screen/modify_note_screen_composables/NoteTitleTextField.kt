package com.casual_notes.casualnotes.presentation.modify_note_screen.modify_note_screen_composables

import android.content.Context
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.casual_notes.casualnotes.R
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_colors.modifyNoteScreenColors
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_states.modifyNoteScreenStates
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_dimensions.ModifyNoteScreenDimensions
import com.casual_notes.casualnotes.functionality.shared_functionality.navigationFunctionality

@Composable
fun NoteTitleTextField(
    context: Context,
    modifier: Modifier,
    navController: NavController) {

    // File Title Text Field
    TextField(
        value = modifyNoteScreenStates.noteTitleTextFieldValue,
        onValueChange = {
            modifyNoteScreenStates.noteTitleTextFieldValue = it
            modifyNoteScreenStates.isTextValueChanged = true},

        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(modifyNoteScreenColors.fileTitleTextFieldBackgroundColor),
            focusedContainerColor = Color(modifyNoteScreenColors.fileTitleTextFieldBackgroundColor),
            focusedIndicatorColor = Color(modifyNoteScreenColors.fileTitleTextFieldIndicatorColor),
            unfocusedIndicatorColor = Color(modifyNoteScreenColors.fileTitleTextFieldIndicatorColor)
        ),
        textStyle = TextStyle(
            color = Color(modifyNoteScreenColors.fileTitleTextFieldTextColor),
            fontSize = ModifyNoteScreenDimensions().fileTitleTextFieldFontSize.sp,
            fontFamily = FontFamily(Font(R.font.alegreya_sans_medium))
        ),

        modifier = modifier,
        singleLine = true,
        maxLines = 1,

        // File Title Text Field Placeholder
        placeholder = {
            when {
                modifyNoteScreenStates.noteTitleTextFieldValue == "" -> {
                    Text(
                        text = "Enter Title",
                        color = Color(modifyNoteScreenColors.fileTitleTextFieldTextColor),
                        fontSize = ModifyNoteScreenDimensions().fileTitleTextFieldFontSize.sp,
                        fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis)
                }            }
        },
        leadingIcon = {

            ModifyNoteScreenTopAppBarButton(
                icon = R.drawable.left,
                onClick = {
                    navigationFunctionality.navigateToFileSelectionScreenAndSaveFile(
                        context = context,
                        navController = navController)
                }
            )
        }

    )
}