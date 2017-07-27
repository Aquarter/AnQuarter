package com.a.quarter.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.LoginNativePresenter;
import com.a.quarter.view.iview.ILoginNativeView;

/**
 * Created by qizepu on 2017/7/27.
 *
 * 原生登陆
 */

public class LoginNativeActivity extends BaseActivity<LoginNativePresenter> implements ILoginNativeView, View.OnClickListener {


    private ImageView back;
    private TextView regist;
    private TextView forgit;
    private TextView tourist;
    private EditText name;
    private EditText pwd;
    private Button login;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new LoginNativePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login_native;
    }

    @Override
    protected void initView() {
        back = (ImageView) findViewById(R.id.activity_login_native_back);          //返回
        regist = (TextView) findViewById(R.id.activity_login_native_regist);       //注册
        forgit = (TextView) findViewById(R.id.activity_login_native_forgetpwd);    //忘记密码
        tourist = (TextView) findViewById(R.id.activity_login_native_tourist);     //游客登陆
        name = (EditText) findViewById(R.id.activity_login_native_name);           //账号
        pwd = (EditText) findViewById(R.id.activity_login_native_pwd);             //密码
        login = (Button) findViewById(R.id.activity_login_native_login);           //登陆

        back.setOnClickListener(this);
        regist.setOnClickListener(this);
        forgit.setOnClickListener(this);
        tourist.setOnClickListener(this);
        name.setOnClickListener(this);
        pwd.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_login_native_back:
                finish();
                break;
            case R.id.activity_login_native_regist:
                startActivity(new Intent(mContext,RegistActivity.class));
                break;
            case R.id.activity_login_native_forgetpwd:
                Toast.makeText(mContext, "正在研发中。。。", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_login_native_tourist:
                Toast.makeText(mContext, "正在研发中。。。", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_login_native_name:
                Toast.makeText(mContext, "正在研发中。。。", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_login_native_pwd:
                Toast.makeText(mContext, "正在研发中。。。", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_login_native_login:
                Toast.makeText(mContext, "正在研发中。。。", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
