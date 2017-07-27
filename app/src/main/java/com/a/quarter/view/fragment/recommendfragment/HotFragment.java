package com.a.quarter.view.fragment.recommendfragment;

import com.a.quarter.R;
import com.a.quarter.base.BaseFragment;
import com.a.quarter.presenter.recommend.RecommendHotPresenter;
import com.a.quarter.view.iview.recommend.IRecommendHotFragmentView;

/**
 * Created by qizepu on 2017/7/26.
 *
 * 推荐界面  热门
 */

public class HotFragment extends BaseFragment<RecommendHotPresenter> implements IRecommendHotFragmentView {


    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new RecommendHotPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_commend_hot;
    }

    @Override
    protected void initView() {

    }
}
