package com.casual_notes.casualnotes.presentation.options_menu.options_menu_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casual_notes.casualnotes.data.options_menu_data.option_menu_colors.optionsMenuColors
import com.casual_notes.casualnotes.data.options_menu_data.options_menu_dimensions.OptionsMenuDimensions
import com.casual_notes.casualnotes.data.shared_data.UserPreferencesDatastore
import com.casual_notes.casualnotes.data.shared_data.userPreferencesStates
import com.casual_notes.casualnotes.functionality.shared_functionality.userPreferenceFunctionality

@Composable
fun VibrationLevelButton(
    datastore: UserPreferencesDatastore,
    text: String
    ) {

    // Vibration Level Button Text Color
    val vibrationLevelButtonTextColor = when {
        text == userPreferencesStates.selectedVibrationLevel -> Color(optionsMenuColors.vibrationLevelSelectedButtonTextColor)
        else -> Color(optionsMenuColors.vibrationLevelUnselectedButtonTextColor)
    }

    // Vibration Level Button Border Color
    val vibrationLevelButtonBorderColor = when {
        text == userPreferencesStates.selectedVibrationLevel -> Color(optionsMenuColors.vibrationLevelSelectedButtonBorderColor)
        else -> Color(optionsMenuColors.vibrationLevelUnselectedButtonBorderColor)
    }

    // Vibration Level Button Indicator Color
    val vibrationLevelButtonIndicatorColor = when {
        text == userPreferencesStates.selectedVibrationLevel -> Color(optionsMenuColors.vibrationLevelSelectedButtonIndicatorColor)
        else -> Color(optionsMenuColors.vibrationLevelUnselectedButtonIndicatorColor)
    }

    // Vibration Level Button Layout
    Column(
        modifier = Modifier
            .selectable(
                selected = text == userPreferencesStates.selectedVibrationLevel,
                onClick = {
                    userPreferencesStates.selectedVibrationLevel = text
                    userPreferenceFunctionality.saveVibrationLevel(
                        datastore = datastore
                    )
                }
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(OptionsMenuDimensions().vibrationLevelButtonVerticalSpacing.dp)
    ) {
        Text(
            text = text,
            color = vibrationLevelButtonBorderColor,
            fontSize = OptionsMenuDimensions().vibrationLevelButtonTextFontSize.sp)
        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .border(
                    color = vibrationLevelButtonTextColor,
                    width = OptionsMenuDimensions().vibrationLevelButtonBorderWidth.dp,
                    shape = CircleShape
                )
                .size(OptionsMenuDimensions().vibrationLevelButtonSize.dp),
            contentAlignment = Alignment.Center
        ){

            Box(
                modifier = Modifier
                    .background(
                        color = vibrationLevelButtonIndicatorColor,
                        shape = CircleShape
                    )
                    .fillMaxSize(0.5f),
            )

        }
    }
}