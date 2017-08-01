package com.a.quarter.view.activity;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.base.BaseActivity;
import com.a.quarter.presenter.UploadPresenter;
import com.a.quarter.utils.TUtil;
import com.a.quarter.view.iview.IUploadView;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * @类作用:  创作类，
 * @author: 王鹏智
 * @Date: 2017/7/31  10:34
 * <p>
 * 思路：
 */


public class UploadActivity extends BaseActivity<UploadPresenter> implements IUploadView,View.OnClickListener{
    private TextView upload_back;
    private SimpleDraweeView uplode_video;
    private SimpleDraweeView uplode_joke;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new UploadPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_upload;
    }

    @Override
    protected void initView() {
        upload_back = (TextView) findViewById(R.id.upload_back);
        upload_back.setOnClickListener(this);
        uplode_video = (SimpleDraweeView) findViewById(R.id.upload_video);
        uplode_joke = (SimpleDraweeView) findViewById(R.id.upload_joke);
        uplode_video.setOnClickListener(this);
        uplode_joke.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
        setImageData();
    }

    private void setImageData() {
        Uri login_uri = Uri.parse("res://" + mContext.getPackageName() + "/" + R.mipmap.btn_upload_video);
        Uri login_uri2 = Uri.parse("res://" + mContext.getPackageName() + "/" + R.mipmap.btn_upload_joke);
        uplode_video.setImageURI(login_uri);
        uplode_joke.setImageURI(login_uri2);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.upload_back:
                    this.finish();
                break;
            //上传视频
            case R.id.upload_video:
                TUtil.showShort(this,"待开发");
                break;
            //上传段子
            case R.id.upload_joke:
                TUtil.showShort(this,"待开发");
                break;
        }
    }
}
