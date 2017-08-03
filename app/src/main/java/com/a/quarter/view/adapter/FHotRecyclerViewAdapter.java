package com.a.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.a.quarter.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qizepu on 2017/8/3.
 */

public class FHotRecyclerViewAdapter extends RecyclerView.Adapter<FHotRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    List<String> mList = new ArrayList<>();
    public FHotRecyclerViewAdapter(Context mContext) {
        context = mContext;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = View.inflate(context, R.layout.fragment_hot_recycle_item,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(List<String> list) {
        if (list != null){
            mList.addAll(list);
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View itemView) {
            super(itemView);

            
        }
    }
}
