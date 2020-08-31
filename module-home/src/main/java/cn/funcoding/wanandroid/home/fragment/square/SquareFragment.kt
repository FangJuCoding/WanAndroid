package cn.funcoding.wanandroid.home.fragment.square

import cn.funcoding.wanandroid.base.base.BaseFragment
import cn.funcoding.wanandroid.home.R

/**
 * 广场页面
 */
class SquareFragment : BaseFragment() {

    companion object{
        fun newInstance() = SquareFragment()
    }

    override fun getLayResId(): Int = R.layout.home_square_fragment
}