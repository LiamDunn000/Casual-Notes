package com.casual_notes.casualnotes.presentation.delete_file_confirmation_dialog.delete_file_confirmation_dialog_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casual_notes.casualnotes.R
import com.casual_notes.casualnotes.data.delete_file_confirmation_dialog_data.delete_file_confirmation_dialog_colors.deleteFileConfirmationDialogColors
import com.casual_notes.casualnotes.data.delete_file_confirmation_dialog_data.delete_file_confirmation_dialog_dimensions.DeleteFileConfirmationDialogDimensions
import com.casual_notes.casualnotes.data.shared_data.fileStates
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun FilesSelectedForDeletionList() {

    // Files Selected For Deletion List Layout
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            DeleteFileConfirmationDialogDimensions().filesSelectedForDeletionListItemSpacing.dp
        )
    ){
        items(fileStates.selectedFileList) { file ->

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

            // Files Selected For Deletion List Panel
            FilesSelectedForDeletionListPanel(
                fileName = file.name,
                fileLastModifiedTimestamp = fileLastModifiedTimestamp
            )

        }
    }
}