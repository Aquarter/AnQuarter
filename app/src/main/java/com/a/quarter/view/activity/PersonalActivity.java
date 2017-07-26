package com.a.quarter.view.activity;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.PersonalPresenter;
import com.a.quarter.view.iview.IPersonalView;

/**
 * Created by qizepu on 2017/7/25.
 *
 *  个人界面
 */

public class PersonalActivity extends BaseActivity<PersonalPresenter> implements IPersonalView{


    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new PersonalPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initDatas() {

    }
}
