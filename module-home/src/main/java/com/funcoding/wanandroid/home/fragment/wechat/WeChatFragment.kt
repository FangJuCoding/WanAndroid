package com.funcoding.wanandroid.home.fragment.wechat

import com.funcoding.wanandroid.base.base.BaseFragment
import com.funcoding.wanandroid.home.R

/**
 * 公众号页面
 */
class WeChatFragment : BaseFragment() {

    companion object {
        fun newInstance() = WeChatFragment()
    }

    override fun getLayResId(): Int = R.layout.home_wechat_fragment
}