package com.a.quarter.view.fragment.videofragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.base.BaseFragment;
import com.a.quarter.presenter.video.VideoPopularPresenter;
import com.a.quarter.view.activity.VideoDetailsActivity;
import com.a.quarter.view.adapter.VideoRecyclerAdapter;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/21  17:25
 * <p>
 * 思路：
 */


public class VideoPopularFragment extends BaseFragment{

    private SwipeRefreshLayout popular_swiperefresh;
    private RecyclerView popular_recycler;
    private VideoRecyclerAdapter videoRecyclerAdapter;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new VideoPopularPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_popular;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        setData();
    }

    @Override
    protected void initView() {
        popular_swiperefresh = (SwipeRefreshLayout) getActivity().findViewById(R.id.popular_swiperefresh);
        popular_recycler = (RecyclerView) getActivity().findViewById(R.id.popular_recycler);
    }

    private void setData() {
        //设置recycler使用瀑布流
        popular_recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //设置适配器
        videoRecyclerAdapter = new VideoRecyclerAdapter(getActivity());
        popular_recycler.setAdapter(videoRecyclerAdapter);
        videoRecyclerAdapter.setOnItemClinckListener(new VideoRecyclerAdapter.OnClickListenerr() {
            @Override
            public void onItemClickListener(View view, int possition) {
                Toast.makeText(mContext, possition + "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), VideoDetailsActivity.class);
                intent.putExtra("text",possition);
                startActivity(intent);
            }

            @Override
            public void onLongItemClickListener(View view, int possition) {

            }
        });
    }

}
