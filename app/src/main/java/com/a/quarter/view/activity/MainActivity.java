package com.a.quarter.view.activity;

import android.support.v4.app.FragmentTransaction;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.MainPresenter;
import com.a.quarter.view.fragment.JokeFragment;
import com.a.quarter.view.fragment.RecommendFragment;
import com.a.quarter.view.fragment.VideoFragment;
import com.a.quarter.view.iview.IMainView;
import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

/**
 * desc：
 * Created by xyn on 2017/7/20.
 * thinking：
 */

public class MainActivity extends BaseActivity<MainPresenter>  implements BottomNavigationBar.OnTabSelectedListener,IMainView {

    private BottomNavigationBar bottom_bar;
    private RecommendFragment recommendFragment;
    private JokeFragment jokeFragment;
    private VideoFragment videoFragment;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter=new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        bottom_bar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
    }

    @Override
    protected void initDatas() {

        BadgeItem badgeItem = new BadgeItem();
        badgeItem.setHideOnSelect(false)
                .setText("10")
                .setBackgroundColorResource(R.color.orange)
                .setBorderWidth(0);

        setDefaultFragment();
        bottom_bar.setMode(BottomNavigationBar.MODE_FIXED);
//        bottom_bar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottom_bar.setBackgroundStyle(BottomNavigationBar.MODE_SHIFTING);
//        bottom_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
//        bottom_bar.setBarBackgroundColor(R.color.blue);//set background color for navigation bar
//        bottom_bar.setInActiveColor(R.color.white);//unSelected icon color
        bottom_bar.addItem(new BottomNavigationItem(R.drawable.icon_one, R.string.tab_one).setActiveColorResource(R.color.green).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.icon_two, R.string.tab_two).setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.icon_three, R.string.tab_three))
                .setFirstSelectedPosition(0)
                .initialise();

        bottom_bar.setTabSelectedListener(this);


    }


    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        recommendFragment = new RecommendFragment();
        transaction.replace(R.id.flayout, recommendFragment).commit();
    }

    /**
     * bar的三个监听
     *
     */
    @Override
    public void onTabSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (recommendFragment == null) {
                    recommendFragment = new RecommendFragment();
                }
                transaction.replace(R.id.flayout, recommendFragment);
                break;
            case 1:
                if (jokeFragment == null) {
                    jokeFragment = new JokeFragment();
                }
                transaction.replace(R.id.flayout, jokeFragment);
                break;
            case 2:
                if (videoFragment == null) {
                    videoFragment = new VideoFragment();
                }
                transaction.replace(R.id.flayout, videoFragment);
                break;
            default:
                if (recommendFragment == null) {
                    recommendFragment = new RecommendFragment();
                }
                transaction.replace(R.id.flayout, recommendFragment);
                break;
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
