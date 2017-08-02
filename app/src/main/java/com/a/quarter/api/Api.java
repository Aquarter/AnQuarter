package com.a.quarter.api;


import com.a.quarter.application.Content;
import com.a.quarter.model.bean.LoginDataBean;
import com.a.quarter.model.bean.RegisteredDataBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by qizepu on 2017/7/17.
 *
 * 接口
 */

public interface Api {


    //分类页面一级列表请求方法
//    @GET(Content.CART_LIST)
//    Observable<MainBean> getData();

    //登陆接口
    @FormUrlEncoded
    @POST(Content.LOGIN)
    Observable<LoginDataBean> postLoginData(@Field("userPhone") String userPhone,
                                            @Field("userPassword") String userPassword);

    //注册接口
    @FormUrlEncoded
    @POST(Content.REGIST)
    Observable<RegisteredDataBean> postRegData(@Field("userName") String userName,
                                               @Field("userPassword") String userPassword,
                                               @Field("userPhone") String userPhone,
                                               @Field("userSex") String userSex);





}
