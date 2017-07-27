package com.a.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.base.BaseFragment;
import com.a.quarter.presenter.recommend.RecommendFragmentPresenter;
import com.a.quarter.view.fragment.recommendfragment.FollowFragment;
import com.a.quarter.view.fragment.recommendfragment.HotFragment;

/**
 * desc：
 * Created by wd on 2017/7/20.
 * thinking：
 */

public class RecommendFragment extends BaseFragment {

    private RadioGroup radiogroup;
    private RadioButton hot;
    private RadioButton follow;
    private TextView tv_hot;
    private TextView tv_follow;
    private FragmentManager manager;
    private HotFragment hotFragment;
    private FollowFragment followFragment;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        setDefaultFragmetData();
        setRadioGroupListener();
    }




    @Override
    protected void createPresenter() {
        mPresenter=new RecommendFragmentPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        FrameLayout framelayout = (FrameLayout) getView().findViewById(R.id.fragment_recommend_framelayout);
        radiogroup = (RadioGroup) getView().findViewById(R.id.fragment_recommend_radio_group);
        hot = (RadioButton) getView().findViewById(R.id.fragment_recommend_rbtn_hot);
        follow = (RadioButton) getView().findViewById(R.id.fragment_recommend_rbtn_follow);
        tv_hot = (TextView) getView().findViewById(R.id.fragment_recommend_tv_hot);
        tv_follow = (TextView) getView().findViewById(R.id.fragment_recommend_tv_follow);

    }

    //设置默认显示的fragment
    private void setDefaultFragmetData() {
        hotFragment = new HotFragment();
        followFragment = new FollowFragment();
        manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_recommend_framelayout, followFragment);
        transaction.add(R.id.fragment_recommend_framelayout, hotFragment).hide(hotFragment);
        transaction.commit();
    }
    //切换fragment
    private void setRadioGroupListener() {
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.fragment_recommend_rbtn_hot:
                        showHot();
                        tv_hot.setBackgroundResource(R.color.blue);
                        tv_follow.setBackgroundResource(R.color.white);
                        break;
                    case R.id.fragment_recommend_rbtn_follow:
                        showFollow();
                        tv_hot.setBackgroundResource(R.color.white);
                        tv_follow.setBackgroundResource(R.color.blue);
                        break;
                }
            }
        });
    }
    //显示热门界面
    public void showHot(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.show(hotFragment).hide(followFragment);
        transaction.commit();
    }
    //显示关注界面
    public void showFollow(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.show(followFragment).hide(hotFragment);
        transaction.commit();
    }

}
