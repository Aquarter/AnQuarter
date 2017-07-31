package com.a.quarter.view.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.NoticePresenter;
import com.a.quarter.view.iview.INoticeView;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/31  20:11
 * <p>
 * 思路：
 */


public class NoticeActivity extends BaseActivity<NoticePresenter> implements INoticeView,View.OnClickListener {

    private LinearLayout toolbar_back;
    private TextView toolbar_title;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new NoticePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_notice;
    }

    @Override
    protected void initView() {
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_back = (LinearLayout) findViewById(R.id.toolbar_back);


        toolbar_back.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
        toolbar_title.setText("消息通知");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toolbar_back:
                    this.finish();
                break;
        }
    }

}
