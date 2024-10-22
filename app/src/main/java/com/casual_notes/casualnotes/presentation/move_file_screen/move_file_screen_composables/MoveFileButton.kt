package com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoveUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_colors.fileSelectionScreenColors
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_colors.moveFileScreenColors
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_dimensions.MoveFileScreenDimensions
import com.casual_notes.casualnotes.data.shared_data.screenDimensions
import com.casual_notes.casualnotes.functionality.file_functionality.moveFileFunctionality

@Composable
fun MoveFileButton(
    context: Context,
    navController: NavController
    ) {

        // Move File Button
        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(color = Color(moveFileScreenColors.moveFileButtonBackgroundColor))
                .size(size = MoveFileScreenDimensions().moveFileButtonSize.dp)
                .clickable { moveFileFunctionality.moveSelectedFiles(
                    context = context,
                    navController = navController) },
            contentAlignment = Alignment.Center
        ) {

            // Create Note Button Icon
            Icon(
                imageVector = Icons.Rounded.MoveUp,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(0.5f),
                tint = Color(moveFileScreenColors.moveFileButtonIconColor)
            )
        }
    }
