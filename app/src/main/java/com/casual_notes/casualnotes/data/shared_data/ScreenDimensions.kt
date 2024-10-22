package com.casual_notes.casualnotes.data.shared_data

import android.content.res.Configuration

// Global Instance of Screen Properties
val screenDimensions: ScreenDimensions by lazy { ScreenDimensions.instance }

class ScreenDimensions(configuration: Configuration) {

    // Screen Width
    val screenWidth = configuration.screenWidthDp

    // Screen Height
    val screenHeight = configuration.screenHeightDp

    // Total Screen Size
    val screenSize = screenWidth + screenHeight

    // Internal Instance Of Screen Dimensions
    companion object {
        lateinit var instance: ScreenDimensions
    }

}