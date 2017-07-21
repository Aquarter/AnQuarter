package com.a.quarter.view.fragment.videofragment;

import com.a.quarter.R;
import com.a.quarter.base.BaseFragment;
import com.a.quarter.presenter.video.VideoNearbyPresenter;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/21  19:07
 * <p>
 * 思路：
 */


public class VideoNearbyFragment extends BaseFragment {

    private VideoNearbyPresenter videoNearbyPresenter;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        videoNearbyPresenter = new VideoNearbyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_nearby;
    }

    @Override
    protected void initView() {

    }
}
