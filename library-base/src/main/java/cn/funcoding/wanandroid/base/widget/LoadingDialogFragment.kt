package cn.funcoding.wanandroid.base.widget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import cn.funcoding.wanandroid.base.R

class LoadingDialogFragment : DialogFragment() {
    companion object {
        fun newInstance() = LoadingDialogFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.base_loading_dialog, container, false)
    }

    fun show(fragmentManager: FragmentManager, isCancelable: Boolean = false) {
        setCancelable(isCancelable)
        show(fragmentManager, this.javaClass.simpleName)
    }
}