package com.a.quarter.view.fragment;

import com.a.quarter.R;
import com.a.quarter.base.BaseFragment;
import com.a.quarter.presenter.RecommendFragmentPresenter;

/**
 * desc：
 * Created by xyn on 2017/7/20.
 * thinking：
 */

public class RecommendFragment extends BaseFragment {
    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter=new RecommendFragmentPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.recommend_fragment;
    }

    @Override
    protected void initView() {

    }
}
