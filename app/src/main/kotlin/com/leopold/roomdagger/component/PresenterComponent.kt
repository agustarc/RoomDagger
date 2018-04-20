package com.leopold.roomdagger.component

import com.leopold.roomdagger.annotation.UserScope
import com.leopold.roomdagger.presenter.composer.MemoComposerPresenter
import com.leopold.roomdagger.presenter.list.MemoListPresenter
import dagger.Component

/**
 * @author Leopold
 */
@UserScope
@Component(dependencies = [SingletonComponent::class])
interface PresenterComponent {
    fun inject(presenter: MemoComposerPresenter)
    fun inject(presenter: MemoListPresenter)
}