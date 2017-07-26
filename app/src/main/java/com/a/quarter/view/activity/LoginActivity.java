package com.a.quarter.view.activity;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.LoginPresenter;
import com.a.quarter.view.iview.ILoginView;

/**
 * Created by qizepu on 2017/7/25.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView {


    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initDatas() {

    }
}
