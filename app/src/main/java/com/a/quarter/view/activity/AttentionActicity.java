package com.a.quarter.view.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        mPresenter = new AttentionPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_attention;
    }

    @Override
    protected void initView() {
        toolbar_back = (LinearLayout) findViewById(R.id.toolbar_back);//返回按钮
        toolbar_btn = (TextView) findViewById(R.id.toolbar_btn);//右边的TextView


        toolbar_back.setOnClickListener(this);
        toolbar_btn.setOnClickListener(this);
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
            case R.id.toolbar_btn:
                Toast.makeText(mContext, "你关注啥呀你关注，页面都没做好呢", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
