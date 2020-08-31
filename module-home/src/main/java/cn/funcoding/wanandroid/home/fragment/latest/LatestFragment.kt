package cn.funcoding.wanandroid.home.fragment.latest

import cn.funcoding.wanandroid.base.base.BaseFragment
import cn.funcoding.wanandroid.home.R

/**
 * 最新页面
 */
class LatestFragment : BaseFragment() {

    companion object{
        fun newInstance() = LatestFragment()
    }

    override fun getLayResId(): Int = R.layout.home_latest_fragment
}