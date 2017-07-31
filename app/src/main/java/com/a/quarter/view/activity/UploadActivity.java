package com.a.quarter.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.UploadPresenter;
import com.a.quarter.view.iview.IUploadView;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/31  10:34
 * <p>
 * 思路：
 */


public class UploadActivity extends BaseActivity<UploadPresenter> implements IUploadView,View.OnClickListener{
    private TextView upload_back;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new UploadPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_upload;
    }

    @Override
    protected void initView() {
        upload_back = (TextView) findViewById(R.id.upload_back);

        upload_back.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.upload_back:
                    this.finish();
                break;
        }
    }
}
