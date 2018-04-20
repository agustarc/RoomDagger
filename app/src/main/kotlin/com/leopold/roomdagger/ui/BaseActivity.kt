package com.leopold.roomdagger.ui

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

/**
 * @author Leopold
 */
abstract class BaseActivity : AppCompatActivity() {
    @LayoutRes abstract fun getLayoutResId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
    }
}