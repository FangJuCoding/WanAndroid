package com.funcoding.wanandroid.base.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.funcoding.wanandroid.base.ext.no

abstract class BaseVmFragment<VM : BaseViewModel> : BaseFragment() {
    protected lateinit var viewModel: VM
    private var lazyLoaded = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
        // 因为Fragment恢复后savedInstanceState不为null，
        // 重新恢复后会自动从ViewModel中的LiveData恢复数据，
        // 不需要重新初始化数据。
        if (savedInstanceState == null) {
            initData()
        }
    }

    protected open fun initView() {

    }

    protected open fun initViewModel() {
        viewModel = ViewModelProvider(this).get(getViewModelClazz())
    }

    abstract fun getViewModelClazz(): Class<VM>

    protected open fun initData() {

    }

    override fun onResume() {
        super.onResume()
        lazyLoaded.no {
            lazyData()
            lazyLoaded = false
        }
    }

    protected open fun lazyData() {

    }
}