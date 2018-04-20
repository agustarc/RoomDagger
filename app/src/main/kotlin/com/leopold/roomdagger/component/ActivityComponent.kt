package com.leopold.roomdagger.component

import com.leopold.roomdagger.ActivityModule
import com.leopold.roomdagger.annotation.UserScope
import com.leopold.roomdagger.presenter.ActivityPresenterModule
import com.leopold.roomdagger.ui.composer.MemoComposerActivity
import com.leopold.roomdagger.ui.list.MemoListActivity
import dagger.Component

/**
 * @author Leopold
 */
@UserScope
@Component(dependencies = [SingletonComponent::class], modules = [
    ActivityPresenterModule::class,
    ActivityModule::class]
)
interface ActivityComponent {
    fun inject(context: MemoComposerActivity)
    fun inject(context: MemoListActivity)
}