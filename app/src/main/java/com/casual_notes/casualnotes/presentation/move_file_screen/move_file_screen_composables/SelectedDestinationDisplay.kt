package com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casual_notes.casualnotes.R
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_colors.moveFileScreenColors
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_dimensions.MoveFileScreenDimensions
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_states.moveFileScreenStates
import com.casual_notes.casualnotes.data.shared_data.fileStates

@Composable
fun SelectedDestinationDisplay() {

    val selectedDestinationDisplayText = when {
        fileStates.selectedFileList.size == 1 -> "Move 1 File To"
        else -> "Move ${fileStates.selectedFileList.size} Files To"
    }

    // Selected Destination Display Layout

    Column(
        modifier = Modifier
            .background(color = Color(moveFileScreenColors.selectedDestinationDisplayTextBackgroundColor))
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Selected Destination Display Header
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Selected Destination Display Header Decorative Line
            Box(
                modifier = Modifier
                    .background(color = Color(moveFileScreenColors.selectedDestinationDisplayTextHeaderDecorativeLineColor))
                    .height(height = MoveFileScreenDimensions().selectedDestinationDisplayTextDecorativeLineHeight.dp)
                    .weight(weight = MoveFileScreenDimensions().selectedDestinationDisplayTextHeaderDecorativeLineWeight)
            )

            // Selected Destination Display Header Text
            Text(
                text = selectedDestinationDisplayText,
                color = Color(moveFileScreenColors.selectedDestinationDisplayTextHeaderTextColor),
                fontSize = MoveFileScreenDimensions().selectedDestinationDisplayTextHeaderFontSize.sp,
                fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(MoveFileScreenDimensions().selectedDestinationDisplayTextHeaderTextPadding.dp)
            )

            // Selected Destination Display Header Decorative Line
            Box(
                modifier = Modifier
                    .background(color = Color(moveFileScreenColors.selectedDestinationDisplayTextHeaderDecorativeLineColor))
                    .height(height = MoveFileScreenDimensions().selectedDestinationDisplayTextDecorativeLineHeight.dp)
                    .weight(weight = MoveFileScreenDimensions().selectedDestinationDisplayTextHeaderDecorativeLineWeight)
            )
        }

        // Selected Destination Display Text
        Text(
            text = moveFileScreenStates.selectedDestination.name,
            color = Color(moveFileScreenColors.selectedDestinationDisplayTextColor),
            fontSize = MoveFileScreenDimensions().selectedDestinationDisplayTextFontSize.sp,
            fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(MoveFileScreenDimensions().selectedDestinationDisplayTextPadding.dp)
        )
    }
}