package com.a.quarter.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.a.quarter.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/26  15:26
 * <p>
 * 思路：
 */


public class VideoRecyclerAdapter extends  RecyclerView.Adapter<VideoRecyclerAdapter.MyViewHolder>  {
    private Context mContext;
    List<String> list = new ArrayList<>();

    public VideoRecyclerAdapter(Context context){
        this.mContext = context;
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_video_recycler,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        // 如果设置了回调，则设置点击事件
        if (monClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    monClickListener.onItemClickListener(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int poss = holder.getLayoutPosition();
                    monClickListener.onLongItemClickListener(holder.itemView,poss);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



//    public void addListData(List<NewsDataBean.ResultBean.DataBean> data) {
//        list.addAll(data);
//    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image_1;

        public MyViewHolder(View itemView) {
            super(itemView);
            image_1 = (ImageView) itemView.findViewById(R.id.video_recycler_image);
        }

    }

    //定义接口  条目点击事件  跟  长按条目点击事件
    public interface OnClickListenerr{
        void onItemClickListener(View view,int possition);
        void onLongItemClickListener(View view,int possition);
    }

    private OnClickListenerr monClickListener;

    public void setOnItemClinckListener(OnClickListenerr onClickListener){
        this.monClickListener = onClickListener;
    }
}
