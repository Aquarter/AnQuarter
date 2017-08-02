package com.a.quarter.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

import com.a.quarter.R;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.qq.QQ;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * Created by qizepu on 2017/8/1.
 *
 *
 */

public class ShareSdkUtils {

    //分享
    public static void showShare(Context context,String title,String titleUrl,String text,String imageUrl,String SiteUrl) {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle(title);
        // titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl(titleUrl);
        // text是分享文本，所有平台都需要这个字段
        oks.setText(text);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(imageUrl);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(context.getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(SiteUrl);
        // 启动分享GUI
        oks.show(context);
    }

    public static void QLogin(Context context){
//添加授权
        Platform platform11 = ShareSDK.getPlatform(QQ.NAME);
//platform11.SSOSetting(true);
        platform11.authorize();
        platform11.showUser(null);//必须要加的要不然不行！这个才是授权的！
        TelephonyManager tm = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        String imi = tm.getDeviceId();
        platform11.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onError(Platform platform11, int arg1, Throwable arg2) {
//弹出失败窗口
            }
            @SuppressLint("SimpleDateFormat") @Override
            public void onComplete(Platform platform11, int arg1, HashMap<String, Object> arg2) {
                System.out.println("登录成功。。。。");
                //成功得到用户信息
                String userId = platform11.getDb().getUserId();
                String userName = platform11.getDb().getUserName();
                String token = platform11.getDb().getToken();
                String userIcon = platform11.getDb().getUserIcon();
                //有效时期
                long expiresTime = platform11.getDb().getExpiresTime();
                SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                System.out.println("用户ID为："+userId);
                System.out.println("用户名称为："+userName);
                System.out.println("token     "+token);
                System.out.println("expiresTime  "+sdf3.format(expiresTime));
                //HttpUties ht=new HttpUties();
                //ht.UplodePhotos(1+"", userId+"", userName+"", token+"", expiresTime+"", imi+"");
            }
            @Override
            public void onCancel(Platform arg0, int arg1) {
            }
        });
    }
}
