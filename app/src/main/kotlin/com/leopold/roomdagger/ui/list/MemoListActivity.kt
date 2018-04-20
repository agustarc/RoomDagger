package com.leopold.roomdagger.ui.list

import com.leopold.roomdagger.ActivityModule
import com.leopold.roomdagger.App
import com.leopold.roomdagger.R
import com.leopold.roomdagger.component.DaggerActivityComponent
import com.leopold.roomdagger.database.entity.Memo
import com.leopold.roomdagger.presenter.ActivityPresenterModule
import com.leopold.roomdagger.presenter.BasePresenter
import com.leopold.roomdagger.presenter.list.MemoListPresenter
import com.leopold.roomdagger.ui.PresenterActivity
import javax.inject.Inject

/**
 * @author Leopold
 */
class MemoListActivity : PresenterActivity<MemoListPresenter.View>(), MemoListPresenter.View {
    @Inject lateinit var presenter: MemoListPresenter

    override fun getPresenter(): BasePresenter<MemoListPresenter.View>? {
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
        return R.layout.activity_memo_list
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAdapter(memos: ArrayList<Memo>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}