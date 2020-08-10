package com.funcoding.wanandroid.user.account

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.base.BaseActivity
import com.funcoding.wanandroid.base.ext.otherwise
import com.funcoding.wanandroid.base.ext.yes
import com.funcoding.wanandroid.base.router.RouterPath
import com.funcoding.wanandroid.user.R
import com.funcoding.wanandroid.user.login.LoginFragment
import com.funcoding.wanandroid.user.register.RegisterFragment
import kotlinx.android.synthetic.main.user_account_activity.*

/**
 * 登陆注册相关界面
 */
@Route(path = RouterPath.PAGER_ACTIVITY_ACCOUNT)
class AccountActivity : BaseActivity(), AccountTrigger {
    private lateinit var loginFragment: LoginFragment
    private lateinit var registerFragment: RegisterFragment
    private lateinit var currentFragment: Fragment

    private val accountViewModel: AccountViewModel by lazy {
        ViewModelProviders.of(this).get(AccountViewModel::class.java)
    }

    override fun getLayoutResId(): Int = R.layout.user_account_activity

    override fun initView(savedInstanceState: Bundle?) {
        accountCloseImg.setOnClickListener {
            finish()
        }

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
                    loginSuccess()
                }
            })

            registerResult.observe(this@AccountActivity, Observer { result ->
                result.yes {
                    loginSuccess()
                }
            })
        }
    }

    private fun loginSuccess() {
        // TODO 登陆成功
        finish()
    }

    override fun initData(savedInstanceState: Bundle?) {
        val username = accountViewModel.getUsername()
        if (!TextUtils.isEmpty(username)) {
            loginFragment = LoginFragment(accountViewModel)
            currentFragment = loginFragment
        } else {
            registerFragment = RegisterFragment(accountViewModel)
            currentFragment = registerFragment
        }

        currentFragment.let {
            supportFragmentManager.beginTransaction()
                .add(R.id.accountFragContainer, it)
                .commit()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        currentFragment.onActivityResult(requestCode, resultCode, data)
    }

    override fun triggerView() {
        // 当前是登陆界面，则切换至注册界面
        if (currentFragment == loginFragment) {
            if (!this::registerFragment.isInitialized) {
                registerFragment = RegisterFragment(accountViewModel)
            }
            currentFragment = registerFragment
        } else {
            // 当前是注册界面，则切换至登陆界面
            if (!this::loginFragment.isInitialized) {
                loginFragment = LoginFragment(accountViewModel)
            }
            currentFragment = loginFragment
        }
        currentFragment.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.accountFragContainer, it).commit()
        }
    }
}