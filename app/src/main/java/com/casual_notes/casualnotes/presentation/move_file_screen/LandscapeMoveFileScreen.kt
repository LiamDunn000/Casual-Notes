package com.casual_notes.casualnotes.presentation.move_file_screen

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsIgnoringVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_dimensions.MoveFileScreenDimensions
import com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables.DestinationList
import com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables.FilesToMoveList
import com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables.MoveFileButton
import com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables.MoveFileScreenTopAppBar
import com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables.SelectedDestinationDisplay

@OptIn(ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LandscapeMoveFileScreen(
    context: Context,
    navController: NavController
) {

    Scaffold(

        modifier = Modifier.padding(WindowInsets.navigationBarsIgnoringVisibility.asPaddingValues()),

        topBar = {

            // Move File Screen Top App Bar
            MoveFileScreenTopAppBar(
                context = context,
                navController = navController
            )

        },

        floatingActionButton = {

            // Move File Button
            MoveFileButton(
                context = context,
                navController = navController
            )
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            //horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {

            Column(
                modifier = Modifier
                    .fillMaxHeight(0.8f)
                    .weight(1f)
                    .padding(MoveFileScreenDimensions().moveFileScreenPadding.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Files To Move List
                FilesToMoveList()

                // Selected Destination Display Text
                SelectedDestinationDisplay()
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight(0.8f)
                    .weight(1f)
                    .padding(MoveFileScreenDimensions().moveFileScreenPadding.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Destination List
                DestinationList(context = context)

            }
        }
    }
}