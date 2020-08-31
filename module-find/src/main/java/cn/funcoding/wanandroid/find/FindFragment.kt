package cn.funcoding.wanandroid.find

import com.alibaba.android.arouter.facade.annotation.Route
import cn.funcoding.wanandroid.base.base.BaseFragment
import cn.funcoding.wanandroid.base.router.RouterPath
import cn.funcoding.wanandroid.find.R

/**
 * 发现页
 */
@Route(path = RouterPath.PAGER_FRAGMENT_FIND)
class FindFragment : BaseFragment() {
    override fun getLayResId(): Int = R.layout.find_fragment
}