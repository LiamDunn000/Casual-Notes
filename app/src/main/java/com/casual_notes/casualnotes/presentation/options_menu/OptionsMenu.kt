package com.casual_notes.casualnotes.presentation.options_menu

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_states.fileSelectionScreenStates
import com.casual_notes.casualnotes.data.options_menu_data.option_menu_colors.optionsMenuColors
import com.casual_notes.casualnotes.data.options_menu_data.options_menu_dimensions.OptionsMenuDimensions
import com.casual_notes.casualnotes.data.shared_data.UserPreferencesDatastore
import com.casual_notes.casualnotes.data.shared_data.userPreferencesStates
import com.casual_notes.casualnotes.functionality.shared_functionality.interfaceVisibilityFunctionality
import com.casual_notes.casualnotes.functionality.shared_functionality.userPreferenceFunctionality
import com.casual_notes.casualnotes.presentation.options_menu.options_menu_composables.ShowToastPanel
import com.casual_notes.casualnotes.presentation.options_menu.options_menu_composables.VibrationLevelPanel

@Composable
fun OptionsMenu(context: Context) {

    // User Preferences Datastore
    val userPreferencesDatastore = UserPreferencesDatastore(context = context)

    // Saved Vibration Level
    val savedVibrationLevel = userPreferencesDatastore.loadVibrationLevel(key = userPreferencesDatastore.vibrationLevelKey).collectAsState(initial = userPreferencesStates.selectedVibrationLevel).value

    // Saved Toast Preference
    val savedToastPreference = userPreferencesDatastore.loadShowToasts(key = userPreferencesDatastore.showToastsKey).collectAsState(initial = userPreferencesStates.showToasts).value

    // Load Vibration Level
    userPreferenceFunctionality.loadVibrationLevel(vibrationLevel = savedVibrationLevel)

    // Load Show Toasts
    userPreferenceFunctionality.loadShowToasts(showToasts = savedToastPreference)

    Box {
        DropdownMenu(
            expanded = fileSelectionScreenStates.isOptionsMenuVisible,
            onDismissRequest = { interfaceVisibilityFunctionality.closeOptionsMenu(
                context = context
            ) },
        ) {

            Column(
                modifier = Modifier
                    .width(width = OptionsMenuDimensions().optionsMenuWidth.dp)
                    .height(height = OptionsMenuDimensions().optionsMenuHeight.dp)
                    .padding(
                        horizontal = OptionsMenuDimensions().optionsMenuHorizontalPadding.dp,
                        vertical = OptionsMenuDimensions().optionsMenuVerticalPadding.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(OptionsMenuDimensions().optionsMenuVerticalSpacing.dp)

            ) {

                // Vibration Level Panel
                VibrationLevelPanel(
                    datastore = userPreferencesDatastore
                )

                // Options Menu Divider
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(optionsMenuColors.optionsMenuDividerColor),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .fillMaxWidth()
                        .height(height = OptionsMenuDimensions().optionsMenuDividerHeight.dp)
                )

                // Show Toasts Panel
                ShowToastPanel(
                    datastore = userPreferencesDatastore
                )
            }

        }
    }
}