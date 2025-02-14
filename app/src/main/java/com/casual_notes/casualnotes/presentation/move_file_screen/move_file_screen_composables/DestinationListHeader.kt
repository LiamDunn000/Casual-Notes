package com.casual_notes.casualnotes.presentation.move_file_screen.move_file_screen_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casual_notes.casualnotes.R
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_colors.moveFileScreenColors
import com.casual_notes.casualnotes.data.move_file_screen_data.move_file_screen_dimensions.MoveFileScreenDimensions

@Composable
fun DestinationListHeader() {

    // Destination List Header Layout
    Row(
        modifier = Modifier
            .fillMaxWidth()
        .background(color = Color(moveFileScreenColors.destinationListHeaderBackgroundColor)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Destination List Header Decorative Line
        Box(
            modifier = Modifier
                .background(color = Color(moveFileScreenColors.destinationListHeaderDecorativeLineColor))
                .height(height = MoveFileScreenDimensions().destinationListHeaderDecorativeLineHeight.dp)
                .weight(weight = MoveFileScreenDimensions().destinationListHeaderDecorativeLineWeight)
        )

        // Destination List Header Text
        Text(
            text = "Select A Destination",
            color = Color(moveFileScreenColors.destinationListHeaderTextColor),
            fontSize = MoveFileScreenDimensions().destinationListHeaderFontSize.sp,
            fontFamily = FontFamily(Font(R.font.alegreya_sans_medium)),
            modifier = Modifier.padding(MoveFileScreenDimensions().destinationListHeaderTextPadding.dp)
        )

        // Destination List Header Decorative Line
        Box(
            modifier = Modifier
                .background(color = Color(moveFileScreenColors.destinationListHeaderDecorativeLineColor))
                .height(height = MoveFileScreenDimensions().destinationListHeaderDecorativeLineHeight.dp)
                .weight(weight = MoveFileScreenDimensions().destinationListHeaderDecorativeLineWeight)
        )
    }
}