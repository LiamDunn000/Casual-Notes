package com.casual_notes.casualnotes.presentation.file_selection_screen.file_selection_screen_composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_colors.fileSelectionScreenColors
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_dimensions.FileSelectionScreenDimensions

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FileEditPanelButton(
    icon: ImageVector,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {

    // File Edit Panel Button Icon Color
    val fileEditPanelButtonIconColor = when (enabled) {
        true -> Color(fileSelectionScreenColors.fileEditPanelEnabledButtonIconColor)
        false -> Color(fileSelectionScreenColors.fileEditPanelDisabledButtonIconColor)
    }

    // File Edit Panel Button Text Color
    val fileEditPanelButtonTextColor = when (enabled) {
        true -> Color(fileSelectionScreenColors.fileEditPanelEnabledButtonTextColor)
        false -> Color(fileSelectionScreenColors.fileEditPanelDisabledButtonTextColor)
    }

    // File Edit Panel Button Layout
    Column(
        modifier = Modifier
            .combinedClickable(
                enabled = enabled,
                onClick = onClick
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // File Edit Panel Button Icon
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = fileEditPanelButtonIconColor,
            modifier = Modifier
                .size(FileSelectionScreenDimensions().editFileBoxButtonIconSize.dp)
        )

        // File Edit Panel Button Text
        Text(
            text = text,
            color = fileEditPanelButtonTextColor,
            fontSize = FileSelectionScreenDimensions().editFileBoxButtonFontSize.sp,
            modifier = Modifier
        )
        }
    }
