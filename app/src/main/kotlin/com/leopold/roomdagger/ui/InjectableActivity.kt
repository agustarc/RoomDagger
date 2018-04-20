package com.leopold.roomdagger.ui

import android.os.Bundle

/**
 * @author Leopold
 */
abstract class InjectableActivity : BaseActivity() {
    abstract fun inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inject()
    }
}