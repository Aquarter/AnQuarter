package com.a.quarter.view.activity;

import android.view.View;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.UploadVideoPresenter;
import com.a.quarter.view.iview.IUploadVideoView;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/8/4  19:28
 * <p>
 * 思路：
 */


public class UploadVideoActivity extends BaseActivity<UploadVideoPresenter> implements IUploadVideoView,View.OnClickListener{

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new UploadVideoPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_upload_video;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {

    }


}
