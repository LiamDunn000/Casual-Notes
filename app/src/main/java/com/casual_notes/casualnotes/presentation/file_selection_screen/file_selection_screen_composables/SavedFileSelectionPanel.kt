package com.casual_notes.casualnotes.presentation.file_selection_screen.file_selection_screen_composables

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Folder
import androidx.compose.material.icons.rounded.StickyNote2
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_colors.fileSelectionScreenColors
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_dimensions.FileSelectionScreenDimensions
import com.casual_notes.casualnotes.functionality.file_functionality.manageFileFunctionality
import com.casual_notes.casualnotes.functionality.file_functionality.updateFileFunctionality
import java.io.File

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SavedFileSelectionPanel(
    context: Context,
    navController: NavController,
    file: File,
    fileName: String,
    lastModified: String
) {

    // Is File Selected
    var isFileSelected by rememberSaveable { mutableStateOf(false) }

    // File Type Icon
    val fileTypeIcon = when {file.isDirectory -> Icons.Rounded.Folder
        else -> Icons.Rounded.StickyNote2}

    val savedFileSelectionPanelBorderColor = when (isFileSelected){
        true -> Color(fileSelectionScreenColors.savedFileSelectionPanelSelectedBorderColor)
        false -> Color(fileSelectionScreenColors.savedFileSelectionPanelUnselectedBorderColor)
    }

    // File Selection Management
    fun selectFile() { isFileSelected = true }
    fun unselectFile() { isFileSelected = false }
    fun toggleFileSelection() { isFileSelected = !isFileSelected }

    // Manage File Edit Panel State
    updateFileFunctionality.manageFileEditPanelState(
        file = file,
        selectFile = { selectFile() },
        unSelectFile = { unselectFile() }
    )

    // Saved File Selection Panel Layout
    Row(
        modifier = Modifier
            .combinedClickable(

                // Manage File Panel On Click State
                onClick = {
                    manageFileFunctionality.manageSavedFilePanelOnClickState(
                        context = context,
                        navController = navController,
                        file = file,
                        isFileSelected = isFileSelected,
                        selectFile = { selectFile() },
                        unselectFile = { unselectFile() }
                    )
                },

                // Manage File Panel On Long Click State
                onLongClick = {
                    toggleFileSelection()
                    manageFileFunctionality.manageSavedFilePanelOnLongClickState(
                        context = context,
                        file = file,
                        isFileSelected = isFileSelected,
                    )
                }

            )
            .border(
                width = FileSelectionScreenDimensions().savedFileSelectionPanelBorderWidth.dp,
                color = savedFileSelectionPanelBorderColor,
                shape = RoundedCornerShape(10.dp)
            )
            .background(Color(fileSelectionScreenColors.savedFileSelectionPanelBackgroundColor))
            .fillMaxWidth()
            .height(FileSelectionScreenDimensions().savedFileSelectionPanelHeight.dp)
            .padding( horizontal = FileSelectionScreenDimensions().savedFileSelectionPanelHorizontalPadding.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Saved File Selection Panel File Type Icon
        Icon(
            imageVector = fileTypeIcon,
            contentDescription = null,
            tint = Color(fileSelectionScreenColors.savedFilePanelFileTypeIconColor),
            modifier = Modifier
                .size(size = FileSelectionScreenDimensions().savedFileSelectionPanelFileTypeIconSize.dp)
                .weight(0.2f))

        // Saved File Selection Panel Text Box
        SavedFileSelectionPanelTextBox(
            modifier = Modifier
                .weight(1f),
            fileName = fileName,
            lastModified = lastModified
        )

        // Saved File Selection Panel Radio Button
        SavedFileSelectionPanelRadioButton(isFileSelected = isFileSelected)
    }}

