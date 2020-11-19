package com.ujala.dukaan.ui.base

import android.content.Context
import android.view.ViewGroup
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.lastblade.androidarchitecturewithhilt.ui.IAdapterListener

class BaseRecyclerAdapter<T>(
    mContext: Context?,
    mListener: IAdapterListener,
    datas: ArrayList<T>
) :
    RecyclerView.Adapter<BaseViewHolder>() {

    var filterableItems = datas
    lateinit var filterable: Filterable

    var context: Context? = mContext
    var listener: IAdapterListener = mListener
    var datas = datas
    lateinit var holder: BaseViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return listener.getViewHolder(parent, viewType)
    }

    override fun getItemCount() = filterableItems.size

    override fun getItemViewType(position: Int): Int {
        return if (filterableItems.size > 0) position else -1
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (datas.size > 0) {
            this.holder = holder
            this.holder.onBind(position, filterableItems[position], listener)
        }
    }

    fun addData(datas: ArrayList<T>) {
        this.datas.addAll(datas)
        notifyDataSetChanged()
    }

    fun clear() {
        datas.clear()
        filterableItems.clear()
        notifyDataSetChanged()
    }

    fun removeData(datas: ArrayList<T>) {
        this.datas.clear()
        notifyDataSetChanged()
    }

    fun addData(data: T) {
        this.datas.add(data)
        notifyDataSetChanged()
    }

    fun removeData(position: Int) {
        this.datas.removeAt(position)
        notifyDataSetChanged()
    }


}