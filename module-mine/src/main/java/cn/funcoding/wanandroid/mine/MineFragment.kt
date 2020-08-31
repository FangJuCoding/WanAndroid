package cn.funcoding.wanandroid.mine

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import cn.funcoding.wanandroid.base.base.BaseVmFragment
import cn.funcoding.wanandroid.base.ext.no
import cn.funcoding.wanandroid.base.ext.otherwise
import cn.funcoding.wanandroid.base.ext.shortToast
import cn.funcoding.wanandroid.base.ext.yes
import cn.funcoding.wanandroid.base.router.ARouterHelper
import cn.funcoding.wanandroid.base.router.RouterPath
import cn.funcoding.wanandroid.base.router.service.account.AccountServiceImplGlobal
import kotlinx.android.synthetic.main.mine_fragment.*

/**
 * 我的页面
 */
@Route(path = RouterPath.PAGER_FRAGMENT_MINE)
class MineFragment : BaseVmFragment<MineViewModel>() {
    override fun getLayResId(): Int = R.layout.mine_fragment

    override fun getViewModelClazz(): Class<MineViewModel> = MineViewModel::class.java

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        viewModel.apply {
            userInfo.observe(this@MineFragment, Observer { user ->
                (user == null).yes {
                    mineNickname.text = getString(R.string.mine_login_or_register)
                    mineId.text = getString(R.string.mine_login_or_register_tip)
                }.otherwise {
                    mineNickname.text = user.nickname
                    mineId.text = String.format(getString(R.string.mine_id, user.id))
                }
            })

            isLogin.observe(this@MineFragment, Observer {
                mineLogoutBtn.visibility = if (it) View.VISIBLE else View.GONE
            })
        }

        AccountServiceImplGlobal.apply {
            getUserInfoLiveData().observe(this@MineFragment, Observer { userInfo ->
                viewModel.userInfo.value = userInfo
            })
            isLoginLiveData().observe(this@MineFragment, Observer { isLogin ->
                viewModel.isLogin.value = isLogin
            })
        }

        mineLay.setOnClickListener {
            viewModel.isLogin().no {
                ARouterHelper.greenChannelNavigation(RouterPath.PAGER_ACTIVITY_ACCOUNT)
            }
        }

        mineViewIntegral.setOnClickListener {
            ARouterHelper.navWithLoginInterceptorCallback(RouterPath.PAGER_ACTIVITY_INTEGRAL_RECORD)
        }

        mineIntegralRank.setOnClickListener {
            ARouterHelper.navWithLoginInterceptorCallback(RouterPath.PAGER_ACTIVITY_INTEGRAL_RANK)
        }

        mineLogoutBtn.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("提示")
                .setPositiveButton("确定") { dialog, _ ->
                    dialog.dismiss()
                    logout()
                }.setNegativeButton("取消") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        mineSetting.setOnClickListener {
            ARouterHelper.navigation(RouterPath.PAGER_ACTIVITY_SETTING)
        }
    }

    private fun logout() {
        viewModel.logout()
    }

    override fun initViewAfter(savedInstanceState: Bundle?) {
        super.initViewAfter(savedInstanceState)
        viewModel.refreshMineInfo()
    }
}