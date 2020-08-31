package cn.funcoding.wanandroid.base.router.interceptor

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import cn.funcoding.wanandroid.base.router.RouterPath
import cn.funcoding.wanandroid.base.router.service.account.AccountServiceImplGlobal
import java.lang.RuntimeException

/**
 * 登陆检测拦截器
 */
@Interceptor(priority = 100, name = "登陆检测拦截器")
class LoginInterceptor : IInterceptor {
    override fun process(postcard: Postcard, callback: InterceptorCallback) {
        val isLogin = AccountServiceImplGlobal.isLogin()
        if (isLogin) {
            callback.onContinue(postcard)
        } else {
            when (postcard.path) {
                RouterPath.PAGER_ACTIVITY_ACCOUNT,
                RouterPath.PAGER_ACTIVITY_MAIN
                -> {
                    callback.onContinue(postcard)
                }
                else -> {
                    callback.onInterrupt(RuntimeException("需要登陆"))
                }
            }
        }
    }

    override fun init(context: Context?) {
    }
}