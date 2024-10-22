package com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_colors

import androidx.lifecycle.ViewModel
import com.casual_notes.casualnotes.data.shared_data.colors

// Global Instance Of Move File Screen Colors
val moveFileScreenColors = MoveFileScreenColors()

class MoveFileScreenColors: ViewModel() {

    // Move File Screen Background Color
    val moveFileScreenBackgroundColor = colors.white

    // Move File Screen Top App Bar Colors
    val moveFileScreenTopAppBarBackgroundColor = colors.lightBlue
    val moveFileScreenTopAppBarButtonColor = colors.white

    // Folder Search Bar Colors
    val folderSearchBarBackgroundColor = colors.transparent
    val folderSearchBarTextColor = colors.white
    val folderSearchBarIconColor = colors.white
    val folderSearchBarIndicatorColor = colors.transparent

    // Files To Move List Colors
    val filesToMoveListBackgroundColor = colors.transparent
    val filesToMoveHeaderDecorativeLineColor = colors.darkGray
    val filesToMoveListHeaderTextColor = colors.darkGray
    val filesToMoveListFileNameTextColor = colors.lightBlue
    val filesToMoveListItemBackgroundColor = colors.darkWhite

    // Selected Destination Colors
    val selectedDestinationDisplayTextBackgroundColor = colors.transparent
    val selectedDestinationDisplayTextHeaderDecorativeLineColor = colors.darkGray
    val selectedDestinationDisplayTextHeaderTextColor = colors.darkGray
    val selectedDestinationDisplayTextColor = colors.lightBlue

    // Destination List Header Colors
    val destinationListHeaderBackgroundColor = colors.transparent
    val destinationListHeaderDecorativeLineColor = colors.darkGray
    val destinationListHeaderTextColor = colors.darkGray

    // Destination List Panel Colors
    val destinationListPanelButtonColor = colors.darkGray
    val destinationListPanelTextColor = colors.darkGray
    val destinationListPanelSelectedButtonColor = colors.lightBlue
    val destinationListPanelSelectedTextColor = colors.lightBlue
    val destinationListPanelDisabledButtonColor = colors.darkWhite
    val destinationListPanelDisabledTextColor = colors.darkWhite

    // Current Folder Display Colors
    val currentFolderDisplayBackgroundColor = colors.transparent
    val currentFolderDisplayTextColor = colors.darkGray
    val currentFolderDisplaySelectedTextColor = colors.lightBlue
    val currentFolderDisplayButtonColor = colors.darkGray
    val currentFolderDisplaySelectedButtonColor = colors.darkGray

    // Move File Button Colors
    val moveFileButtonBackgroundColor = colors.lightBlue
    val moveFileButtonIconColor = colors.white
}