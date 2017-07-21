package com.a.quarter.view.fragment;

import android.view.View;

import com.a.quarter.R;
import com.a.quarter.base.BaseFragment;
import com.a.quarter.presenter.JokeFragmentPresenter;

/**
 * desc：
 * Created by xyn on 2017/7/20.
 * thinking：
 */

public class JokeFragment extends BaseFragment {



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

    }

}
