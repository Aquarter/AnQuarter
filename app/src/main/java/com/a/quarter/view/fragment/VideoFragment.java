package com.a.quarter.view.fragment;

import com.a.quarter.R;
import com.a.quarter.base.BaseFragment;
import com.a.quarter.presenter.VideoFragmentPresenter;

/**
 * desc：
 * Created by wd on 2017/7/20.
 * thinking：
 */

public class VideoFragment extends BaseFragment{





    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter=new VideoFragmentPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.video_fragment;
    }
}
