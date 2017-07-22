package com.a.quarter.view.activity;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private SimpleDraweeView user_icon;
    private View headerView;
    private SimpleDraweeView headerUserIcon;

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
//        PipelineDraweeControllerBuilderSupplier supplier = new PipelineDraweeControllerBuilderSupplier(this);
//        SimpleDraweeView.initialize(supplier);
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        bottom_bar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        tvMainTitle = (TextView) findViewById(R.id.main_title);
         
        imgMainPublished = (ImageView) findViewById(R.id.main_published);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        user_icon = (SimpleDraweeView) findViewById(R.id.main_userIcon);
        user_icon.setOnClickListener(this);
        tvMainTitle.setOnClickListener(this);
        imgMainPublished.setOnClickListener(this);

        //获取头布局文件以及里边的控件
        headerView = navigationView.getHeaderView(0);
        headerUserIcon = (SimpleDraweeView) headerView.findViewById(R.id.header_userIcon);
    }

    @Override
    protected void initDatas() {
        setBottomBar();
        //设置用户头像
        Uri uri = Uri.parse("http://img2-ak.lst.fm/i/u/avatar300s/db40b6dd8f8a76d761785ff4d5f7281e.jpg");
        user_icon.setImageURI(uri);
        headerUserIcon.setImageURI(uri);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    //我的关注
                    case R.id.menu_favorite:
                        Toast.makeText(MainActivity.this,"我的关注",Toast.LENGTH_SHORT).show();
                        break;
                    //我的收藏
                    case R.id.menu_wallet:
                        Toast.makeText(MainActivity.this,"我的收藏",Toast.LENGTH_SHORT).show();
                        break;
                    //搜索好友
                    case R.id.menu_firends:
                        Toast.makeText(MainActivity.this,"搜索好友",Toast.LENGTH_SHORT).show();
                        break;
                    //消息通知
                    case R.id.menu_message:
                        Toast.makeText(MainActivity.this,"消息通知",Toast.LENGTH_SHORT).show();
                        break;
                    //我的作品
                    case R.id.menu_myvideo:
                        Toast.makeText(MainActivity.this,"我的作品",Toast.LENGTH_SHORT).show();
                        break;
                    //设置
                    case R.id.menu_settings:
                        Toast.makeText(MainActivity.this,"设置",Toast.LENGTH_SHORT).show();
                        break;



                }

                return true;
            }
        });


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            //用户头像
            case R.id.main_userIcon:


                break;
            //发表
            case R.id.main_published:

                break;



        }

    }

    //设置bar相关
    private void setBottomBar() {

        navigationView.setItemIconTintList(null);

        BadgeItem badgeItem = new BadgeItem();
        badgeItem.setHideOnSelect(false)
                .setText("10")
                .setBackgroundColorResource(R.color.orange)
                .setBorderWidth(0);

        setDefaultFragment();
        bottom_bar.setMode(BottomNavigationBar.MODE_FIXED);
//        bottom_bar.setMode(BottomNavigationBar.MODE_SHIFTING);
        //   bottom_bar.setBackgroundStyle(BottomNavigationBar.MODE_SHIFTING);
//        bottom_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottom_bar.setBarBackgroundColor(R.color.blue);//set background color for navigation bar
//        bottom_bar.setInActiveColor(R.color.white);//unSelected icon color
        bottom_bar.addItem(new BottomNavigationItem(R.drawable.icon_one, R.string.tab_one).setActiveColorResource(R.color.green).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.icon_two, R.string.tab_two).setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.icon_three, R.string.tab_three))
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
