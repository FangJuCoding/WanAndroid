package cn.funcoding.wanandroid.nav

import com.alibaba.android.arouter.facade.annotation.Route
import cn.funcoding.wanandroid.base.base.BaseFragment
import cn.funcoding.wanandroid.base.router.RouterPath

/**
 * 导航页面
 */
@Route(path = RouterPath.PAGER_FRAGMENT_NAVIGATION)
class NavFragment : BaseFragment() {
    override fun getLayResId(): Int = R.layout.nav_fragment
}