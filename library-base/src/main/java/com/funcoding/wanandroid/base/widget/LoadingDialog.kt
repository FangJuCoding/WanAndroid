package com.funcoding.wanandroid.base.widget

import android.app.Dialog
import android.content.Context
import androidx.annotation.NonNull
import com.funcoding.wanandroid.base.R
import kotlinx.android.synthetic.main.base_loading_dialog.*

class LoadingDialog(context: Context) : Dialog(context) {

    init {
        setContentView(R.layout.base_loading_dialog)
//        setCancelable(false)
//        setCanceledOnTouchOutside(false)
    }

    companion object {
        private var loadingDialog: LoadingDialog? = null

        fun show(@NonNull context: Context) {
            if (loadingDialog == null) {
                loadingDialog = LoadingDialog(context)
            }
            loadingDialog!!.show()
        }

        fun show(@NonNull context: Context, tip: String) {
            if (loadingDialog == null) {
                loadingDialog = LoadingDialog(context)
                loadingDialog!!.loading_tip_tv.text = tip
            }
            loadingDialog!!.show()
        }

        fun dismiss() {
            if (loadingDialog != null && loadingDialog!!.isShowing) {
                loadingDialog!!.dismiss()
            }
        }
    }
}