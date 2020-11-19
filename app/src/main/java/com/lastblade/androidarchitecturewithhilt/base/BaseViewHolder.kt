package com.ujala.dukaan.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lastblade.androidarchitecturewithhilt.ui.IAdapterListener

abstract class BaseViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun<T> onBind(position: Int, model:T, mCallback : IAdapterListener)

}