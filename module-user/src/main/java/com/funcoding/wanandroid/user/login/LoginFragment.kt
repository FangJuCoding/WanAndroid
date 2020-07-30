package com.funcoding.wanandroid.user.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.router.RouterPath
import com.funcoding.wanandroid.user.R

/**
 * 登陆页面
 */
@Route(path = RouterPath.ActivityPath.PAGER_SIGN)
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_login_fragment, container, false)
    }
}
