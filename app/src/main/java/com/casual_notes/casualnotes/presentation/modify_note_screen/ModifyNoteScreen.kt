package com.casual_notes.casualnotes.presentation.modify_note_screen

import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.casual_notes.casualnotes.functionality.shared_functionality.navigationFunctionality
import com.casual_notes.casualnotes.presentation.modify_note_screen.modify_note_screen_composables.ModifyNoteScreenTopAppBar
import com.casual_notes.casualnotes.presentation.modify_note_screen.modify_note_screen_composables.NoteContentTextField

@Composable
fun ModifyNoteScreen(
    context: Context,
    navController: NavController) {

    // Navigate To File Selection Screen When Back Button Is Pressed
    BackHandler { navigationFunctionality.navigateToFileSelectionScreenAndSaveFile(
        context = context,
        navController = navController) }

    // Create And Edit File Screen Layout
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        // Create And Edit File Screen Top App Bar
        ModifyNoteScreenTopAppBar(
            context = context,
            navController = navController)

        // File Content Text Field
        NoteContentTextField()

    }
}