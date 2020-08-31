package cn.funcoding.wanandroid.account.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import cn.funcoding.wanandroid.base.base.AppContext
import cn.funcoding.wanandroid.base.base.BaseFragment
import cn.funcoding.wanandroid.base.ext.shortToast
import cn.funcoding.wanandroid.account.R
import cn.funcoding.wanandroid.account.vm.AccountViewModel
import kotlinx.android.synthetic.main.user_login_fragment.*

/**
 * 登陆页面
 */
class LoginFragment(private val accountViewModel: AccountViewModel) : BaseFragment() {
    private lateinit var accountTrigger: AccountTrigger

    override fun onAttach(context: Context) {
        super.onAttach(context)
        accountTrigger = context as AccountTrigger
    }

    override fun getLayResId(): Int = R.layout.user_login_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginUsernameEt.setText(accountViewModel.getUsername())
        loginPasswordEt.setText(accountViewModel.getPassword())
        loginRememberPwdSwitch.isChecked = accountViewModel.isRememberPwd()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loginGotoRegisterBtn.setOnClickListener {
            accountTrigger.triggerView()
        }

        loginBtn.setOnClickListener {
            gotoLogin()
        }
    }

    private fun gotoLogin() {
        val username: String = loginUsernameEt.text.toString().trim()
        val password: String = loginPasswordEt.text.toString().trim()
        val isRememberPwd: Boolean = loginRememberPwdSwitch.isChecked

        when {
            username.isEmpty() -> AppContext.resources.getString(R.string.user_tip_username_can_not_be_empty)
                .shortToast()
            username.length < 3 -> AppContext.resources.getString(R.string.user_tip_username_must_over_three)
                .shortToast()
            password.isEmpty() -> AppContext.resources.getString(R.string.user_tip_password_can_not_be_empty)
                .shortToast()
            password.length < 6 -> AppContext.resources.getString(R.string.user_tip_password_must_over_six)
                .shortToast()
            else -> accountViewModel.login(username, password, isRememberPwd)
        }

    }
}
