package com.a.quarter.view.fragment.recommendfragment;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.a.quarter.R;
import com.a.quarter.base.BaseFragment;
import com.a.quarter.presenter.recommend.RecommendHotPresenter;
import com.a.quarter.view.adapter.FHotRecyclerViewAdapter;
import com.a.quarter.view.iview.recommend.IRecommendHotFragmentView;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qizepu on 2017/7/26.
 *
 * 推荐界面  热门
 */

public class HotFragment extends BaseFragment<RecommendHotPresenter> implements IRecommendHotFragmentView {

    public static final String []RES = new String[]{"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497595598494&di=3cd4f5b04c879b7a2f97fbdd5ac30c72&imgtype=0&src=http%3A%2F%2Fs1.sinaimg.cn%2Fmiddle%2F87ef2a4btad7e87dafec0%26690",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497595688138&di=de810f2b974d801c5dbff4c253fa7bf1&imgtype=0&src=http%3A%2F%2Feasyread.ph.126.net%2FnP8NmwZKbhQHc1QpeCRBeQ%3D%3D%2F7916738806686876056.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497533248156&di=cb44189a06d55c504ee18e1e269c20e9&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201507%2F30%2F20150730163204_A24MX.thumb.700_0.jpeg" };



    private ArrayList<String> urlList = new ArrayList<>();


    private MZBannerView bannerView;
    private SwipeRefreshLayout swip;
    private RecyclerView recycle;
    private ProgressBar progress;
    private LinearLayoutManager linearLayoutManager;
    private FHotRecyclerViewAdapter adapter;
    private List<String> list;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new RecommendHotPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_commend_hot;
    }

    @Override
    protected void initView() {
        bannerView = (MZBannerView) getView().findViewById(R.id.banner);
        swip = (SwipeRefreshLayout) getView().findViewById(R.id.fragment_reconnemd_swip);
        recycle = (RecyclerView) getView().findViewById(R.id.fragment_recommend_recycle);
        progress = (ProgressBar) getView().findViewById(R.id.fragment_recommend_progress);


        //listview
        linearLayoutManager = new LinearLayoutManager(mContext);

        recycle.setLayoutManager(linearLayoutManager);
        recycle.setItemAnimator(new DefaultItemAnimator());
//        recycle.addItemDecoration(new DividerItemDecoration(this,
//                DividerItemDecoration.VERTICAL_LIST));
        recycle.setItemAnimator(new DefaultItemAnimator());
        adapter = new FHotRecyclerViewAdapter(mContext);
        recycle.setAdapter(adapter);

        setData();
    }

    //设置数据
    private void setData(){
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("这是一条测试数据");
        }
        adapter.addData(list);
        adapter.notifyDataSetChanged();

        setBannerData();
    }

    private void setBannerData() {

        //加载 网络上的图片
           urlList.clear();
                for(int i=0;i<RES.length;i++){
                urlList.add(RES[i]);

        }
        // 设置数据
        bannerView.setPages(urlList, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                bannerView.setDelayedTime(3000);
                return new BannerViewHolder();
            }
        });

    }



    public static class BannerViewHolder implements MZViewHolder<String> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }
        //加载网上资源
        @Override
        public void onBind(Context context, int i, String s) {
//            // 数据绑定
//            Uri uri=Uri.parse(s);
//            mImageView.setImageURI(uri);
            x.image().bind(mImageView,s);


        }
        //加载本地图片
//        @Override
//        public void onBind(Context context, int position, Integer data) {
//            // 数据绑定
//            mImageView.setImageResource(data);
//        }
    }

    @Override
    public void onPause() {
        super.onPause();
        bannerView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();

        bannerView.start();
    }
}
