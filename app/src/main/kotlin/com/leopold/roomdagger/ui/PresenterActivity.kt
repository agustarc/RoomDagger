package com.leopold.roomdagger.ui

import android.os.Bundle
import com.leopold.roomdagger.presenter.BasePresenter

/**
 * @author Leopold
 */
abstract class PresenterActivity<T> : InjectableActivity() {
    protected abstract fun getPresenter(): BasePresenter<T>?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresenter()?.onCreate()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        getPresenter()?.onPostCreate()
    }

    override fun onResume() {
        super.onResume()
        getPresenter()?.onResume()
    }

    override fun onPause() {
        super.onPause()
        getPresenter()?.onPause()
    }

    override fun onStop() {
        super.onStop()
        getPresenter()?.onStop()
    }

    override fun onDestroy() {
        getPresenter()?.onDestroy()
        super.onDestroy()
    }
}