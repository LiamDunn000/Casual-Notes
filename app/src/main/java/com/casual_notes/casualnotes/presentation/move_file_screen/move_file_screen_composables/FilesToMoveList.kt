package com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casual_notes.casualnotes.R
import com.casual_notes.casualnotes.data.delete_file_confirmation_dialog_data.delete_file_confirmation_dialog_colors.deleteFileConfirmationDialogColors
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_colors.moveFileScreenColors
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_dimensions.MoveFileScreenDimensions
import com.casual_notes.casualnotes.data.shared_data.fileStates

@Composable
fun FilesToMoveList() {

    // Files To Move List Layout
    Column(
        modifier = Modifier
            .background(color = Color(moveFileScreenColors.filesToMoveListBackgroundColor))
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            MoveFileScreenDimensions().filesToMoveListSpacing.dp
        )
    ) {

        // Files To Move List Header
        FilesToMoveListHeader()

        // Files To Move List
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center


        ) {
            items(fileStates.selectedFileList) {file ->

                // Files To Move List Panel Layout
                Box(
                    modifier = Modifier
                        .padding(horizontal = MoveFileScreenDimensions().filesToMoveListItemSpacing.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(Color(moveFileScreenColors.filesToMoveListItemBackgroundColor))
                        .padding(MoveFileScreenDimensions().filesToMoveListItemPadding.dp)
                ) {

                    // Files To Move Name
                    Text(
                        text = file.name,
                        color = Color(moveFileScreenColors.filesToMoveListFileNameTextColor),
                        fontSize = MoveFileScreenDimensions().fileToMoveListNameFontSize.sp,
                        fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}