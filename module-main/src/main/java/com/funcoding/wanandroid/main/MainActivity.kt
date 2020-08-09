package com.funcoding.wanandroid.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.funcoding.wanandroid.base.base.BaseActivity
import com.funcoding.wanandroid.base.base.ScrollTop
import com.funcoding.wanandroid.base.ext.otherwise
import com.funcoding.wanandroid.base.ext.yes
import com.funcoding.wanandroid.base.router.RouterPath
import kotlinx.android.synthetic.main.main_activity.*

@Route(path = RouterPath.PAGER_ACTIVITY_MAIN)
class MainActivity : BaseActivity() {
    private lateinit var fragmentMap: Map<Int, Fragment>

    override fun getLayoutResId(): Int = R.layout.main_activity

    override fun initView(savedInstanceState: Bundle?) {
        fragmentMap = mapOf(
            R.id.home to createFragment(RouterPath.PAGER_FRAGMENT_HOME),
            R.id.system to createFragment(RouterPath.PAGER_FRAGMENT_SYSTEM),
            R.id.find to createFragment(RouterPath.PAGER_FRAGMENT_FIND),
            R.id.navigation to createFragment(RouterPath.PAGER_FRAGMENT_NAVIGATION),
            R.id.mine to createFragment(RouterPath.PAGER_FRAGMENT_MINE)
        )

        mainBottomNavView.run {
            setOnNavigationItemSelectedListener { menuItem ->
                showFragment(menuItem.itemId)
                true
            }
            setOnNavigationItemReselectedListener { menuItem ->
                val fragment = fragmentMap.entries.find { it.key == menuItem.itemId }?.value
                if (fragment is ScrollTop) {
                    fragment.scrollTop()
                }
            }
        }

        if (null == savedInstanceState) {
            val initialMenuItemId = R.id.home
            mainBottomNavView.selectedItemId = initialMenuItemId
            showFragment(initialMenuItemId)
        }
    }

    private fun createFragment(routePath: String): Fragment =
        ARouter.getInstance().build(routePath).navigation() as Fragment

    private fun showFragment(menuItemId: Int) {
        val currentFragment = supportFragmentManager.fragments.find { fragment ->
            fragment.isVisible && fragment in fragmentMap.values
        }
        val targetFragment = fragmentMap.entries.find { it.key == menuItemId }?.value
        supportFragmentManager.beginTransaction().apply {
            currentFragment?.let {
                it.isVisible.yes {
                    hide(it)
                }
            }
            targetFragment?.let {
                it.isAdded.yes {
                    show(it)
                }.otherwise {
                    add(R.id.mainContainer, it)
                }
            }
        }.commit()
    }
}
