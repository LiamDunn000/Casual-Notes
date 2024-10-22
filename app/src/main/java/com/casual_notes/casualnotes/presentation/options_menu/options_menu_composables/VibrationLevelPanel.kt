package com.casual_notes.casualnotes.presentation.options_menu.options_menu_composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casual_notes.casualnotes.data.options_menu_data.option_menu_colors.optionsMenuColors
import com.casual_notes.casualnotes.data.options_menu_data.options_menu_dimensions.OptionsMenuDimensions
import com.casual_notes.casualnotes.data.shared_data.UserPreferencesDatastore

@Composable
fun VibrationLevelPanel(datastore: UserPreferencesDatastore) {

    // Vibration Level Panel Layout
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Vibration Level Panel Header
        Text(
            text = "Vibration Level",
            color = Color(optionsMenuColors.vibrationLevelPanelHeaderTextColor),
            fontSize = OptionsMenuDimensions().vibrationLevelPanelHeaderFontSize.sp
        )

        // Vibration Level Button Panel
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            // Vibration Level Off Button
            VibrationLevelButton(
                datastore = datastore,
                text = " Off ")

            // Vibration Level Low Button
            VibrationLevelButton(
                datastore = datastore,
                text = " Low ")

            // Vibration Level High Button
            VibrationLevelButton(
                datastore = datastore,
                text = "High")

        }
    }
}