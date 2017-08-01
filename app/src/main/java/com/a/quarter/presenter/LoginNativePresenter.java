package com.a.quarter.presenter;

import android.content.Context;

import com.a.quarter.api.ObserverApi;
import com.a.quarter.base.BasePresenter;
import com.a.quarter.model.bean.LoginDataBean;
import com.a.quarter.model.httputils.HttpUtils;

/**
 * Created by qizepu on 2017/7/27.
 *
 * 原生登陆
 */

public class LoginNativePresenter extends BasePresenter {

    //注册
    public void getLoginData(Context context,String pwd, String phone){
        HttpUtils.getLoginData(pwd,phone,new ObserverApi<LoginDataBean>(context) {
            @Override
            public void onSuccess(LoginDataBean o) {
                getView().onsuccess(o);
            }
        });
    }

}
