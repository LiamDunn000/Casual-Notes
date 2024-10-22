package com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_dimensions

import com.casual_notes.casualnotes.data.shared_data.screenDimensions

class FileSelectionScreenDimensions {

    // File Selection Screen Top App Bar Dimensions
    val fileSelectionScreenTopAppBarHeight = screenDimensions.screenSize * 0.07f
    val fileSelectionScreenTopAppBarTopPadding = screenDimensions.screenSize * 0.02
    val fileSelectionScreenTopAppBarHorizontalPadding = screenDimensions.screenSize * 0.012

    // File Search Bar Dimensions
    val fileSearchBarWeight = 0.22f
    val fileSearchBarFontSize = screenDimensions.screenSize * 0.020
    val fileSearchBarIconSize = fileSearchBarFontSize

    // File Selection Screen Top App Bar Options Button Dimensions
    val fileSelectionScreenTopAppBarButtonSize = screenDimensions.screenSize * 0.022
    val fileSelectionScreenTopAppBarButtonWeight = 0.032f

    // Create File Button Dimensions
    val createFileButtonSize = screenDimensions.screenSize * 0.062
    val fileTypeSelectionButtonSize = createFileButtonSize * 0.45
    val fileSelectionButtonPanelVerticalSpacing = createFileButtonSize * 0.20

    // Saved File Selection List Dimensions
    val savedFileSelectionListPadding = screenDimensions.screenSize * 0.01
    val savedFileSelectionListSpacing = screenDimensions.screenSize * 0.01

    // Saved File Selection Panel Dimensions
    val savedFileSelectionPanelHeight = screenDimensions.screenSize * 0.07
    val savedFileSelectionPanelBorderWidth = screenDimensions.screenSize * 0.001
    val savedFileSelectionPanelFileTypeIconSize = screenDimensions.screenSize * 0.06
    val savedFileSelectionPanelFileNameFontSize = screenDimensions.screenSize * 0.020
    val savedFileSelectionPanelFileLastModifiedFontSize = screenDimensions.screenSize * 0.015
    val savedFileSelectionPanelRadioButtonSize = screenDimensions.screenSize * 0.022
    val savedFileSelectionPanelRadioButtonContainerWidth = screenDimensions.screenSize * 0.022
    val savedFileSelectionPanelRadioButtonTopPadding = screenDimensions.screenSize * 0.01
    val savedFileSelectionPanelHorizontalPadding = screenDimensions.screenWidth * 0.02

    // File Edit Panel Dimensions
    val fileEditPanelHeight = screenDimensions.screenSize * 0.050
    val editFileBoxButtonIconSize = screenDimensions.screenSize * 0.020
    val editFileBoxButtonFontSize = screenDimensions.screenSize * 0.013


}