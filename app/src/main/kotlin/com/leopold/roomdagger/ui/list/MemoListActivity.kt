package com.leopold.roomdagger.ui.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.leopold.roomdagger.ActivityModule
import com.leopold.roomdagger.App
import com.leopold.roomdagger.R
import com.leopold.roomdagger.component.DaggerActivityComponent
import com.leopold.roomdagger.database.entity.Memo
import com.leopold.roomdagger.presenter.ActivityPresenterModule
import com.leopold.roomdagger.presenter.BasePresenter
import com.leopold.roomdagger.presenter.list.MemoListPresenter
import com.leopold.roomdagger.ui.PresenterActivity
import com.leopold.roomdagger.ui.widget.OnItemClickListener
import com.leopold.roomdagger.ui.widget.VerticalDividerItemDecoration
import kotlinx.android.synthetic.main.activity_memo_list.*
import javax.inject.Inject

/**
 * @author Leopold
 */
class MemoListActivity : PresenterActivity<MemoListPresenter.View>(), MemoListPresenter.View, OnItemClickListener {
    @Inject lateinit var presenter: MemoListPresenter

    private val toolbar by lazy { memo_list_toolbar }
    private val refreshLayout by lazy { memo_list_refresh_layout }
    private val recyclerView by lazy { memo_list_recycler_view }

    private var adapter: MemoRecyclerAdapter? = null

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setRefreshLayoutColor(refreshLayout, false)

        recyclerView.setHasFixedSize(false)
        recyclerView.addItemDecoration(VerticalDividerItemDecoration(this, R.dimen.margin_general))
        recyclerView.layoutManager = LinearLayoutManager(this)

        presenter.getMemos()
    }

    override fun showProgress() {
        refreshLayout.isRefreshing = true
    }

    override fun hideProgress() {
        refreshLayout.isRefreshing = false
    }

    override fun setAdapter(memos: ArrayList<Memo>) {
        if (adapter == null) {
            adapter = MemoRecyclerAdapter(this, memos).apply {
                setOnItemClickListener(this@MemoListActivity)
                recyclerView.adapter = this
            }
        } else {
            adapter?.replace(memos)
        }
    }

    override fun onItemClick(view: View, position: Int) {

    }
}