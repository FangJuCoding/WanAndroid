package com.funcoding.wanandroid.mine.setting

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.base.BaseActivity
import com.funcoding.wanandroid.base.router.RouterPath
import com.funcoding.wanandroid.mine.R
import kotlinx.android.synthetic.main.mine_setting_activity.*

@Route(path = RouterPath.PAGER_ACTIVITY_SETTING)
class SettingActivity : BaseActivity() {
    override fun getLayoutResId(): Int = R.layout.mine_setting_activity

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        val settingFragment = SettingsFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, settingFragment, SettingsFragment::class.java.simpleName)
            .commit()

        settingBackBtn.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}