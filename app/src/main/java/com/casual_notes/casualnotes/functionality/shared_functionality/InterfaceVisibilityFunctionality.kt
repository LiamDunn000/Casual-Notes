package com.casual_notes.casualnotes.functionality.shared_functionality

import android.content.Context
import androidx.lifecycle.ViewModel
import com.casual_notes.casualnotes.data.modify_folder_dialog_data.modify_folder_dialog_states.modifyFolderDialogStates
import com.casual_notes.casualnotes.data.file_selection_screen_data.file_selection_screen_states.fileSelectionScreenStates
import com.casual_notes.casualnotes.data.shared_data.fileStates

// Global Instance of Dialog Visibility Functionality
val interfaceVisibilityFunctionality = InterfaceVisibilityFunctionality()

class InterfaceVisibilityFunctionality: ViewModel() {

    /* CREATE FILE BUTTON ------------------------------------------------------------------------*/

    // Toggle Create File Button State
    fun toggleCreateFileButtonState(context: Context) {

        // Vibrate On Button Click
        generalFunctionality.vibrateOnButtonClick(context = context)
        fileSelectionScreenStates.isCreateFileButtonPressed = !fileSelectionScreenStates.isCreateFileButtonPressed
        closeFileEditPanel()
    }
    //----------------------------------------------------------------------------------------------

    /* MODIFY FOLDER DIALOG ----------------------------------------------------------------------*/

    // Open Modify Folder Dialog
    fun openModifyFolderDialog(context: Context) {

        // Vibrate On Button Click
        generalFunctionality.vibrateOnButtonClick(context = context)
        modifyFolderDialogStates.isModifyFolderDialogVisible = true
    }

    // Close Modify Folder Dialog
    fun closeModifyFolderDialog(context: Context) {

        // Vibrate On Button Click
        generalFunctionality.vibrateOnButtonClick(context = context)

        modifyFolderDialogStates.isModifyFolderDialogVisible = false
        modifyFolderDialogStates.folderTitleTextFieldValue = ""
        modifyFolderDialogStates.isFolderBeingEdited = false
        fileSelectionScreenStates.isCreateFileButtonPressed = false
    }
    //----------------------------------------------------------------------------------------------

    /* DELETE FILE CONFIRMATION DIALOG -----------------------------------------------------------*/

    // Open Delete File Confirmation Dialog
    fun openDeleteFileConfirmationDialog(context: Context) {

        // Vibrate On Button Click
        generalFunctionality.vibrateOnButtonClick(context = context)
        fileSelectionScreenStates.isDeleteFileConfirmationDialogVisible = true
    }

    // Close Delete File Confirmation Dialog
    fun closeDeleteFileConfirmationDialog(context: Context) {

        // Vibrate On Button Click
        generalFunctionality.vibrateOnButtonClick(context = context)
        fileSelectionScreenStates.isDeleteFileConfirmationDialogVisible = false
    }
    //----------------------------------------------------------------------------------------------

    /* FILE EDIT PANEL ---------------------------------------------------------------------------*/

    // Open File Edit Panel
    fun openFileEditPanel() {
        fileSelectionScreenStates.isFileEditPanelOpenVisible = true
    }

    fun closeFileEditPanel() {
        fileSelectionScreenStates.isFileEditPanelOpenVisible = false
        fileStates.selectedFileList.clear()
    }
    //---------------------------------------------------------------------------------------------

    /* OPTIONS MENU ----------------------------------------------------------------------------*/

    // Open Options Menu
    fun openOptionsMenu(context: Context) {

        // Vibrate On Button Click
        generalFunctionality.vibrateOnButtonClick(context = context)

        fileSelectionScreenStates.isOptionsMenuVisible = true
    }

    // Close Options Menu
    fun closeOptionsMenu(context: Context) {

        // Vibrate On Button Click
        generalFunctionality.vibrateOnButtonClick(context = context)
        fileSelectionScreenStates.isOptionsMenuVisible = false
    }
    //---------------------------------------------------------------------------------------------
}