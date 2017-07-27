package com.a.quarter.view.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.a.quarter.R;
import com.a.quarter.base.BaseFragment;
import com.a.quarter.presenter.video.VideoFragmentPresenter;
import com.a.quarter.view.adapter.TableAdapter;
import com.a.quarter.view.fragment.videofragment.VideoNearbyFragment;
import com.a.quarter.view.fragment.videofragment.VideoPopularFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * desc：
 * Created by wd on 2017/7/20.
 * thinking：
 */

public class VideoFragment extends BaseFragment{


    private ViewPager videoViewPager;
    private TabLayout videoTable;
    private TableAdapter tableAdapter;
    private String[] TableText = new String[] {"热点","附近"};
    private List<Fragment> mFgmList = new ArrayList<>();


    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter=new VideoFragmentPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
        videoTable = (TabLayout) getActivity().findViewById(R.id.inculde_tableyout);
        videoViewPager = (ViewPager) getActivity().findViewById(R.id.inculde_viewpager);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        setData();
    }

    private void setData() {
        mFgmList.add(new VideoPopularFragment());
        mFgmList.add(new VideoNearbyFragment());
        tableAdapter = new TableAdapter(getChildFragmentManager());
        tableAdapter.getmText(TableText);
        tableAdapter.getmFamList(mFgmList);
        videoViewPager.setAdapter(tableAdapter);
        videoTable.setupWithViewPager(videoViewPager);
//        videoTable.setTabMode(TabLayout.MODE_SCROLLABLE);
        videoTable.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(videoTable,30,30);
            }
        });
    }

    //
    public void setIndicator (TabLayout tabs,int leftDip,int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }
}