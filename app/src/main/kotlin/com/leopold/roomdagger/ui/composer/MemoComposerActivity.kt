package com.leopold.roomdagger.ui.composer

import com.leopold.roomdagger.ActivityModule
import com.leopold.roomdagger.App
import com.leopold.roomdagger.R
import com.leopold.roomdagger.component.DaggerActivityComponent
import com.leopold.roomdagger.presenter.ActivityPresenterModule
import com.leopold.roomdagger.presenter.BasePresenter
import com.leopold.roomdagger.presenter.composer.MemoComposerPresenter
import com.leopold.roomdagger.ui.PresenterActivity
import javax.inject.Inject

/**
 * @author Leopold
 */
class MemoComposerActivity : PresenterActivity<MemoComposerPresenter.View>(), MemoComposerPresenter.View {
    @Inject lateinit var presenter: MemoComposerPresenter

    override fun getPresenter(): BasePresenter<MemoComposerPresenter.View>? {
        return presenter
    }

    override fun inject() {
        DaggerActivityComponent.builder()
                .singletonComponent(App.getSingletonComponent(this))
                .activityModule(ActivityModule(this))
                .activityPresenterModule(ActivityPresenterModule())
                .build().inject(this)
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_memo_composer
    }

}