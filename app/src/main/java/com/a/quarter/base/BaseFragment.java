package com.a.quarter.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by qizepu on 2017/7/18.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {

    protected View mView;
    protected Context mContext;
    protected T mPresenter;
    protected Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(getLayoutId(),null);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        mActivity = getActivity();
        mContext = getActivity();
        createPresenter();
        mPresenter.attachView(this);
    }

    protected abstract void createPresenter();
    protected abstract int getLayoutId();


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.detachView();
        }
    }
}
