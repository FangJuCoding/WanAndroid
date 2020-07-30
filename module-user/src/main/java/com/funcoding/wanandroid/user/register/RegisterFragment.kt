package com.funcoding.wanandroid.user.register

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.funcoding.wanandroid.user.R
import com.funcoding.wanandroid.user.account.AccountTrigger
import com.funcoding.wanandroid.user.account.AccountViewModel
import kotlinx.android.synthetic.main.user_register_fragment.*

/**
 * 注册界面
 */
class RegisterFragment(private val accountViewModel: AccountViewModel) : Fragment() {
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
        return inflater.inflate(R.layout.user_register_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        register_goto_login_btn.setOnClickListener {
            accountTrigger.triggerView()
        }
    }
}