package com.a.quarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.video.VideoDetailsPresenter;
import com.a.quarter.view.iview.video.IVideoDetailsView;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/28  20:10
 * <p>
 * 思路：
 */


public class VideoDetailsActivity extends BaseActivity<VideoDetailsPresenter> implements IVideoDetailsView,View.OnClickListener {
    private ImageView inculdeTitleBack;
    private TextView videoDetailsText;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new VideoDetailsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_details;
    }

    @Override
    protected void initView() {
        inculdeTitleBack = (ImageView) findViewById(R.id.inculde_title_back);
        inculdeTitleBack.setOnClickListener(this);
        videoDetailsText = (TextView) findViewById(R.id.video_details_text);
        videoDetailsText.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int text = this.getIntent().getIntExtra("text",0);
        initView();
        initDatas();
        videoDetailsText.setText(text + "");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.inculde_title_back:

                break;
        }

    }
}
