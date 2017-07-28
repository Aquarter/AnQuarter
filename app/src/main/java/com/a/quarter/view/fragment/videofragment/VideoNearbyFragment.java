package com.a.quarter.view.fragment.videofragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.base.BaseFragment;
import com.a.quarter.presenter.video.VideoNearbyPresenter;
import com.a.quarter.view.activity.VideoDetailsActivity;
import com.a.quarter.view.adapter.VideoRecyclerAdapter;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/21  19:07
 * <p>
 * 思路：
 */


public class VideoNearbyFragment extends BaseFragment {

    private SwipeRefreshLayout nearby_swiperefresh;
    private RecyclerView nearby_recycler;
    private VideoRecyclerAdapter videoRecyclerAdapter;

    @Override
    public void onsuccess(Object o) {

    }

    @Override
    public void onError(Object o) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new VideoNearbyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_nearby;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        setData();
    }

    private void setData() {
        //设置recycler使用瀑布流
        nearby_recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //设置适配器
        videoRecyclerAdapter = new VideoRecyclerAdapter(getActivity());
        nearby_recycler.setAdapter(videoRecyclerAdapter);
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

    @Override
    protected void initView() {
        nearby_swiperefresh = (SwipeRefreshLayout) getActivity().findViewById(R.id.nearby_swiperefresh);
        nearby_recycler = (RecyclerView) getActivity().findViewById(R.id.nearby_recycler);
    }
}
