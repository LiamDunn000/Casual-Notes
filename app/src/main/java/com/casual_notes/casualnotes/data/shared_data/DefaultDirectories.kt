package com.casual_notes.casualnotes.data.shared_data

import android.content.Context
import java.io.File

class DefaultDirectories(context: Context) {

    var homeDirectory = File(context.filesDir, "Home")

    companion object {
        lateinit var instance: DefaultDirectories
    }
}

val defaultDirectories: DefaultDirectories by lazy { DefaultDirectories.instance }