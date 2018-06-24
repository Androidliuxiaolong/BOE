package com.example.administrator.boe.view;

import android.support.v7.widget.RecyclerView;

import com.example.administrator.boe.bean.BannerBean;
import com.example.administrator.boe.bean.RecyclerBean;

/**
 * Created by Administrator on 2018/6/20.
 */

public interface BannerView {
    void BannerSuccess(BannerBean bannerBean);
    void RecyclerSuccess(RecyclerBean recyclerBean);
    void RecyclerSuccess2(BannerBean bannerBean);
    void RecyclerSuccess3(BannerBean bannerBean);
}
