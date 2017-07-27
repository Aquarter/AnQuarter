package com.a.quarter.view.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.RegistPresenter;
import com.a.quarter.view.iview.IRegistView;

/**
 * Created by qizepu on 2017/7/27.
 */

public class RegistActivity extends BaseActivity<RegistPresenter> implements IRegistView, View.OnClickListener {

    private ImageView back;
    private TextView contain;
    private TextView tourist;
    private EditText name;
    private EditText phone;
    private EditText pwd;
    private RadioButton man;
    private RadioButton woman;
    private RadioGroup sex;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new RegistPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_regist;
    }

    @Override
    protected void initView() {
        back = (ImageView) findViewById(R.id.activity_regist_back);        //返回
        contain = (TextView) findViewById(R.id.activity_regist_contain);   //已有账号
        tourist = (TextView) findViewById(R.id.activity_regist_tourist);   //游客登陆
        name = (EditText) findViewById(R.id.activity_regist_name);         //账号
        phone = (EditText) findViewById(R.id.activity_regist_phone);       //电话
        pwd = (EditText) findViewById(R.id.activity_regist_pwd);           //密码
        man = (RadioButton) findViewById(R.id.activity_regist_man);        //性别男
        woman = (RadioButton) findViewById(R.id.activity_regist_woman);    //性别女
        sex = (RadioGroup) findViewById(R.id.activity_regist_radiogroup);  //性别

        //不要忘记注册点击事件
        back.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_regist_back:
                finish();
                break;
            default:
                Toast.makeText(mContext, "正在研发中", Toast.LENGTH_SHORT).show();
        }
    }
}
