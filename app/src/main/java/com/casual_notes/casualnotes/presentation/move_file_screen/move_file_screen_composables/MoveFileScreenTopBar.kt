package com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables

import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.CreateNewFolder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_colors.moveFileScreenColors
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_dimensions.MoveFileScreenDimensions
import com.casual_notes.casualnotes.functionality.shared_functionality.interfaceVisibilityFunctionality
import com.casual_notes.casualnotes.functionality.shared_functionality.navigationFunctionality

@Composable
fun MoveFileScreenTopAppBar(
    context: Context,
    navController: NavController) {

    // Navigates To File Selection Screen On Back Button Press
    BackHandler { navigationFunctionality.navigateToFileSelectionScreen(
        context = context,
        navController = navController
    ) }

    // Move File Screen Top App Bar Layout
    Row(
        modifier = Modifier
            .background(
                color = Color(moveFileScreenColors.moveFileScreenTopAppBarBackgroundColor),
            )
            .fillMaxWidth()
            .height(MoveFileScreenDimensions().moveFileScreenTopAppBarHeight.dp)
            .padding(
                top = MoveFileScreenDimensions().moveFileScreenTopAppBarTopPadding.dp,
                start = MoveFileScreenDimensions().moveFileScreenTopAppBarHorizontalPadding.dp,
                end = MoveFileScreenDimensions().moveFileScreenTopAppBarHorizontalPadding.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Folder Search Bar
        FolderSearchBar(
            modifier = Modifier.weight(MoveFileScreenDimensions().folderSearchBarWeight))

        // Create New Folder Button
        MoveFileScreenTopAppBarButton(
            modifier = Modifier.weight(MoveFileScreenDimensions().moveFileScreenTopAppBarButtonWeight),
            context = context,
            icon = Icons.Rounded.CreateNewFolder,
            onClick = {
                interfaceVisibilityFunctionality.openModifyFolderDialog(context = context)
            }
        )

        // Move File Screen Back Button
        MoveFileScreenTopAppBarButton(
            modifier = Modifier.weight(MoveFileScreenDimensions().moveFileScreenTopAppBarButtonWeight),
            context = context,
            icon = Icons.Rounded.ArrowBack,
            onClick = { navigationFunctionality.navigateToFileSelectionScreen(
                context = context,
                navController = navController
            ) })
    }
}