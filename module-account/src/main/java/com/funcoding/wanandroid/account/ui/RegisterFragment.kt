package com.funcoding.wanandroid.account.ui

import android.content.Context
import android.os.Bundle
import com.funcoding.wanandroid.base.base.AppContext
import com.funcoding.wanandroid.base.base.BaseFragment
import com.funcoding.wanandroid.base.ext.shortToast
import com.funcoding.wanandroid.account.R
import com.funcoding.wanandroid.account.vm.AccountViewModel
import kotlinx.android.synthetic.main.user_register_fragment.*

/**
 * 注册界面
 */
class RegisterFragment(private val accountViewModel: AccountViewModel) : BaseFragment() {
    private lateinit var accountTrigger: AccountTrigger

    override fun onAttach(context: Context) {
        super.onAttach(context)
        accountTrigger = context as AccountTrigger
    }

    override fun getLayResId(): Int = R.layout.user_register_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        registerGotoLoginBtn.setOnClickListener {
            accountTrigger.triggerView()
        }
        registerBtn.setOnClickListener {
            gotoRegister()
        }
    }


    private fun gotoRegister() {
        val username: String = registerUsernameEt.text.toString().trim()
        val password: String = registerPasswordEt.text.toString().trim()
        val rePassword: String = registerRepasswordEt.text.toString().trim()

        when {
            username.isEmpty() -> AppContext.resources.getString(R.string.user_tip_username_can_not_be_empty)
                .shortToast()
            username.length < 3 -> AppContext.resources.getString(R.string.user_tip_username_must_over_three)
                .shortToast()
            password.isEmpty() -> AppContext.resources.getString(R.string.user_tip_password_can_not_be_empty)
                .shortToast()
            password.length < 6 -> AppContext.resources.getString(R.string.user_tip_password_must_over_six)
                .shortToast()
            rePassword.isEmpty() -> AppContext.resources.getString(R.string.user_tip_please_re_input_password)
                .shortToast()
            !rePassword.contentEquals(password) -> AppContext.resources.getString(R.string.user_tip_password_must_be_same)
                .shortToast()
            else -> accountViewModel.register(username, password, rePassword)
        }

    }
}