package com.casual_notes.casualnotes.presentation.file_selection_screen.file_selection_screen_composables

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
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_colors.fileSelectionScreenColors
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_dimensions.FileSelectionScreenDimensions
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_states.fileSelectionScreenStates
import com.casual_notes.casualnotes.data.shared_data.fileStates
import com.casual_notes.casualnotes.functionality.file_functionality.updateFileFunctionality

@Composable
fun FileSearchBar(
    modifier: Modifier
) {

    // File Search Bar Layout
    TextField(
        value = fileSelectionScreenStates.searchBarTextFieldValue,

        onValueChange = { // Recompose File List when Search Bar Value Changes
            fileSelectionScreenStates.searchBarTextFieldValue = it
            updateFileFunctionality.recomposeFileList()},

        colors = TextFieldDefaults.colors(
            focusedContainerColor = fileSelectionScreenColors.searchBarBackgroundColor,
            unfocusedContainerColor = fileSelectionScreenColors.searchBarBackgroundColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent

        ),
        textStyle = TextStyle(
            color = Color(fileSelectionScreenColors.searchBarTextColor),
            fontSize = FileSelectionScreenDimensions().fileSearchBarFontSize.sp,
            fontFamily = FontFamily(Font(R.font.alegreya_sans_medium))
        ),

        // File Search Bar Leading Icon
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = modifier.size(size = FileSelectionScreenDimensions().fileSearchBarIconSize.dp),
                tint = Color(fileSelectionScreenColors.searchBarIconColor)
            )
        },

        // File Search Bar Trailing Icon
        placeholder = {
            Text(
                text = "Search ${fileStates.currentFolder.name}...",
                color = Color(fileSelectionScreenColors.searchBarTextColor),
                fontSize = FileSelectionScreenDimensions().fileSearchBarFontSize.sp,
                fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis )
                      },

        singleLine = true,
        maxLines = 1,
        modifier = modifier
    )
}