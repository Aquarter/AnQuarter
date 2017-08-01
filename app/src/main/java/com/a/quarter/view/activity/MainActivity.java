package com.a.quarter.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
import com.facebook.drawee.view.SimpleDraweeView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * desc：
 * Created by wd on 2017/7/20.
 * thinking：
 */

public class MainActivity extends BaseActivity<MainPresenter>  implements BottomNavigationBar.OnTabSelectedListener,IMainView,View.OnClickListener{

    private BottomNavigationBar bottom_bar;
    private RecommendFragment recommendFragment;
    private JokeFragment jokeFragment;
    private VideoFragment videoFragment;
    private TextView tvMainTitle;
    
    private ImageView imgMainPublished;
    private SimpleDraweeView user_icon;
    private SimpleDraweeView header_icon;
    private SlidingMenu menu;
    private Uri uri;
    private LinearLayout slidingmenu_attention;
    private LinearLayout slidingmenu_notice;
    private LinearLayout slidingmenu_friends;
    private LinearLayout slidingmenu_collection;

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
        tvMainTitle = (TextView) findViewById(R.id.main_title);
        imgMainPublished = (ImageView) findViewById(R.id.main_published);
        user_icon = (SimpleDraweeView) findViewById(R.id.main_userIcon);

        user_icon.setOnClickListener(this);
        tvMainTitle.setOnClickListener(this);
        imgMainPublished.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {

        uri = Uri.parse("http://img2-ak.lst.fm/i/u/avatar300s/db40b6dd8f8a76d761785ff4d5f7281e.jpg");

        setBottomBar();
        //设置用户头像
        user_icon.setImageURI(uri);
        //设置slidingmenu相关
        setSlidingMenu();

    }

    private void setSlidingMenu() {

        // configure the SlidingMenu
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.SLIDING_WINDOW);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.slidingmenu);

        slidingmenu_notice = (LinearLayout) findViewById(R.id.slidingmenu_notice);//消息通知
        slidingmenu_friends = (LinearLayout) findViewById(R.id.slidingmenu_friends);//我得好友
        slidingmenu_collection = (LinearLayout) findViewById(R.id.slidingmenu_collection);//我得收藏
        slidingmenu_attention = (LinearLayout) findViewById(R.id.slidingmenu_attention);//我的关注


        slidingmenu_attention.setOnClickListener(this);
        slidingmenu_attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AttentionActicity.class));
            }
        });
        slidingmenu_collection.setOnClickListener(this);
        slidingmenu_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CollectionActivity.class));
            }
        });
        slidingmenu_friends.setOnClickListener(this);
        slidingmenu_friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FriendsActivity.class));
            }
        });
        slidingmenu_notice.setOnClickListener(this);
        slidingmenu_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NoticeActivity.class));
            }
        });

        header_icon = (SimpleDraweeView) menu.findViewById(R.id.sm_userIcon);
        header_icon.setImageURI(uri);
        header_icon.setOnClickListener(this);

        header_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle(false);
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            //用户头像
            case R.id.main_userIcon:
                menu.toggle();
                break;
            //发表
            case R.id.main_published:
                Intent intent = new Intent(MainActivity.this, UploadActivity.class);
                startActivity(intent);
                break;
        }

    }

    //设置bar相关
    private void setBottomBar() {


        //初始化气泡
        BadgeItem badgeItem = new BadgeItem();
        badgeItem.setHideOnSelect(true)
                .setText("mmp")
                .setBackgroundColorResource(R.color.green)
                .setBorderWidth(0);

        setDefaultFragment();
        bottom_bar.setMode(BottomNavigationBar.MODE_FIXED);
//        bottom_bar.setMode(BottomNavigationBar.MODE_SHIFTING);
        //   bottom_bar.setBackgroundStyle(BottomNavigationBar.MODE_SHIFTING);
//        bottom_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottom_bar.setBarBackgroundColor(R.color.white);//set background color for navigation bar
//        bottom_bar.setInActiveColor(R.color.white);//unSelected icon color                                                                                                                            //设置上气泡
        bottom_bar.addItem(new BottomNavigationItem(R.mipmap.bar_tuijian_select, R.string.tab_one).setInactiveIcon(this.getDrawable(R.mipmap.bar_tuijian_normal)).setActiveColorResource(R.color.blue).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.bar_smiel_select, R.string.tab_two).setInactiveIcon(this.getDrawable(R.mipmap.bar_smeil_normal)).setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.mipmap.bar_video_select, R.string.tab_three).setInactiveIcon(this.getDrawable(R.mipmap.bar_video_normal)).setActiveColorResource(R.color.blue))
                .setFirstSelectedPosition(0)
                .initialise();
        bottom_bar.setTabSelectedListener(this);

    }

    //设置默认fragment
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
                tvMainTitle.setText("推荐");
                if (recommendFragment == null) {
                    recommendFragment = new RecommendFragment();
                }
                transaction.replace(R.id.flayout, recommendFragment);
                break;
            case 1:
                tvMainTitle.setText("段子");
                if (jokeFragment == null) {
                    jokeFragment = new JokeFragment();
                }
                transaction.replace(R.id.flayout, jokeFragment);
                break;
            case 2:
                tvMainTitle.setText("视频");
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
