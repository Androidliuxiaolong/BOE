package com.example.administrator.boe.model;

import android.content.Context;
import android.util.Log;

import com.example.administrator.boe.bean.BannerBean;
import com.example.administrator.boe.bean.RecyclerBean;
import com.example.administrator.boe.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/20.
 */

public class BannerModel {

    private Context context;
    private String url="https://www.zhaoapi.cn/ad/getAd";
    private String url1="https://www.zhaoapi.cn/product/getCatagory";
    public void getDateUrl(final ModelIf modelIf) {
        final Map<String, String> map=new HashMap<>();
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance(context);
        okHttpUtils.post(url, map, new OkHttpUtils.ICallback() {
            @Override
            public void getData(String result) {
                Gson gson = new Gson();
                BannerBean bannerBean = gson.fromJson(result, BannerBean.class);
                modelIf.BannerSuccess(bannerBean);
            }
        });

    }
    public void getUrl(final ModelIf2 modelIf2) {
        final Map<String, String> map=new HashMap<>();
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance(context);
        okHttpUtils.post(url1, map, new OkHttpUtils.ICallback() {
            @Override
            public void getData(String result) {
                Gson gson = new Gson();
                RecyclerBean recyclerBean = gson.fromJson(result, RecyclerBean.class);
                modelIf2.JiuSuccess(recyclerBean);
            }
        });

    }
    public void getDate(final ModelIf3 modelIf3) {
        final Map<String, String> map=new HashMap<>();
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance(context);
        okHttpUtils.post(url, map, new OkHttpUtils.ICallback() {
            @Override
            public void getData(String result) {
                Gson gson = new Gson();
                BannerBean bannerBean = gson.fromJson(result, BannerBean.class);
                modelIf3.BannerSuccess2(bannerBean);
            }
        });

    }
    public void getDateT(final ModelIf4 modelIf4) {
        final Map<String, String> map=new HashMap<>();
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance(context);
        okHttpUtils.post(url, map, new OkHttpUtils.ICallback() {
            @Override
            public void getData(String result) {
                Gson gson = new Gson();
                BannerBean bannerBean = gson.fromJson(result, BannerBean.class);
                modelIf4.recyclerSuccess4(bannerBean);
            }
        });

    }
    public interface ModelIf{
        void BannerSuccess(BannerBean bannerBean);

    }
    public interface ModelIf2{
        void JiuSuccess(RecyclerBean recyclerBean);
    }
    public interface ModelIf3{
        void BannerSuccess2(BannerBean bannerBean);
    }
    public interface ModelIf4{
        void recyclerSuccess4(BannerBean bannerBean);
    }
}
