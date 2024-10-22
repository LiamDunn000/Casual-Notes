package com.casual_notes.casualnotes.presentation.file_selection_screen.file_selection_screen_composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_colors.fileSelectionScreenColors
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_dimensions.FileSelectionScreenDimensions

@Composable
fun SavedFileSelectionPanelTextBox(
    modifier: Modifier,
    fileName: String,
    lastModified: String
) {

    // Saved File Selection Panel Text Box Layout
    Column(
        modifier = modifier
            //.fillMaxSize()
            .padding(
                horizontal = FileSelectionScreenDimensions().savedFileSelectionPanelHorizontalPadding.dp,
            ),
        verticalArrangement = Arrangement.Center
    ) {

        // Saved File Selection Panel File Name Display Text
        Text(
            text = fileName,
            color = Color(fileSelectionScreenColors.savedFilePanelFileNameTextColor),
            fontSize = FileSelectionScreenDimensions().savedFileSelectionPanelFileNameFontSize.sp,
            fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        // Saved File Selection Panel File Last Modified Display Text
        Text(
            text = lastModified,
            color = Color(fileSelectionScreenColors.savedFilePanelFileLastModifiedTextColor),
            fontSize = FileSelectionScreenDimensions().savedFileSelectionPanelFileLastModifiedFontSize.sp,
            fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}