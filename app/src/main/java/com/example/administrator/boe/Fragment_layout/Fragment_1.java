package com.example.administrator.boe.Fragment_layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.boe.R;
import com.example.administrator.boe.adapter.MyAdapter;
import com.example.administrator.boe.adapter.MyAdapter2;
import com.example.administrator.boe.adapter.MyAdapter3;
import com.example.administrator.boe.bean.BannerBean;
import com.example.administrator.boe.bean.RecyclerBean;
import com.example.administrator.boe.presenter.BannerPresenter;
import com.example.administrator.boe.view.BannerView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */

public class Fragment_1 extends Fragment implements BannerView{
    private static final String TAG = "Fragment_1";
    private XBanner xbanner;
   // private List<String>rlist = new ArrayList<>();
    private BannerView bannerView;
    private List<String> imageUrl;
    private RecyclerView recyclerView;
    private ImageView imageView;
    private BannerPresenter bannerPresenter;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        xbanner = view.findViewById(R.id.xbanner);
        recyclerView = view.findViewById(R.id.recyclerview);
        imageView = view.findViewById(R.id.imageView);
        recyclerView2 = view.findViewById(R.id.recyclerView2);
        recyclerView3 = view.findViewById(R.id.recyclerView3);
        bannerPresenter = new BannerPresenter(this);
        bannerPresenter.Home();
            return view;
    }

    @Override
    public void BannerSuccess(final BannerBean bannerBean) {
        final List<BannerBean.DataBean> list = bannerBean.getData();
        xbanner.setData(list,null);
        xbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(list.get(position).getIcon()).into(imageView);
            }
        });
        xbanner.setPageTransformer(Transformer.Default);
    }

    @Override
    public void RecyclerSuccess(RecyclerBean recyclerBean) {
        final List<RecyclerBean.DataBean> rlist; rlist = recyclerBean.getData();
        final MyAdapter myAdapter = new MyAdapter(rlist,getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                rlist.remove(position);
                myAdapter.notifyDataSetChanged();

            }
        });
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

       // recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void RecyclerSuccess2(BannerBean bannerBean) {
        BannerBean.MiaoshaBean miaosha = bannerBean.getMiaosha();
        final List<BannerBean.MiaoshaBean.ListBeanX> rlist = miaosha.getList();
        final MyAdapter2 myAdapter2 = new MyAdapter2(rlist,getContext());
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        recyclerView2.setLayoutManager(linearLayoutManager2);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity(), 1);
        gridLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(gridLayoutManager2);
//        myAdapter2.setOnItemClickListener(new MyAdapter2.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                rlist.remove(position);
//                myAdapter2.notifyDataSetChanged();
//
//            }
//        });
        recyclerView2.setAdapter(myAdapter2);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());

       // recyclerView2.setLayoutManager(linearLayoutManager2);
    }

    @Override
    public void RecyclerSuccess3(BannerBean bannerBean) {
        BannerBean.TuijianBean tuijian = bannerBean.getTuijian();
        List<BannerBean.TuijianBean.ListBean> tuijianList = tuijian.getList();
        final MyAdapter3 myAdapter3 = new MyAdapter3(tuijianList,getContext());
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getActivity());
        recyclerView3.setLayoutManager(linearLayoutManager3);
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView3.setAdapter(myAdapter3);
        recyclerView3.setItemAnimator(new DefaultItemAnimator());
         recyclerView3.setLayoutManager(linearLayoutManager3);
    }
}
