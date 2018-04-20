package com.leopold.roomdagger.presenter

import android.app.Activity
import com.leopold.roomdagger.annotation.UserScope
import com.leopold.roomdagger.presenter.composer.MemoComposerPresenter
import com.leopold.roomdagger.presenter.list.MemoListPresenter
import dagger.Module
import dagger.Provides

/**
 * @author Leopold
 */
@Module
class ActivityPresenterModule {

    @Provides
    @UserScope
    fun provideMemoComposerPresenter(context: Activity): MemoComposerPresenter {
        return MemoComposerPresenter(context)
    }

    @Provides
    @UserScope
    fun provideMemoListPresenter(context: Activity): MemoListPresenter {
        return MemoListPresenter(context)
    }

}