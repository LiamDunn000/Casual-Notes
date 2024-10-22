package com.casual_notes.casualnotes.presentation.file_selection_screen.file_selection_screen_composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_colors.fileSelectionScreenColors
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_dimensions.FileSelectionScreenDimensions

@Composable
fun FileSelectionScreenTopAppBarButton(
    modifier: Modifier,
    icon: ImageVector,
    onClick: () -> Unit
) {
    // File Selection Screen Top App Bar Button
    Icon(
        imageVector = icon,
        contentDescription = null,
        modifier = modifier
            .clickable {
                onClick()
            }
            .size(size = FileSelectionScreenDimensions().fileSelectionScreenTopAppBarButtonSize.dp),
        tint = Color(fileSelectionScreenColors.fileSelectionScreenOptionsButtonBackgroundColor)
    )
}