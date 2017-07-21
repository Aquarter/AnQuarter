package com.a.quarter.view.fragment.videofragment;

import com.a.quarter.R;
import com.a.quarter.base.BaseFragment;
import com.a.quarter.presenter.video.VideoPopularPresenter;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/21  17:25
 * <p>
 * 思路：
 */


public class VideoPopularFragment extends BaseFragment{

    private VideoPopularPresenter videoPopularPresenter;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        videoPopularPresenter = new VideoPopularPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_popular;
    }

    @Override
    protected void initView() {

    }
}
