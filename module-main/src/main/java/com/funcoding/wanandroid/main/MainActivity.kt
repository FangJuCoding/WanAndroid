package com.funcoding.wanandroid.main

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.funcoding.wanandroid.base.base.BaseActivity
import com.funcoding.wanandroid.base.router.RouterPath

@Route(path = RouterPath.PAGER_ACTIVITY_MAIN)
class MainActivity : BaseActivity() {
    private lateinit var fragments: List<Fragment>

    override fun getLayoutResId(): Int = R.layout.main_activity

    override fun initView() {
        // 初始化Fragment
        initFragment()
        // 初始化BottomNav
        initBottomBav()
    }

    private fun initFragment() {
        val homeFragment: Fragment =
            ARouter.getInstance().build(RouterPath.PAGER_FRAGMENT_HOME).navigation() as Fragment
        val systemFragment: Fragment =
            ARouter.getInstance().build(RouterPath.PAGER_FRAGMENT_SYSTEM).navigation() as Fragment
        val findFragment: Fragment =
            ARouter.getInstance().build(RouterPath.PAGER_FRAGMENT_FIND).navigation() as Fragment
        val navFragment: Fragment =
            ARouter.getInstance().build(RouterPath.PAGER_FRAGMENT_NAVIGATION).navigation() as Fragment
        val mineFragment: Fragment =
            ARouter.getInstance().build(RouterPath.PAGER_FRAGMENT_MINE).navigation() as Fragment

        fragments = listOf(homeFragment, systemFragment, findFragment, navFragment, mineFragment)

        supportFragmentManager.beginTransaction()
            .add(R.id.mainContainer, homeFragment)
            .commitAllowingStateLoss()
    }

    private fun initBottomBav() {

    }
}
