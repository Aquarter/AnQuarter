package com.a.quarter.view.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.FriendsPresenter;
import com.a.quarter.view.iview.IFriendsView;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/31  19:08
 * <p>
 * 思路：
 * 搜索好友
 */


public class FriendsActivity extends BaseActivity<FriendsPresenter> implements IFriendsView,View.OnClickListener {

    private LinearLayout toolbar_back;
    private TextView toolbar_title;
    private TextView toolbar_btn;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new FriendsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_friends;
    }

    @Override
    protected void initView() {
        toolbar_back = (LinearLayout) findViewById(R.id.toolbar_back);//返回按钮
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);//页面标题
        toolbar_btn = (TextView) findViewById(R.id.toolbar_btn);//隐藏右侧按钮
        toolbar_back.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
        toolbar_title.setText("搜索好友");
        toolbar_btn.setVisibility(View.GONE);
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //返回点击事件
            case R.id.toolbar_back:
                    this.finish();
                break;
        }
    }
}
