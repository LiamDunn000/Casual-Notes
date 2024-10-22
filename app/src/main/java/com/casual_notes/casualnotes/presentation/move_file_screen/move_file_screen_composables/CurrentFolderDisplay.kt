package com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.SubdirectoryArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casual_notes.casualnotes.R
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_colors.moveFileScreenColors
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_dimensions.MoveFileScreenDimensions
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_states.moveFileScreenStates
import com.casual_notes.casualnotes.functionality.file_functionality.moveFileFunctionality
import com.casual_notes.casualnotes.functionality.shared_functionality.navigationFunctionality

@Composable
fun CurrentFolderDisplay(context: Context) {

    val currentFolderDisplayTextColor = when {
        moveFileScreenStates.selectedDestination == moveFileScreenStates.currentMoveFolder ->
            Color(moveFileScreenColors.currentFolderDisplaySelectedTextColor)
        else -> Color(moveFileScreenColors.currentFolderDisplayTextColor)
    }

    val currentFolderDisplayButtonColor = when {
        moveFileScreenStates.selectedDestination == moveFileScreenStates.currentMoveFolder ->
            Color(moveFileScreenColors.currentFolderDisplaySelectedButtonColor)
        else -> Color(moveFileScreenColors.currentFolderDisplayButtonColor)
    }

    // Current Folder Display Layout
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(moveFileScreenColors.currentFolderDisplayBackgroundColor)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Current Folder Display Button
        when { moveFileScreenStates.currentMoveFolder.name != "Home" -> {
            Icon(
                imageVector = Icons.Rounded.SubdirectoryArrowLeft,
                contentDescription = null,
                tint = currentFolderDisplayButtonColor,
                modifier = Modifier
                    .clickable{
                            navigationFunctionality.navigateToPreviousFolderWithinMoveFileScreen(
                                context = context
                            )
                    })
        }}

        // Current Folder Display Text
        Text(
            text = moveFileScreenStates.currentMoveFolder.name,
            color = currentFolderDisplayTextColor,
            fontSize = MoveFileScreenDimensions().currentFolderDisplayFontSize.sp,
            fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
            modifier = Modifier
                .selectable(
                    selected = (moveFileScreenStates.selectedDestination == moveFileScreenStates.currentMoveFolder),
                    onClick = { moveFileFunctionality.selectDestinationToMoveFilesTo(
                        context = context,
                        file = moveFileScreenStates.currentMoveFolder) }
                )
                .padding(MoveFileScreenDimensions().destinationListPanelPadding.dp)
        )
    }
}