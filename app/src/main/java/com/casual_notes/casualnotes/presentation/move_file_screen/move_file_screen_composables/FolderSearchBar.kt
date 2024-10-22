package com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casual_notes.casualnotes.R
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_colors.moveFileScreenColors
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_dimensions.MoveFileScreenDimensions
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_states.moveFileScreenStates
import com.casual_notes.casualnotes.functionality.file_functionality.updateFileFunctionality

@Composable
fun FolderSearchBar(
    modifier: Modifier
) {

    // Folder Search Bar Layout
    TextField(
        value = moveFileScreenStates.folderSearchBarTextFieldValue,

        onValueChange = { // Recompose File List when Search Bar Value Changes
            moveFileScreenStates.folderSearchBarTextFieldValue = it
            updateFileFunctionality.recomposeMoveFileList()},

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(moveFileScreenColors.folderSearchBarBackgroundColor),
            unfocusedContainerColor = Color(moveFileScreenColors.folderSearchBarBackgroundColor),
            focusedIndicatorColor = Color(moveFileScreenColors.folderSearchBarIndicatorColor),
            unfocusedIndicatorColor = Color(moveFileScreenColors.folderSearchBarIndicatorColor)

        ),
        textStyle = TextStyle(
            color = Color(moveFileScreenColors.folderSearchBarTextColor),
            fontSize = MoveFileScreenDimensions().folderSearchBarFontSize.sp,
            fontFamily = FontFamily(Font(R.font.alegreya_sans_medium))
        ),

        // Folder Search Bar Leading Icon
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = modifier.size(size = MoveFileScreenDimensions().folderSearchBarIconSize.dp),
                tint = Color(moveFileScreenColors.folderSearchBarIconColor)
            )
        },

        // Folder Search Bar Trailing Icon
        placeholder = {
            Text(
                text = "Search Folders",
                color = Color(moveFileScreenColors.folderSearchBarTextColor),
                fontSize = MoveFileScreenDimensions().folderSearchBarFontSize.sp,
                fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis )
        },

        singleLine = true,
        maxLines = 1,
        modifier = modifier
    )
}