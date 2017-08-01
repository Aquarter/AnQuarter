package com.a.quarter.view.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.CollectionPresenter;
import com.a.quarter.view.iview.ICollectionView;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/31  18:31
 * <p>
 * 思路：
 * 我的收藏
 */


public class CollectionActivity extends BaseActivity<CollectionPresenter> implements ICollectionView,View.OnClickListener {

    private TextView toolbar_title;
    private LinearLayout toolbar_back;
    private TextView toolbar_btn;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new CollectionPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection;
    }

    @Override
    protected void initView() {
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);//标题头
        toolbar_back = (LinearLayout) findViewById(R.id.toolbar_back);//返回按钮
        toolbar_btn = (TextView) findViewById(R.id.toolbar_btn);//右边的TextView


        toolbar_back.setOnClickListener(this);
        toolbar_btn.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
        toolbar_title.setText("我的收藏");
        toolbar_btn.setText("删除");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toolbar_back:
                this.finish();
                break;
            case R.id.toolbar_btn:
                this.finish();
                break;
        }
    }
}
