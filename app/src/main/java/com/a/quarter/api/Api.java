package com.a.quarter.api;


import com.a.quarter.application.Content;
import com.a.quarter.model.bean.MainBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by qizepu on 2017/7/17.
 *
 * 接口
 */

public interface Api {


    //分类页面一级列表请求方法
    @GET(Content.CART_LIST)
    Observable<MainBean> getData();

}
