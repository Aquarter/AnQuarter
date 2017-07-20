package com.a.quarter.base;

/**
 * Created by qizepu on 2017/7/17.
 *
 * 所有的接口都继承这个接口
 */

public interface BaseView<T> {

    void onsuccess(T t);
    void onError(T t);
}
