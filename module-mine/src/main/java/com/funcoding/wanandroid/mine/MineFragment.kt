package com.funcoding.wanandroid.mine

import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.base.BaseVmFragment
import com.funcoding.wanandroid.base.ext.no
import com.funcoding.wanandroid.base.ext.otherwise
import com.funcoding.wanandroid.base.ext.yes
import com.funcoding.wanandroid.base.router.ARouterHelper
import com.funcoding.wanandroid.base.router.RouterPath
import com.funcoding.wanandroid.base.router.service.account.AccountServiceImplGlobal
import kotlinx.android.synthetic.main.mine_fragment.*

/**
 * 我的页面
 */
@Route(path = RouterPath.PAGER_FRAGMENT_MINE)
class MineFragment : BaseVmFragment<MineViewModel>() {
    override fun getLayResId(): Int = R.layout.mine_fragment

    override fun getViewModelClazz(): Class<MineViewModel> = MineViewModel::class.java

    override fun initView() {
        super.initView()
        viewModel.apply {
            userInfo.observe(this@MineFragment, Observer { user ->
                (user == null).yes {
                    mineNickname.text = getString(R.string.mine_login_or_register)
                    mineId.text = getString(R.string.mine_login_or_register_tip)
                    mineMyIntegral.text =
                        String.format(getString(R.string.mine_my_integral, 0))
                }.otherwise {
                    mineNickname.text = user.nickname
                    mineId.text = String.format(getString(R.string.mine_id, user.id))
                    mineMyIntegral.text =
                        String.format(getString(R.string.mine_my_integral, user.coinCount))
                }
            })

            isLogin.observe(this@MineFragment, Observer {
                mineLogoutBtn.visibility = if (it) View.VISIBLE else View.GONE
            })
        }

        mineLay.setOnClickListener {
            viewModel.isLogin().no {
                ARouterHelper.greenChannelNavigation(RouterPath.PAGER_ACTIVITY_ACCOUNT)
            }
        }

        AccountServiceImplGlobal.apply {
            getUserInfoLiveData().observe(this@MineFragment, Observer { userInfo ->
                viewModel.userInfo.value = userInfo
            })
            isLoginLiveData().observe(this@MineFragment, Observer { isLogin ->
                viewModel.isLogin.value = isLogin
            })
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

        mineOpenNightMode.setOnClickListener {
            mineNightModeSwitch.isChecked = !mineNightModeSwitch.isChecked
        }
    }

    private fun logout() {
        viewModel.logout()
    }

    override fun initData() {
        super.initData()
        viewModel.refreshMineInfo()
    }
}