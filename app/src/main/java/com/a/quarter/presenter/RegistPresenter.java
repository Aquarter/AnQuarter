package com.a.quarter.presenter;

import android.content.Context;

import com.a.quarter.api.ObserverApi;
import com.a.quarter.base.BasePresenter;
import com.a.quarter.model.bean.RegisteredDataBean;
import com.a.quarter.model.httputils.HttpUtils;

/**
 * Created by qizepu on 2017/7/27.
 *
 * 注册
 */

public class RegistPresenter extends BasePresenter {


    //注册
    public void getRegistData(Context context,String name,String pwd,String phone,String sex){
        HttpUtils.getRegistData(name,pwd,phone,sex,new ObserverApi<RegisteredDataBean>(context) {
            @Override
            public void onSuccess(RegisteredDataBean o) {
                getView().onsuccess(o);
            }
        });
    }

}
