package com.a.quarter.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.model.bean.LoginDataBean;
import com.a.quarter.presenter.LoginNativePresenter;
import com.a.quarter.utils.SPUtil;
import com.a.quarter.utils.TUtil;
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
        LoginDataBean loginDataBean = (LoginDataBean) o;
        if (loginDataBean.getCode().equals("200")){
            TUtil.showShort(mContext,"登陆成功");
            SPUtil.put(mContext,"userId",loginDataBean.getUser().getUserId());
            SPUtil.put(mContext,"userName",loginDataBean.getUser().getUserName());
            SPUtil.put(mContext,"userPassword",loginDataBean.getUser().getUserPassword());
            SPUtil.put(mContext,"userPhone",loginDataBean.getUser().getUserPhone());
            SPUtil.put(mContext,"userSex",loginDataBean.getUser().getUserSex());

            startActivity(new Intent(mContext,MainActivity.class));
        }
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
                overridePendingTransition(R.anim.right_in,R.anim.right_out);
                break;
            case R.id.activity_login_native_regist:
                startActivity(new Intent(mContext,RegistActivity.class));
                break;
            case R.id.activity_login_native_forgetpwd:
                TUtil.showShort(mContext,"正在研发中");
                break;
            case R.id.activity_login_native_tourist:
                TUtil.showShort(mContext,"正在研发中");
                break;
            case R.id.activity_login_native_name:
                TUtil.showShort(mContext,"正在研发中");
                break;
            case R.id.activity_login_native_pwd:
                TUtil.showShort(mContext,"正在研发中");
                break;
            case R.id.activity_login_native_login:
                String phone = name.getText().toString();
                String password = pwd.getText().toString();
                if (phone == null || phone.equals("")){
                    TUtil.showShort(mContext,"用户名不能为空");
                }else if (password == null || password.equals("")){
                    TUtil.showShort(mContext,"密码不能为空");
                }else {
                    mPresenter.getLoginData(mContext,password,phone);
                }
                break;
        }
    }
}
