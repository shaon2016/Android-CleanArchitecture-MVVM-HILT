package com.lastblade.androidarchitecturewithhilt.ui

import android.view.View
import android.view.ViewGroup
import com.ujala.dukaan.ui.base.BaseViewHolder

interface IAdapterListener {
    fun <T> clickListener(position: Int, model: T, view: View)
    fun  getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder
}