package com.casual_notes.casualnotes.presentation.options_menu.options_menu_composables

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun ShowToastPanel(
    datastore: UserPreferencesDatastore
) {

    // Show Toasts Panel Button Text Color
    val showToastPanelButtonBorderColor = when {
        !userPreferencesStates.showToasts -> Color(optionsMenuColors.showToastPanelUnselectedButtonBorderColor)
        else -> Color(optionsMenuColors.showToastPanelSelectedButtonBorderColor)
    }

    // Show Toasts Panel Button Indicator Color
    val showToastPanelButtonIndicatorColor = when {
        !userPreferencesStates.showToasts -> Color(optionsMenuColors.showToastPanelUnselectedButtonIndicatorColor)
        else -> Color(optionsMenuColors.showToastPanelSelectedButtonIndicatorColor)
    }

    // Show Toasts Panel Layout
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(OptionsMenuDimensions().showToastPanelVerticalSpacing.dp)
    ) {

        // Show Toasts Panel Header
        Text(
            text = "Show Toasts",
            color = Color(optionsMenuColors.showToastPanelHeaderTextColor),
            fontSize = OptionsMenuDimensions().showToastPanelHeaderFontSize.sp
        )

        // Show Toasts Panel Button
        Box(
            modifier = Modifier
                .clickable {
                    userPreferencesStates.showToasts = !userPreferencesStates.showToasts
                    userPreferenceFunctionality.saveShowToasts(
                        datastore = datastore
                    )}
                .clip(shape = RoundedCornerShape(20.dp))
                .border(
                    width = OptionsMenuDimensions().showToastPanelButtonBorderWidth.dp,
                    color = showToastPanelButtonBorderColor,
                    shape = RoundedCornerShape(20.dp)
                )
                .width(OptionsMenuDimensions().showToastPanelButtonWidth.dp)
                .height(OptionsMenuDimensions().showToastPanelButtonHeight.dp)
                .padding(OptionsMenuDimensions().showToastPanelButtonPadding.dp),
        ){

            // Show Toasts Panel Button Indicator
            Box(
                modifier = Modifier
                    .offset(x = animateDpAsState( targetValue =
                    when { userPreferencesStates.showToasts ->
                        OptionsMenuDimensions().showToastPanelButtonWidth.dp * 0.4f else -> 0.dp}).value)
                    .background(
                        color = showToastPanelButtonIndicatorColor,
                        shape = CircleShape
                    )
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
            )

        }
    }
}