package com.example.myshopapp.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.myshopapp.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.dialog_progress.*

open class BaseActivity : AppCompatActivity() {

    private  var doubleBackToExitPressedOnce=false

    private lateinit var mProgressDialog: Dialog

    fun showErrorSnackBar(message: String,errorMessage: Boolean)
    {
        val snackBar=Snackbar.make(findViewById(android.R.id.content), message,Snackbar.LENGTH_LONG)

        val snackBarView=snackBar.view

        if(errorMessage)
        {
            snackBarView.setBackgroundColor(ContextCompat.getColor(this,
                R.color.purple_200
            ))
        }
        else{
            snackBarView.setBackgroundColor(ContextCompat.getColor(this,
                R.color.teal_200
            ))
        }
        snackBar.show()
    }

    // TODO Step 5: Create a function to load and show the progress dialog.
    // START
    /**
     * This function is used to show the progress dialog with the title and message to user.
     */
    fun showProgressDialog(text: String) {
        mProgressDialog = Dialog(this)

        /*Set the screen content from a layout resource.
        The resource will be inflated, adding all top-level views to the screen.*/
        mProgressDialog.setContentView(R.layout.dialog_progress)

        mProgressDialog.tv_progress_text.text = text

        mProgressDialog.setCancelable(false)
        mProgressDialog.setCanceledOnTouchOutside(false)

        //Start the dialog and display it on screen.
        mProgressDialog.show()
    }
    // END

    // TODO Step 6: Create a function to hide progress dialog.
    // START
    /**
     * This function is used to dismiss the progress dialog if it is visible to user.
     */
    fun hideProgressDialog() {
        mProgressDialog.dismiss()
    }
    // END


    // TODO Step 7: Create a function to implement the double back press to exit the app.
    // START
    /**
     * A function to implement the double back press feature to exit the app.
     */
    fun doubleBackToExit() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true

        Toast.makeText(
            this,
            resources.getString(R.string.please_click_back_again_to_exit),
            Toast.LENGTH_SHORT
        ).show()

        @Suppress("DEPRECATION")
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
    // END
}