package cn.funcoding.wanandroid.home.fragment.wechat

import cn.funcoding.wanandroid.base.base.BaseFragment
import cn.funcoding.wanandroid.home.R

/**
 * 公众号页面
 */
class WeChatFragment : BaseFragment() {

    companion object {
        fun newInstance() = WeChatFragment()
    }

    override fun getLayResId(): Int = R.layout.home_wechat_fragment
}