package com.a.quarter.view.activity;

import android.view.View;
import android.widget.LinearLayout;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.AttentionPresenter;
import com.a.quarter.view.iview.IAttentionView;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/31  16:23
 * <p>
 * 思路：
 * 我的关注
 */


public class AttentionActicity extends BaseActivity<AttentionPresenter> implements IAttentionView,View.OnClickListener{

    private LinearLayout attention_back;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new AttentionPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_attention;
    }

    @Override
    protected void initView() {
        attention_back = (LinearLayout) findViewById(R.id.toolbar_back);//返回按钮
        attention_back.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {

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
