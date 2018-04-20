package com.leopold.roomdagger.ui.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.leopold.roomdagger.R
import com.leopold.roomdagger.database.entity.Memo
import com.leopold.roomdagger.ui.widget.BaseRecyclerAdapter
import com.leopold.roomdagger.ui.widget.BaseViewHolder
import com.leopold.roomdagger.ui.widget.OnItemClickListener
import com.leopold.roomdagger.ui.widget.recycler.RecyclerViewType

/**
 * @author Leopold
 */
class MemoRecyclerAdapter constructor(context: Context, memos: ArrayList<Memo>) :
    BaseRecyclerAdapter<Memo>(context, memos) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MemoItemViewHolder(inflater.inflate(R.layout.layout_memo_list_item, parent, false), listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        when (viewType) {
            RecyclerViewType.VIEW_TYPE_ITEM -> onBindMemoViewHolder(holder as MemoItemViewHolder, position)
        }
    }

    private fun onBindMemoViewHolder(holder: MemoItemViewHolder, position: Int) {
        getItem(position)?.run {

        }
    }

    class MemoItemViewHolder(view: View, listener: OnItemClickListener?) : BaseViewHolder(view) {
        init {
            setOnItemClickListener(view, listener)
        }
    }
}