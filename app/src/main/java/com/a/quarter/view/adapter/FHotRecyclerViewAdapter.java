package com.a.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.a.quarter.R;
import com.facebook.drawee.view.SimpleDraweeView;

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
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.text.setText(mList.get(position));


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
        return mList.size();
    }

    public void addData(List<String> list) {
        if (list != null){
            mList.addAll(list);
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


    public class MyViewHolder extends RecyclerView.ViewHolder {


        private final SimpleDraweeView imageHead;
        private final SimpleDraweeView image;
        private final TextView username;
        private final TextView data;
        private final TextView text;
        private final ListView lv;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageHead = (SimpleDraweeView) itemView.findViewById(R.id.fragment_hot_imagehead);
            image = (SimpleDraweeView) itemView.findViewById(R.id.fragment_hot_image);
            username = (TextView) itemView.findViewById(R.id.fragment_hot_username);
            data = (TextView) itemView.findViewById(R.id.fragment_hot_date);
            text = (TextView) itemView.findViewById(R.id.fragment_hot_text);
            lv = (ListView) itemView.findViewById(R.id.fragment_hot_lv);
        }
    }
}
