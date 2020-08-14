package com.funcoding.wanandroid.home.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.base.BaseFragment
import com.funcoding.wanandroid.base.base.ScrollToTop
import com.funcoding.wanandroid.base.router.ARouterHelper
import com.funcoding.wanandroid.base.router.RouterPath
import com.funcoding.wanandroid.home.R
import com.funcoding.wanandroid.home.fragment.latest.LatestFragment
import com.funcoding.wanandroid.home.fragment.popular.PopularFragment
import com.funcoding.wanandroid.home.fragment.project.ProjectFragment
import com.funcoding.wanandroid.home.fragment.square.SquareFragment
import com.funcoding.wanandroid.home.fragment.wechat.WeChatFragment
import kotlinx.android.synthetic.main.home_fragment.*

/**
 * 首页
 */
@Route(path = RouterPath.PAGER_FRAGMENT_HOME)
class HomeFragment : BaseFragment(), ScrollToTop {
    private lateinit var fragmentList: List<Fragment>

    override fun getLayResId(): Int =
        R.layout.home_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentList = listOf(
            PopularFragment.newInstance(),
            LatestFragment.newInstance(),
            SquareFragment.newInstance(),
            ProjectFragment.newInstance(),
            WeChatFragment.newInstance()
        )

        val titles = listOf(
            getString(R.string.home_label_popular),
            getString(R.string.home_label_latest),
            getString(R.string.home_label_square),
            getString(R.string.home_label_project),
            getString(R.string.home_label_wechat)
        )

        homeViewPager.adapter =
            SimpleFragmentPagerAdapter(
                childFragmentManager,
                fragmentList,
                titles
            )
        homeViewPager.offscreenPageLimit = fragmentList.size
        homeTabLayout.setupWithViewPager(homeViewPager)

        homeSearchLay.setOnClickListener {
            ARouterHelper.greenChannelNavigation(RouterPath.PAGER_ACTIVITY_SEARCH)
        }
    }

    override fun scrollToTop() {
        if (!this::fragmentList.isInitialized) return
        val currentFragment = fragmentList[homeViewPager.currentItem]
        if (currentFragment is ScrollToTop && currentFragment.isVisible) {
            currentFragment.scrollToTop()
        }
    }
}