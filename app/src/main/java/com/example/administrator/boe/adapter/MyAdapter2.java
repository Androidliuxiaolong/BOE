package com.example.administrator.boe.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.boe.R;
import com.example.administrator.boe.bean.BannerBean;
import com.example.administrator.boe.bean.RecyclerBean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/21.
 */

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {

    //List<String> list=new ArrayList<>();
    private List<BannerBean.MiaoshaBean.ListBeanX> list;
    private Context context;
    public MyAdapter2( List<BannerBean.MiaoshaBean.ListBeanX> list, Context context){
        this.list=list;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itmeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.miaosha_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itmeView);
        return myViewHolder;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{


        private final ImageView image_one;

        public MyViewHolder(View itemView) {
            super(itemView);
            image_one = itemView.findViewById(R.id.image_one);
        }
    }

    @Override
    public int getItemCount() {
        return list == null?0:list.size();
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
        String[] split1 = list.get(position).getImages().split("\\|");
        Glide.with(context).load(split1[0]).into(holder.image_one);

    }


    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener  =  onItemClickListener;

    }
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
