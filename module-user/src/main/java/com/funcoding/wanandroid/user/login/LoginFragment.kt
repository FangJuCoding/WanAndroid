package com.funcoding.wanandroid.user.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.ext.shortToast
import com.funcoding.wanandroid.base.ext.toast
import com.funcoding.wanandroid.base.global.AccountManager
import com.funcoding.wanandroid.base.router.RouterPath
import com.funcoding.wanandroid.user.R
import com.funcoding.wanandroid.user.account.AccountTrigger
import com.funcoding.wanandroid.user.account.AccountViewModel
import kotlinx.android.synthetic.main.user_login_fragment.*

/**
 * 登陆页面
 */
@Route(path = RouterPath.ActivityPath.PAGER_SIGN)
class LoginFragment(private val accountViewModel: AccountViewModel) : Fragment() {
    private lateinit var accountTrigger: AccountTrigger

    override fun onAttach(context: Context) {
        super.onAttach(context)
        accountTrigger = context as AccountTrigger
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        login_goto_register_btn.setOnClickListener {
            accountTrigger.triggerView()
        }

        login_btn.setOnClickListener {
            gotoLogin()
        }
    }

    private fun gotoLogin() {
        val username: String = login_username_et.text.toString().trim()
        val password: String = login_password_et.text.toString().trim()
        val isRememberPwd: Boolean = login_remember_pwd_switch.isChecked

        when {
            username.isEmpty() -> "用户名不能为空".shortToast()
            password.isEmpty() -> "密码不能为空".shortToast()
            else -> accountViewModel.login(username, password, isRememberPwd)
        }

    }
}
