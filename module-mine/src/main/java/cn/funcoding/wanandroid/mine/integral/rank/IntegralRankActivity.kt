package cn.funcoding.wanandroid.mine.integral.rank

import android.os.Bundle
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import cn.funcoding.wanandroid.base.base.BaseVmActivity
import cn.funcoding.wanandroid.base.router.RouterPath
import cn.funcoding.wanandroid.mine.R
import kotlinx.android.synthetic.main.mine_integral_rank_activity.*

@Route(path = RouterPath.PAGER_ACTIVITY_INTEGRAL_RANK)
class IntegralRankActivity : BaseVmActivity<IntegralRankViewModel>() {

    private lateinit var integralRankAdapter: IntegralRankAdapter

    override fun getViewModelClazz(): Class<IntegralRankViewModel> =
        IntegralRankViewModel::class.java

    override fun getLayoutResId(): Int = R.layout.mine_integral_rank_activity

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        integralRankAdapter = IntegralRankAdapter(this)
        integralRankRv.adapter = integralRankAdapter

        integralRankBackImg.setOnClickListener {
            finish()
        }

        viewModel.apply {
            userIntegralRankList.observe(this@IntegralRankActivity, Observer {
                integralRankAdapter.replaceAllData(it)
            })
            isRefreshing.observe(this@IntegralRankActivity, Observer {
                integralRankRefreshLayout.isRefreshing = it
            })
        }

        integralRankRefreshLayout.run {
            setColorSchemeResources(R.color.colorAccent)
            setProgressBackgroundColorSchemeResource(R.color.backgroundPrimary)
            setOnRefreshListener { viewModel.refresh() }
        }
    }

    override fun initViewAfter(savedInstanceState: Bundle?) {
        super.initViewAfter(savedInstanceState)
        viewModel.refresh()
    }
}