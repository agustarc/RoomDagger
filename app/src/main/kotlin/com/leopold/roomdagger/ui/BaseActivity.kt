package com.leopold.roomdagger.ui

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import com.leopold.roomdagger.R

/**
 * @author Leopold
 */
abstract class BaseActivity : AppCompatActivity() {
    @LayoutRes abstract fun getLayoutResId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
    }

    protected fun setRefreshLayoutColor(refreshLayout: SwipeRefreshLayout, enabled: Boolean = true) {
        refreshLayout.setColorSchemeResources(
                R.color.progress_color1,
                R.color.progress_color2,
                R.color.progress_color3,
                R.color.progress_color4)

        refreshLayout.isEnabled = enabled
    }
}