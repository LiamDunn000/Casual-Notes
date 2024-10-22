package com.casual_notes.casualnotes.presentation.file_selection_screen.file_selection_screen_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_colors.fileSelectionScreenColors
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_dimensions.FileSelectionScreenDimensions
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_states.fileSelectionScreenStates

@Composable
fun SavedFileSelectionPanelRadioButton(
    isFileSelected: Boolean
) {

    // Saved File Selection Panel Radio Button Container Layout
    Box(
        modifier = Modifier
            .background(Color(fileSelectionScreenColors.savedFileSelectionPanelRadioButtonContainerBackgroundColor))
            .width(
                width = FileSelectionScreenDimensions().savedFileSelectionPanelRadioButtonContainerWidth.dp
            )
            .fillMaxHeight()
            .padding(
                top = FileSelectionScreenDimensions().savedFileSelectionPanelRadioButtonTopPadding.dp
            ),
        contentAlignment = Alignment.TopEnd
    ){

        when {
            fileSelectionScreenStates.isFileEditPanelOpenVisible -> {


        // Saved File Selection Panel Radio Button
        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .border(
                    width = 2.dp,
                    color = Color(fileSelectionScreenColors.savedFileSelectionPanelRadioButtonBorderColor),
                    shape = CircleShape
                )
                .background(
                    color = Color(fileSelectionScreenColors.savedFileSelectionPanelRadioButtonBackgroundColor)
                )
                .size(FileSelectionScreenDimensions().savedFileSelectionPanelRadioButtonSize.dp),
            contentAlignment = Alignment.Center
        ){

            // Saved File Selection Panel Radio Button Indicator
            Box(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .background(
                        color = when (isFileSelected) {
                            true -> Color(fileSelectionScreenColors.savedFileSelectionPanelRadioButtonSelectedIndicatorColor)
                            else -> Color(fileSelectionScreenColors.savedFileSelectionPanelRadioButtonUnselectedIndicatorColor)
                        }
                    )
                    .fillMaxSize(0.5f),
            )
                }
            }
        }
    }
}