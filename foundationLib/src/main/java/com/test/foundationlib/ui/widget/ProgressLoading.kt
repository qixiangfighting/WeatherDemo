package com.test.foundationlib.ui.widget

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.widget.ImageView
import com.test.foundationlib.R
//import org.jetbrains.anko.find

/**
 * Customized Dialog
 *
 */
class ProgressLoading private constructor(context: Context, theme: Int) : Dialog(context, theme) {

    companion object {
        private lateinit var mDialog: ProgressLoading
        private lateinit var animDrawable: AnimationDrawable

        fun create(context: Context):ProgressLoading {
            mDialog = ProgressLoading(context, R.style.LightProgressDialog)
            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCancelable(true)
            mDialog.setCanceledOnTouchOutside(false)
            mDialog.window?.attributes?.gravity = Gravity.CENTER

            val lp = mDialog.window?.attributes
            lp?.dimAmount = 0.2f
            mDialog.window?.attributes = lp

            val loadingView = mDialog.findViewById<ImageView>(R.id.iv_loading)
            animDrawable = loadingView.background as AnimationDrawable

            return mDialog
        }
    }

    fun showLoading() {
        super.show()
        animDrawable.start()
    }

    fun hideLoading(){
        super.dismiss()
        animDrawable.stop()
    }
}
