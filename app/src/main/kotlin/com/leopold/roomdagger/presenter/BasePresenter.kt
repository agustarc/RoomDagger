package com.leopold.roomdagger.presenter

import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author Leopold
 */
abstract class BasePresenter<T> {
    private var disposables: CompositeDisposable? = CompositeDisposable()
    abstract var view: T?

    @CallSuper
    open fun onCreate() {}

    @CallSuper
    open fun onPostCreate() {}

    @CallSuper
    open fun onResume() {}

    @CallSuper
    open fun onPause() {}

    @CallSuper
    open fun onStop() {}

    @CallSuper
    open fun onDestroy() {
        disposables?.clear()
        disposables = null
        view = null
    }

    protected fun addToDisposable(disposable: Disposable) {
        disposables?.add(disposable)
    }

    protected fun cancelDisposables() {
        disposables?.clear()
    }
}