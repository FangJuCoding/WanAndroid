package com.funcoding.wanandroid.user.account

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.launcher.ARouter
import com.funcoding.wanandroid.base.base.BaseActivity
import com.funcoding.wanandroid.base.ext.otherwise
import com.funcoding.wanandroid.base.ext.yes
import com.funcoding.wanandroid.base.router.RouterPath
import com.funcoding.wanandroid.base.widget.LoadingDialogFragment
import com.funcoding.wanandroid.user.R
import com.funcoding.wanandroid.user.login.LoginFragment
import com.funcoding.wanandroid.user.register.RegisterFragment

/**
 * 登陆注册相关界面
 */
class AccountActivity : BaseActivity(), AccountTrigger {
    private var loginFragment: LoginFragment? = null
    private var registerFragment: RegisterFragment? = null
    private var currentFragment: Fragment? = null

    private val accountViewModel: AccountViewModel by lazy {
        ViewModelProviders.of(this).get(AccountViewModel::class.java)
    }

    override fun getLayoutResId(): Int = R.layout.user_account_activity

    override fun initView() {
        accountViewModel.apply {
            isShowLoading.observe(this@AccountActivity, Observer { result ->
                result.yes {
                    showLoading()
                }.otherwise {
                    hideLoading()
                }
            })

            loginResult.observe(this@AccountActivity, Observer { result ->
                result.yes {
                    gotoMain()
                }
            })

            registerResult.observe(this@AccountActivity, Observer { result ->
                result.yes {
                    gotoMain()
                }
            })
        }
    }

    private fun gotoMain() {
        ARouter.getInstance().build(RouterPath.PAGER_MAIN)
            .navigation()
        finish()
    }

    override fun initData() {
        val username = accountViewModel.getUsername()
        if (!TextUtils.isEmpty(username)) {
            loginFragment = LoginFragment(accountViewModel)
            currentFragment = loginFragment
        } else {
            registerFragment = RegisterFragment(accountViewModel)
            currentFragment = registerFragment
        }

        currentFragment?.let {
            supportFragmentManager.beginTransaction()
                .add(R.id.account_fragment_container, it)
                .commit()
        }
    }

    companion object {
        fun gotoAccountActivity(context: Context) {
            context.startActivity(Intent(context, AccountActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        currentFragment?.onActivityResult(requestCode, resultCode, data)
    }

    override fun triggerView() {
        // 当前是登陆界面，则切换至注册界面
        if (currentFragment == loginFragment) {
            if (registerFragment == null) {
                registerFragment = RegisterFragment(accountViewModel)
            }
            currentFragment = registerFragment
        } else {
            // 当前是注册界面，则切换至登陆界面
            if (loginFragment == null) {
                loginFragment = LoginFragment(accountViewModel)
            }
            currentFragment = loginFragment
        }
        currentFragment?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.account_fragment_container, it).commit()
        }
    }
}