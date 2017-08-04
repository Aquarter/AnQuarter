package com.a.quarter.view.activity;

import android.view.View;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.UploadJokePresenter;
import com.a.quarter.view.iview.IUploadJokeView;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/8/4  19:23
 * <p>
 * 思路：
 */


public class UploadJokeActivity extends BaseActivity<UploadJokePresenter> implements IUploadJokeView,View.OnClickListener{

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new UploadJokePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_upload_joke;
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
