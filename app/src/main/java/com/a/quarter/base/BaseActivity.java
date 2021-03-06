package com.a.quarter.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.a.quarter.R;
import com.a.quarter.application.MyApplication;


/**
 * Created by qizepu on 2017/7/17.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected Context mContext;
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        init();
        initView();//初始化当前Activity控件
        initDatas();//初始化数据

    }

    private void init(){
        mContext = this;
        MyApplication.getInstance().addActivity(this);//添加当前Activity
        createPresenter();
        mPresenter.attachView(this);
    }

    protected abstract void createPresenter();

    //初始化布局
    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void initDatas();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.getInstance().removeActivity(this);//移除当前Activity
        //        Presenter解除绑定
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

}
