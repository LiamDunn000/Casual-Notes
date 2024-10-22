package com.casual_notes.casualnotes.presentation.file_selection_screen.file_selection_screen_composables

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_colors.fileSelectionScreenColors
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_dimensions.FileSelectionScreenDimensions
import com.casual_notes.casualnotes.functionality.shared_functionality.interfaceVisibilityFunctionality
import com.casual_notes.casualnotes.functionality.shared_functionality.navigationFunctionality
import com.casual_notes.casualnotes.presentation.options_menu.OptionsMenu

@Composable
fun FileSelectionScreenTopAppBar(context: Context) {

    // File Selection Screen Top App Bar Layout
    Row(
        modifier = Modifier
            .background(
                color = Color(fileSelectionScreenColors.fileSelectionScreenTopAppBarBackgroundColor),
            )
            .fillMaxWidth()
            .height(FileSelectionScreenDimensions().fileSelectionScreenTopAppBarHeight.dp)
            .padding(
                top = FileSelectionScreenDimensions().fileSelectionScreenTopAppBarTopPadding.dp,
                start = FileSelectionScreenDimensions().fileSelectionScreenTopAppBarHorizontalPadding.dp,
                end = FileSelectionScreenDimensions().fileSelectionScreenTopAppBarHorizontalPadding.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // File Search Bar
         FileSearchBar(
            modifier = Modifier.weight(FileSelectionScreenDimensions().fileSearchBarWeight))

        // File Selection Screen Back Button
        FileSelectionScreenTopAppBarButton(
            modifier = Modifier.weight(FileSelectionScreenDimensions().fileSelectionScreenTopAppBarButtonWeight),
            icon = Icons.Default.ArrowBack,
            onClick = { navigationFunctionality.navigateToPreviousFolder(context = context)}
        )

        // File Selection Screen Options Button
        FileSelectionScreenTopAppBarButton(
            modifier = Modifier.weight(FileSelectionScreenDimensions().fileSelectionScreenTopAppBarButtonWeight),
            icon = Icons.Default.MoreVert,
            onClick = {

                interfaceVisibilityFunctionality.openOptionsMenu(context = context)
            }
        )

        OptionsMenu(context = context)
    }
}