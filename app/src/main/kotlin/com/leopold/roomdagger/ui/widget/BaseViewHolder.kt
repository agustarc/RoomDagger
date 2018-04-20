package com.leopold.roomdagger.ui.widget

import android.support.v7.widget.RecyclerView
import android.view.View
import com.jakewharton.rxbinding.view.RxView

/**
 * @author Leopold
 */
open class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun setOnItemClickListener(view: View, listener: OnItemClickListener?) {
        RxView.clicks(view).subscribe { listener?.onItemClick(view, adapterPosition) }
    }
}