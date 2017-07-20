package com.a.quarter.model.httputils;


import com.a.quarter.api.Api;
import com.a.quarter.api.RetrofitApi;
import com.a.quarter.model.bean.MainBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qizepu on 2017/7/17.
 */

public class HttpUtils {

    //请求网络
    public static void gettMainData(Observer observer){

        //创建Retrofit实例并初始化
        Api api = RetrofitApi.getServer();
        //通过retrofit生成系定义请求数据接口ILoginBiz的实例  返回ILoginBiz对象
        Observable<MainBean> observable = api.getData();
        observable.observeOn(AndroidSchedulers.mainThread())    //在主线程处理数据
                .subscribeOn(Schedulers.io())                   //在子线程请求数据
                .subscribe(observer);
    }

}
