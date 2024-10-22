package com.casual_notes.casualnotes.data.options_menu_data.option_menu_colors

import androidx.lifecycle.ViewModel
import com.casual_notes.casualnotes.data.shared_data.colors

// Global Instance of Options Menu Colors
val optionsMenuColors = OptionsMenuColors()

class OptionsMenuColors: ViewModel() {

    // Options Menu Divider Color
    val optionsMenuDividerColor = colors.darkGray

    // Vibration Level Panel Colors
    val vibrationLevelPanelHeaderTextColor = colors.darkGray
    val vibrationLevelUnselectedButtonTextColor = colors.darkGray
    val vibrationLevelSelectedButtonTextColor = colors.lightBlue
    val vibrationLevelUnselectedButtonBorderColor = colors.darkGray
    val vibrationLevelSelectedButtonBorderColor = colors.lightBlue
    val vibrationLevelUnselectedButtonIndicatorColor = colors.transparent
    val vibrationLevelSelectedButtonIndicatorColor = colors.lightBlue

    // Show Toasts Panel Colors
    val showToastPanelHeaderTextColor = colors.darkGray
    val showToastPanelUnselectedButtonBorderColor = colors.darkGray
    val showToastPanelSelectedButtonBorderColor = colors.lightBlue
    val showToastPanelUnselectedButtonIndicatorColor = colors.darkGray
    val showToastPanelSelectedButtonIndicatorColor = colors.lightBlue
}