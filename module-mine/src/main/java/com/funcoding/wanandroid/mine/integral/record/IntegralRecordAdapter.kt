package com.funcoding.wanandroid.mine.integral.record

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.funcoding.wanandroid.base.ext.otherwise
import com.funcoding.wanandroid.base.ext.toDateTime
import com.funcoding.wanandroid.base.ext.yes
import com.funcoding.wanandroid.mine.R
import com.funcoding.wanandroid.mine.integral.model.IntegralRecord
import kotlinx.android.synthetic.main.mine_integral_record_list_item.view.*

/**
 * 积分记录的适配器
 */
class IntegralRecordAdapter(
    private val context: Context,
    private val integralRecordList: MutableList<IntegralRecord> = mutableListOf()
) :
    RecyclerView.Adapter<IntegralRecordAdapter.ViewHolder>() {

    fun updateData(data: Iterable<IntegralRecord>) {
        integralRecordList.clear()
        integralRecordList.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.mine_integral_record_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = integralRecordList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val integralRecord = integralRecordList[position]
        holder.itemView.run {
            recordItemReason.text = integralRecord.reason
            recordItemCount.text = integralRecord.coinCount.toString()
            recordItemTime.text = integralRecord.date.toDateTime("YYYY-MM-dd HH:mm:ss")
        }
    }
}