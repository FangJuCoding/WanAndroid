package com.funcoding.wanandroid.base.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.funcoding.wanandroid.base.widget.LoadingDialogFragment

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var loadingDialogFragment: LoadingDialogFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        initView(savedInstanceState)
        initData(savedInstanceState)
    }

    abstract fun getLayoutResId(): Int

    protected open fun initView(savedInstanceState: Bundle?) {

    }

    protected open fun initData(savedInstanceState: Bundle?) {

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