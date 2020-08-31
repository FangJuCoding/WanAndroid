package cn.funcoding.wanandroid.home.activity

import com.alibaba.android.arouter.facade.annotation.Route
import cn.funcoding.wanandroid.base.base.BaseActivity
import cn.funcoding.wanandroid.base.router.RouterPath
import cn.funcoding.wanandroid.home.R

/**
 * 搜索界面
 */
@Route(path = RouterPath.PAGER_ACTIVITY_SEARCH)
class SearchActivity : BaseActivity() {
    override fun getLayoutResId(): Int = R.layout.home_search_activity
}