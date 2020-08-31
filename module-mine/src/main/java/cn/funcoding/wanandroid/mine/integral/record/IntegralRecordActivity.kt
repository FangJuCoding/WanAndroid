package cn.funcoding.wanandroid.mine.integral.record

import android.os.Bundle
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import cn.funcoding.wanandroid.base.base.BaseVmActivity
import cn.funcoding.wanandroid.base.router.RouterPath
import cn.funcoding.wanandroid.mine.R
import kotlinx.android.synthetic.main.mine_integral_record_activity.*
import kotlinx.android.synthetic.main.mine_integral_record_view.*

@Route(path = RouterPath.PAGER_ACTIVITY_INTEGRAL_RECORD)
class IntegralRecordActivity : BaseVmActivity<IntegralRecordViewModel>() {
    private lateinit var integralRecordAdapter: IntegralRecordAdapter

    override fun getViewModelClazz(): Class<IntegralRecordViewModel> =
        IntegralRecordViewModel::class.java

    override fun getLayoutResId(): Int = R.layout.mine_integral_record_activity

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        integralRecordAdapter = IntegralRecordAdapter(this)
        integralRecordRv.adapter = integralRecordAdapter
        viewModel.apply {
            myIntegralRecord.observe(this@IntegralRecordActivity, Observer {
                mineTotalIntegralTv.text = it.coinCount.toString()
                mineLevelTv.text = String.format(getString(R.string.mine_level), it.level)
                mineRankTv.text = String.format(getString(R.string.mine_rank), it.rank)
            })
            myIntegralRecordList.observe(this@IntegralRecordActivity, Observer {
                integralRecordAdapter.replaceAllData(it)
            })
            isRefreshing.observe(this@IntegralRecordActivity, Observer {
                integralRecordRefreshLayout.isRefreshing = it
            })
        }

        integralRecordRefreshLayout.run {
            setColorSchemeResources(R.color.colorAccent)
            setProgressBackgroundColorSchemeResource(R.color.backgroundPrimary)
            setOnRefreshListener { viewModel.refresh() }
        }

        integralRecordBackImg.setOnClickListener {
            finish()
        }
    }

    override fun initViewAfter(savedInstanceState: Bundle?) {
        super.initViewAfter(savedInstanceState)
        viewModel.refresh()
    }
}