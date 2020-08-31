package cn.funcoding.wanandroid.home.fragment.popular

import cn.funcoding.wanandroid.base.base.BaseVmFragment
import cn.funcoding.wanandroid.home.R

/**
 * 热门页面
 */
class PopularFragment : BaseVmFragment<PopularViewModel>() {

    companion object {
        fun newInstance() = PopularFragment()
    }

    override fun getLayResId(): Int = R.layout.home_popular_fragment

    override fun getViewModelClazz(): Class<PopularViewModel> = PopularViewModel::class.java
}