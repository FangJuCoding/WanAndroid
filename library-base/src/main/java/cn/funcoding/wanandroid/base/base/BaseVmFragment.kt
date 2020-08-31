package cn.funcoding.wanandroid.base.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

abstract class BaseVmFragment<VM : BaseViewModel> : BaseFragment() {
    protected lateinit var viewModel: VM

    override fun initViewBefore(savedInstanceState: Bundle?) {
        super.initViewBefore(savedInstanceState)
        viewModel = ViewModelProvider(this).get(getViewModelClazz())
    }

    abstract fun getViewModelClazz(): Class<VM>
}