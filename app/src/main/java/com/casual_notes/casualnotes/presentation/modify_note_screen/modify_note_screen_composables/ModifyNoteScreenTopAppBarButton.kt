package com.casual_notes.casualnotes.presentation.modify_note_screen.modify_note_screen_composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_colors.modifyNoteScreenColors
import com.casual_notes.casualnotes.data.modify_note_screen_data.modify_note_screen_dimensions.ModifyNoteScreenDimensions

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ModifyNoteScreenTopAppBarButton(
    modifier: Modifier = Modifier,
    icon: Int,
    onClick: () -> Unit,
    enable: Boolean = true,
    color: Color = Color(modifyNoteScreenColors.modifyNoteScreenTopAppBarButtonColor),
    size: Int = ModifyNoteScreenDimensions().backButtonIconSize.toInt()
) {

    // Modify Note Screen Top App Bar Button
    Image(
        painter = painterResource(icon),
        contentDescription = null,
        colorFilter = ColorFilter.tint(color = color),
        modifier = modifier
            .combinedClickable(
                enabled = enable,
                onLongClick = { onClick() },
                onClick = { onClick() }
            )
            .size(size = size.dp)
    )
}