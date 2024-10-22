package com.casual_notes.casualnotes.functionality.shared_functionality

import android.app.Application
import com.casual_notes.casualnotes.data.shared_data.DefaultDirectories
import com.casual_notes.casualnotes.data.shared_data.ScreenDimensions
import com.casual_notes.casualnotes.data.shared_data.defaultDirectories

class CasualNotesApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        ScreenDimensions.instance = ScreenDimensions(this.resources.configuration)

        DefaultDirectories.instance = DefaultDirectories(context = this@CasualNotesApplication)
        defaultDirectories.homeDirectory

    }
}