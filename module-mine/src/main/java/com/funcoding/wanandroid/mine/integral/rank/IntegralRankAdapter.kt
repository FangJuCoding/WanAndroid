package com.funcoding.wanandroid.mine.integral.rank

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.funcoding.wanandroid.mine.R
import com.funcoding.wanandroid.mine.integral.model.IntegralRank
import kotlinx.android.synthetic.main.mine_integral_rank_list_item.view.*

/**
 * 积分排行的适配器
 */
class IntegralRankAdapter(
    private val context: Context,
    private val integralRankList: MutableList<IntegralRank> = mutableListOf()
) :
    RecyclerView.Adapter<IntegralRankAdapter.ViewHolder>() {

    fun replaceAllData(data: Iterable<IntegralRank>) {
        integralRankList.clear()
        integralRankList.addAll(data)
        notifyDataSetChanged()
    }

    fun addData(data: Iterable<IntegralRank>) {

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.mine_integral_rank_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = integralRankList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val integralRank = integralRankList[position]
        holder.itemView.run {
            rankNum.text = integralRank.rank
            rankUsername.text = integralRank.username
            rankUserIntegral.text = integralRank.coinCount.toString()
            rankUserId.text = String.format(context.getString(R.string.mine_id), integralRank.userId)
        }
    }
}