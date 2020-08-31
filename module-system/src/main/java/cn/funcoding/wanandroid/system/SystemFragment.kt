package cn.funcoding.wanandroid.system

import com.alibaba.android.arouter.facade.annotation.Route
import cn.funcoding.wanandroid.base.base.BaseFragment
import cn.funcoding.wanandroid.base.router.RouterPath

/**
 * 体系页面
 */
@Route(path = RouterPath.PAGER_FRAGMENT_SYSTEM)
class SystemFragment:BaseFragment() {
    override fun getLayResId(): Int = R.layout.system_fragment
}