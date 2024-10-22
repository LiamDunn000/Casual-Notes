package com.casual_notes.casualnotes.presentation.file_selection_screen

import android.annotation.SuppressLint
import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsIgnoringVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_dimensions.FileSelectionScreenDimensions
import com.casual_notes.casualnotes.functionality.file_functionality.loadFileFunctionality
import com.casual_notes.casualnotes.functionality.shared_functionality.navigationFunctionality
import com.casual_notes.casualnotes.presentation.modify_folder_dialog.ModifyFolderDialog
import com.casual_notes.casualnotes.presentation.delete_file_confirmation_dialog.DeleteFileConfirmationDialog
import com.casual_notes.casualnotes.presentation.file_selection_screen.file_selection_screen_composables.CreateFileButton
import com.casual_notes.casualnotes.presentation.file_selection_screen.file_selection_screen_composables.FileEditPanel
import com.casual_notes.casualnotes.presentation.file_selection_screen.file_selection_screen_composables.FileSelectionScreenTopAppBar
import com.casual_notes.casualnotes.presentation.file_selection_screen.file_selection_screen_composables.SavedFileSelectionList

@OptIn(ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FileSelectionScreen(
    context: Context,
    navController: NavController) {

    // Navigate To Previous Directory When Back Button Is Pressed
    BackHandler { navigationFunctionality.navigateToPreviousFolder(context = context) }

    loadFileFunctionality.searchFolderFiles()

    // Delete File Confirmation Dialog
    DeleteFileConfirmationDialog(context = context)

    // Note Selection Screen Layout
        Scaffold(

            modifier = Modifier.padding(WindowInsets.navigationBarsIgnoringVisibility.asPaddingValues()),

            // Create Note Button
            floatingActionButton = {
                CreateFileButton(
                    context = context,
                    navController = navController)
            },

            bottomBar = {
                FileEditPanel(
                    context = context,
                    navController = navController)
            }
        ) {
            ModifyFolderDialog(context = context)

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                // Note Selection Screen Top App Bar
                FileSelectionScreenTopAppBar(context = context)

                Column(
                    modifier = Modifier
                        .padding(FileSelectionScreenDimensions().savedFileSelectionListPadding.dp)
                ) {
                    SavedFileSelectionList(
                        context = context,
                        navController = navController)
                }

                    }
                }
            }