package com.casual_notes.casualnotes.presentation.move_file_screen

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsIgnoringVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_colors.moveFileScreenColors
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_dimensions.MoveFileScreenDimensions
import com.casual_notes.casualnotes.functionality.file_functionality.loadFileFunctionality
import com.casual_notes.casualnotes.presentation.modify_folder_dialog.ModifyFolderDialog
import com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables.DestinationList
import com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables.FilesToMoveList
import com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables.MoveFileButton
import com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables.MoveFileScreenTopAppBar
import com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables.SelectedDestinationDisplay

@OptIn(ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MoveFileScreen(
    context: Context,
    navController: NavController
) {

    // Search Folders
    loadFileFunctionality.searchFolders()

    // Modify Folder Dialog
    ModifyFolderDialog(context = context)

    // Move File Screen Layout
    Scaffold(

        modifier = Modifier.padding(WindowInsets.navigationBarsIgnoringVisibility.asPaddingValues()),

        floatingActionButton = {

            // Move File Button
            MoveFileButton(
                context = context,
                navController = navController
            )
        }
    ) {

        Column(
            modifier = Modifier
                .background(color = Color(moveFileScreenColors.moveFileScreenBackgroundColor))
                .fillMaxSize()
        ) {

            // Move File Screen Top App Bar
            MoveFileScreenTopAppBar(
                context = context,
                navController = navController
            )

            // Move File Screen Body Layout
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        MoveFileScreenDimensions().moveFileScreenPadding.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    MoveFileScreenDimensions().moveFileScreenSpacing.dp
                )
            ) {

                // Files To Move List
                FilesToMoveList()

                // Selected Destination Display Text
                SelectedDestinationDisplay()

                // Destination List
                DestinationList(context = context)
            }
        }
    }
}