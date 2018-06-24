package com.example.administrator.boe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.boe.R;
import com.example.administrator.boe.bean.BannerBean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/21.
 */

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder> {

    //List<String> list=new ArrayList<>();
    private List<BannerBean.TuijianBean.ListBean> tuijianList;
    private Context context;
    public MyAdapter3(List<BannerBean.TuijianBean.ListBean> tuijianList, Context context){
        this.tuijianList=tuijianList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itmeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tuijian_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itmeView);
        return myViewHolder;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{


        private final ImageView image_one;

        public MyViewHolder(View itemView) {
            super(itemView);
            image_one = itemView.findViewById(R.id.image_two);
        }
    }

    @Override
    public int getItemCount() {
        return tuijianList == null?0:tuijianList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.image_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null){
                    onItemClickListener.onItemClick(v,position);
                }
            }
        });

        Glide.with(context).load(tuijianList.get(position).getImages()).into(holder.image_one);

    }


    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener  =  onItemClickListener;

    }
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
