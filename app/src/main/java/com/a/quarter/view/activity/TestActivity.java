package com.a.quarter.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.model.bean.MainBean;
import com.a.quarter.presenter.TestPresenter;
import com.a.quarter.view.iview.ITestView;

public class TestActivity extends BaseActivity<TestPresenter> implements ITestView, View.OnClickListener {

    private Button mButton;
    private TextView mTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void createPresenter() {
        mPresenter = new TestPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mTextview = (TextView) findViewById(R.id.textview);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                mPresenter.getMainData(mContext);
                break;
        }
    }

    @Override
    protected void initDatas() {

    }


    @Override
    public void onsuccess(Object o) {
        MainBean mainBean = (MainBean) o;
        mTextview.setText(mainBean.getResult().getAdvs().get(0).getPic());
    }

    @Override
    public void onError(Object o) {

    }
}
