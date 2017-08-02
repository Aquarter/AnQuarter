package com.a.quarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.video.VideoDetailsPresenter;
import com.a.quarter.view.iview.video.IVideoDetailsView;

import media.AndroidMediaController;
import media.IjkVideoView;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/28  20:10
 * <p>
 * 思路：
 * 视频详情页
 */


public class VideoDetailsActivity extends BaseActivity<VideoDetailsPresenter> implements IVideoDetailsView,View.OnClickListener {
    private ImageView inculdeTitleBack;
//    private TextView videoDetailsText;
    private IjkVideoView mVideoView;
    private AndroidMediaController mMediaController;
    private boolean mBackPressed;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new VideoDetailsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_details;
    }

    @Override
    protected void initView() {

        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        mMediaController = new AndroidMediaController(this, false);
        mVideoView = (IjkVideoView) findViewById(R.id.MyIjkPlayer);
        mVideoView.setMediaController(mMediaController);

        //播放本地
//        mVideoView.setVideoURI("");
        //播放网络
        mVideoView.setVideoPath("http://baobab.kaiyanapp.com/api/v1/playUrl?vid=22131&editionType=default&source=ucloud");
        mVideoView.start();


        inculdeTitleBack = (ImageView) findViewById(R.id.inculde_title_back);
        inculdeTitleBack.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        int text = this.getIntent().getIntExtra("text",0);
        initView();
        initDatas();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.inculde_title_back:
                finish();
                overridePendingTransition(R.anim.right_in,R.anim.right_out);
                break;
        }

    }



    //onBackPressed() 和 onStop()都是释放Ijkplayer资源
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mBackPressed=true;
    }
    @Override
    protected void onStop() {
        super.onStop();
        //释放Ijkplayer资源
        if (mBackPressed || !mVideoView.isBackgroundPlayEnabled()) {
            mVideoView.stopPlayback();
            mVideoView.release(true);
            mVideoView.stopBackgroundPlay();
        } else {
            mVideoView.enterBackground();
        }
        IjkMediaPlayer.native_profileEnd();
    }
}
