package com.example.administrator.boe.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.boe.R;
import com.example.administrator.boe.bean.RecyclerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/21.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    //List<String> list=new ArrayList<>();
    private List<RecyclerBean.DataBean> list;
    private Context context;
    public MyAdapter(List<RecyclerBean.DataBean> list,Context context){
        this.list=list;
        this.context=context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itmeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itmeView);
        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return list == null?0:list.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.item_recycler.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemClickListener!=null){
                        onItemClickListener.onItemClick(v,position);
                    }
                }
            });
            holder.item_recycler.setText(list.get(position).getName());
         //   holder.recyclerImage.setImageDrawable(Drawable.createFromPath(list.get(position).getIcon()));
            Glide.with(context).load(list.get(position).getIcon()).into(holder.recyclerImage);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView item_recycler;
        private final ImageView recyclerImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_recycler = itemView.findViewById(R.id.item_recycler);
            recyclerImage = itemView.findViewById(R.id.recyclerImage);
        }
    }
    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener  =  onItemClickListener;

    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
}
