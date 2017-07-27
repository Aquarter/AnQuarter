package com.a.quarter.view.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.a.quarter.R;
import com.a.quarter.base.BaseFragment;
import com.a.quarter.presenter.joke.JokeFragmentPresenter;

/**
 * desc：
 * Created by wd on 2017/7/20.
 * thinking：
 */

public class JokeFragment extends BaseFragment {


    private SwipeRefreshLayout swip;
    private RecyclerView recycle;
    private ProgressBar progress;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new JokeFragmentPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_joke;
    }

    @Override
    protected void initView() {

        swip = (SwipeRefreshLayout) getView().findViewById(R.id.fragment_joke_swip);
        recycle = (RecyclerView) getView().findViewById(R.id.fragment_joke_recycle);
        progress = (ProgressBar) getView().findViewById(R.id.fragment_joke_progress);
    }

}
