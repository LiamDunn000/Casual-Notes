package com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_colors.moveFileScreenColors
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_dimensions.MoveFileScreenDimensions

@Composable
fun MoveFileScreenTopAppBarButton(
    modifier: Modifier,
    context: Context,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    // File Selection Screen Top App Bar Button
    Icon(
        imageVector = icon,
        contentDescription = null,
        modifier = modifier
            .clickable {onClick() }
            .size(size = MoveFileScreenDimensions().moveFileScreenTopAppBarButtonSize.dp),
        tint = Color(moveFileScreenColors.moveFileScreenTopAppBarButtonColor)
    )
}