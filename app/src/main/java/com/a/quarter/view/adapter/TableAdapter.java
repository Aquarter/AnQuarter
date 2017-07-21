package com.a.quarter.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/21  19:29
 * <p>
 * 思路：
 */


public class TableAdapter extends FragmentPagerAdapter {

    private String[] mText;
    private List<Fragment> mFgmList = new ArrayList<>();

    public TableAdapter(FragmentManager fm) {
        super(fm);
    }

    public void getmText(String[] TableText){
        this.mText = TableText;
    }

    public void getmFamList(List<Fragment> FgmList){
        this.mFgmList = FgmList;
    }

    @Override
    public Fragment getItem(int position) {

        return mFgmList.get(position);
    }

    @Override
    public int getCount() {
        return mText.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mText[position];
    }
}
