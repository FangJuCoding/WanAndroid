package com.funcoding.wanandroid.user.account

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.funcoding.wanandroid.base.base.BaseActivity
import com.funcoding.wanandroid.base.global.AccountManager
import com.funcoding.wanandroid.base.widget.LoadingDialog
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
        accountViewModel.isLoading.observe(this, Observer { result ->
            if (result) {
                LoadingDialog.show(this)
            } else {
                LoadingDialog.dismiss()
            }
        })
    }

    override fun initData() {
        val token = AccountManager.token
        if (TextUtils.isEmpty(token)) {
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