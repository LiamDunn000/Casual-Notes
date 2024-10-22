package com.casual_notes.casualnotes

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_states.modifyNoteScreenStates
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_states.fileSelectionScreenStates
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_states.moveFileScreenStates
import com.casual_notes.casualnotes.data.shared_data.fileStates
import com.casual_notes.casualnotes.functionality.shared_functionality.generalFunctionality
import com.casual_notes.casualnotes.presentation.modify_note_screen.ModifyNoteScreen
import com.casual_notes.casualnotes.presentation.file_selection_screen.FileSelectionScreen
import com.casual_notes.casualnotes.presentation.move_file_screen.LandscapeMoveFileScreen
import com.casual_notes.casualnotes.presentation.move_file_screen.MoveFileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            // Initialization Of Directories
            fileStates.currentFolder.mkdirs()

            // Screen Orientation
            val screenOrientation = remember { mutableIntStateOf(this.resources.configuration.orientation)}

            // Nav Controller
            val navController = rememberNavController()

            // Manage Vibration Level
            generalFunctionality.manageVibrationLevel(context = this@MainActivity)

            NavHost(
                navController = navController,
                startDestination = fileSelectionScreenStates.fileSelectionScreenDestination) {

                // File Selection Screen
                composable(
                    fileSelectionScreenStates.fileSelectionScreenDestination ,

                    enterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
                    exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
                    ){
                    FileSelectionScreen(
                        context = this@MainActivity,
                        navController = navController
                    )
                }

                // Create And Edit File Screen
                composable(
                    modifyNoteScreenStates.createAndEditFileScreenDestination,

                    enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                    exitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
                ) {
                    ModifyNoteScreen(
                        context = this@MainActivity,
                        navController = navController)
                    }

                // Move File Screen
                composable(
                    moveFileScreenStates.moveFileScreenDestination,

                    enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                    exitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
                ) {
                    when { screenOrientation.intValue == Configuration.ORIENTATION_PORTRAIT -> {

                    MoveFileScreen(
                        context = this@MainActivity,
                        navController = navController
                    )
                } else -> {
                    LandscapeMoveFileScreen(
                        context = this@MainActivity,
                        navController = navController
                    )
                }
                    }}
                }
            }
        }
    }


