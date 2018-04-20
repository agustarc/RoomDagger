package com.leopold.roomdagger.presenter.composer

import android.app.Activity
import com.leopold.roomdagger.App
import com.leopold.roomdagger.component.DaggerPresenterComponent
import com.leopold.roomdagger.database.dao.MemoDao
import com.leopold.roomdagger.presenter.BasePresenter
import com.leopold.roomdagger.presenter.PresenterView
import javax.inject.Inject

/**
 * @author Leopold
 */
class MemoComposerPresenter constructor(context: Activity) : BasePresenter<MemoComposerPresenter.View>() {
    override var view: View? = context as View
    @Inject lateinit var dao: MemoDao

    init {
        DaggerPresenterComponent.builder()
                .singletonComponent(App.getSingletonComponent(context))
                .build().inject(this)
    }

    interface View : PresenterView {

    }
}