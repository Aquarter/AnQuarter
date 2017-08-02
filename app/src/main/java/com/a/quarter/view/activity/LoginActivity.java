package com.a.quarter.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.LoginPresenter;
import com.a.quarter.utils.ShareSdkUtils;
import com.a.quarter.view.iview.ILoginView;

/**
 * Created by qizepu on 2017/7/25.
 *
 * 登陆界面
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView, View.OnClickListener {


    private ImageView back;
    private TextView else_login;
    private Button qq_login;
    private Button wechat_login;

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
        back = (ImageView) findViewById(R.id.activity_login_back);
        else_login = (TextView) findViewById(R.id.activity_login_else_login);
        qq_login = (Button) findViewById(R.id.activity_login_qq);
        wechat_login = (Button) findViewById(R.id.activity_login_wechat);
        back.setOnClickListener(this);
        else_login.setOnClickListener(this);
        qq_login.setOnClickListener(this);
        wechat_login.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_login_back:
                finish();
//                overridePendingTransition(R.anim.right_in,R.anim.right_out);
                break;
            case R.id.activity_login_else_login:
                startActivity(new Intent(mContext,LoginNativeActivity.class));
                break;
            case R.id.activity_login_qq:
//                TUtil.showShort(mContext,"正在研发中");

                ShareSdkUtils.QLogin(mContext);
                break;
            case R.id.activity_login_wechat:
//                TUtil.showShort(mContext,"正在研发中");
                ShareSdkUtils.showShare(mContext);
                break;

        }
    }

}
