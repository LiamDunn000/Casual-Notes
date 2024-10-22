package com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.SubdirectoryArrowRight
import androidx.compose.material3.Icon
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
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_colors.MoveFileScreenColors
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_dimensions.MoveFileScreenDimensions
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_states.moveFileScreenStates
import com.casual_notes.casualnotes.data.shared_data.fileStates
import com.casual_notes.casualnotes.functionality.file_functionality.moveFileFunctionality
import com.casual_notes.casualnotes.functionality.shared_functionality.navigationFunctionality
import java.io.File

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DestinationListPanel(
    context: Context,
    file: File) {

    // Destination List Panel Text Color
    val destinationListPanelTextColor = when {
            moveFileScreenStates.selectedDestination == file ->
                Color(MoveFileScreenColors().destinationListPanelSelectedTextColor)
        file in fileStates.selectedFileList ->
            Color(MoveFileScreenColors().destinationListPanelDisabledTextColor)
        else -> Color(MoveFileScreenColors().destinationListPanelTextColor)
    }


    // Destination List Panel Button Color
    val destinationListPanelButtonColor = when {
            moveFileScreenStates.selectedDestination == file ->
                Color(MoveFileScreenColors().destinationListPanelSelectedButtonColor)
        file in fileStates.selectedFileList ->
            Color(MoveFileScreenColors().destinationListPanelDisabledButtonColor)
        else -> Color(MoveFileScreenColors().destinationListPanelButtonColor)
    }

    when { file.isDirectory ->

        // Destination List Panel Layout
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ) {

            // Destination List Panel Button
            Icon(
                imageVector = Icons.Rounded.SubdirectoryArrowRight,
                contentDescription = null,
                tint = destinationListPanelButtonColor,
                modifier = Modifier
                    .combinedClickable(
                        onClick = {
                            navigationFunctionality.navigateToNextMoveFolder(
                                context = context,
                                file = file)
                        },
                    )
                    .size(
                        size = MoveFileScreenDimensions().destinationListPanelButtonSize.dp
                    )
            )

            // Destination List Panel Text
            Text(
                text = file.name,
                color = destinationListPanelTextColor,
                fontSize = MoveFileScreenDimensions().destinationListPanelFontSize.sp,
                fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .selectable(
                        selected = (file == moveFileScreenStates.selectedDestination),
                        onClick = { moveFileFunctionality.selectDestinationToMoveFilesTo(
                            context = context,
                            file = file) }
                    )
                    .padding(MoveFileScreenDimensions().destinationListPanelPadding.dp)
                )
        }
    }
}