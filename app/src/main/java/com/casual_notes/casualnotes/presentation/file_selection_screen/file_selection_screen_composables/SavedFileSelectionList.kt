package com.casual_notes.casualnotes.presentation.file_selection_screen.file_selection_screen_composables

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_dimensions.FileSelectionScreenDimensions
import com.casual_notes.casualnotes.data.shared_data.fileStates
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun SavedFileSelectionList(
    context: Context,
    navController: NavController) {

    // Saved File Selection List Layout
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(FileSelectionScreenDimensions().savedFileSelectionListSpacing.dp)
    ) {
        items(fileStates.currentFileList, key = { file -> file.name }) { file ->

            // Format Last Modified Logic
            val lastModified = file.lastModified()
            val instant = Instant.ofEpochMilli(lastModified)
            val date = instant.atZone(ZoneId.systemDefault()).toLocalDateTime()
            val formattedDate = date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"))
            val formattedTime = date.format(DateTimeFormatter.ofPattern("hh:mm a"))

            // Conditionally Determine If Date Or Time Is Shown
            val fileLastModifiedTimestamp = when {
                date.dayOfYear == LocalDateTime.now().dayOfYear
                && date.year == LocalDateTime.now().year -> {
                formattedTime.toString()
            } else -> {
                formattedDate.toString()
            }}

            // Saved File Selection Panel
            when { file.name != "!n#o)$" -> {
                SavedFileSelectionPanel(
                    context = context,
                    navController = navController,
                    file = file,
                    fileName = file.name,
                    lastModified = fileLastModifiedTimestamp
                )
            }
            }
        }
    }
}