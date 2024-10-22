package com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_colors

import androidx.compose.ui.graphics.Color
import com.casual_notes.casualnotes.data.shared_data.colors

// Global Instance of Time Selection Screen Colors
val fileSelectionScreenColors = FileSelectionScreenColors()

class FileSelectionScreenColors {

    // File Selection Screen Top App Bar Background Color
    val fileSelectionScreenTopAppBarBackgroundColor = colors.lightBlue

    // File Selection Search Bar Colors
    val searchBarBackgroundColor = Color.Transparent
    val searchBarTextColor = colors.white
    val searchBarIconColor = colors.white

    // File Selection Screen Button Colors
    val fileSelectionScreenOptionsButtonBackgroundColor = colors.white
    val createNoteButtonBackgroundColor = colors.lightBlue
    val createNoteButtonIconColor = colors.white
    val fileTypeSelectionButtonTextColor = colors.darkGray

    // Saved File Panel Decorative Colors
    val savedFileSelectionPanelBackgroundColor = colors.white
    val savedFileSelectionPanelSelectedBorderColor = colors.lightBlue
    val savedFileSelectionPanelUnselectedBorderColor = colors.lightGray
    val savedFilePanelFileTypeIconColor = colors.lightBlue

    // Saved File Selection Panel Text Colors
    val savedFilePanelFileNameTextColor = colors.lightBlue
    val savedFilePanelFileLastModifiedTextColor = colors.lightGray

    // Saved File Selection Panel Radio Button Colors
    val savedFileSelectionPanelRadioButtonContainerBackgroundColor = colors.transparent
    val savedFileSelectionPanelRadioButtonBackgroundColor = colors.transparent
    val savedFileSelectionPanelRadioButtonBorderColor = colors.lightGray
    val savedFileSelectionPanelRadioButtonSelectedIndicatorColor = colors.lightBlue
    val savedFileSelectionPanelRadioButtonUnselectedIndicatorColor = colors.transparent

    // File Edit Panel Colors
    val fileEditPanelBackgroundColor = colors.white
    val fileEditPanelEnabledButtonIconColor = colors.darkGray
    val fileEditPanelDisabledButtonIconColor = colors.lightGray
    val fileEditPanelEnabledButtonTextColor = colors.darkGray
    val fileEditPanelDisabledButtonTextColor = colors.lightGray

}