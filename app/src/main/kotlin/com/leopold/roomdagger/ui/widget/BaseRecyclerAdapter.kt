package com.leopold.roomdagger.ui.widget

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.leopold.roomdagger.extension.getSatety
import com.leopold.roomdagger.ui.widget.recycler.RecyclerViewType

/**
 * @author Leopold
 */
abstract class BaseRecyclerAdapter<T> constructor(val context: Context, var items: ArrayList<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val inflater: LayoutInflater = LayoutInflater.from(context)
    var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    fun replace(items: ArrayList<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun concat(items: ArrayList<T>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    open fun getItem(position: Int): T? {
        return items.getSatety(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return RecyclerViewType.VIEW_TYPE_ITEM
    }
}