package com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import com.casual_notes.casualnotes.data.shared_data.fileStates

@Composable
fun FilesToMoveListHeader() {

    // Files To Move Header Text
    val filesToMoveHeaderText = when {
        fileStates.selectedFileList.size == 1 -> "1 File To Move"
        else -> "${fileStates.selectedFileList.size} Files To Move"}

    // Files To Move List Header Layout
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Files To Move Header Decorative Line
        Box(
            modifier = Modifier
                .background(color = Color(moveFileScreenColors.filesToMoveHeaderDecorativeLineColor))
                .height(height = MoveFileScreenDimensions().filesToMoveListHeaderDecorativeLineHeight.dp)
                .weight(weight = MoveFileScreenDimensions().filesToMoveListHeaderDecorativeLineWeight)
        )

        // Files To Move Header Text
        Text(
            text = filesToMoveHeaderText,
            color = Color(moveFileScreenColors.filesToMoveListHeaderTextColor),
            fontSize = MoveFileScreenDimensions().filesToMoveListHeaderFontSize.sp,
            fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(MoveFileScreenDimensions().filesToMoveListHeaderTextPadding.dp)
        )

        // Files To Move Header Decorative Line
        Box(
            modifier = Modifier
                .background(color = Color(moveFileScreenColors.filesToMoveHeaderDecorativeLineColor))
                .height(height = MoveFileScreenDimensions().filesToMoveListHeaderDecorativeLineHeight.dp)
                .weight(weight = MoveFileScreenDimensions().filesToMoveListHeaderDecorativeLineWeight)
        )
    }
}