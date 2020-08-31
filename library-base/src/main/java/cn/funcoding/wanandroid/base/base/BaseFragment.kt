package cn.funcoding.wanandroid.base.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayResId(), container, false)
    }

    abstract fun getLayResId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewBefore(savedInstanceState)
        initView(savedInstanceState)
        initViewAfter(savedInstanceState)
    }

    protected open fun initViewBefore(savedInstanceState: Bundle?) {

    }

    protected open fun initView(savedInstanceState: Bundle?) {

    }

    protected open fun initViewAfter(savedInstanceState: Bundle?) {

    }
}