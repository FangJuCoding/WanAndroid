package com.funcoding.wanandroid.base.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.funcoding.wanandroid.base.widget.LoadingDialogFragment

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var loadingDialogFragment: LoadingDialogFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        initViewBefore(savedInstanceState)
        initView(savedInstanceState)
        initViewAfter(savedInstanceState)
    }

    abstract fun getLayoutResId(): Int


    protected open fun initViewBefore(savedInstanceState: Bundle?) {

    }

    protected open fun initView(savedInstanceState: Bundle?) {

    }

    protected open fun initViewAfter(savedInstanceState: Bundle?) {

    }

    protected open fun showLoading() {
        if (!this::loadingDialogFragment.isInitialized) {
            loadingDialogFragment = LoadingDialogFragment.newInstance()
        }
        loadingDialogFragment.show(supportFragmentManager)
    }

    protected open fun hideLoading() {
        if (this::loadingDialogFragment.isInitialized && loadingDialogFragment.isVisible) {
            loadingDialogFragment.dismiss()
        }
    }
}