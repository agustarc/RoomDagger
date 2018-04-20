package com.leopold.roomdagger.ui.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.annotation.DimenRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.leopold.roomdagger.R
import com.leopold.roomdagger.extension.getDimenSize

/**
 * @author Leopold
 */
@Suppress("UNUSED")
class VerticalDividerItemDecoration : RecyclerView.ItemDecoration {
    private var margin = 0
    private var divider: Drawable? = null

    constructor(context: Context?) {
        context?.run {
            divider = ContextCompat.getDrawable(this, R.drawable.drawable_divider)
        }
    }

    constructor(context: Context?, @DimenRes marginResId: Int) {
        context?.run {
            margin = getDimenSize(marginResId)
            divider = ContextCompat.getDrawable(this, R.drawable.drawable_divider)
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        super.onDrawOver(c, parent, state)

        val drawable = divider
        if (drawable != null) {
            val left: Int = parent.paddingLeft + margin
            val right: Int = parent.width - parent.paddingRight - margin
            val dividerSize: Int = drawable.intrinsicHeight

            val count: Int = parent.childCount
            for (position: Int in 0..count) {
                val view: View? = parent.getChildAt(position)
                if (view != null) {
                    val params: RecyclerView.LayoutParams = view.layoutParams as RecyclerView.LayoutParams

                    val top: Int = view.bottom + params.bottomMargin - dividerSize / 2
                    val bottom: Int = top + dividerSize / 2
                    drawable.setBounds(left, top, right, bottom)
                    drawable.draw(c)
                }
            }
        }
    }
}