package com.leopold.roomdagger.presenter.list

import android.app.Activity
import com.leopold.roomdagger.App
import com.leopold.roomdagger.component.DaggerPresenterComponent
import com.leopold.roomdagger.database.dao.MemoDao
import com.leopold.roomdagger.database.entity.Memo
import com.leopold.roomdagger.database.schedulerIO
import com.leopold.roomdagger.extension.asArrayList
import com.leopold.roomdagger.presenter.BasePresenter
import com.leopold.roomdagger.presenter.PresenterView
import javax.inject.Inject

/**
 * @author Leopold
 */
class MemoListPresenter constructor(context: Activity) : BasePresenter<MemoListPresenter.View>() {
    override var view: View? = context as View
    @Inject lateinit var dao: MemoDao

    init {
        DaggerPresenterComponent.builder()
                .singletonComponent(App.getSingletonComponent(context))
                .build().inject(this)
    }

    fun getMemos() {
        view?.run {
            this.showProgress()

            addToDisposable(schedulerIO(dao.getMemos())
                    .subscribe({
                        this.hideProgress()
                        this.setAdapter(it.asArrayList())
                    }, {
                        this.hideProgress()
                    }))
        }
    }

    interface View : PresenterView {
        fun showProgress()
        fun hideProgress()
        fun setAdapter(memos: ArrayList<Memo>)
    }
}