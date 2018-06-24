package com.example.administrator.boe.presenter;
import com.example.administrator.boe.bean.BannerBean;
import com.example.administrator.boe.bean.RecyclerBean;
import com.example.administrator.boe.model.BannerModel;
import com.example.administrator.boe.view.BannerView;

/**
 * Created by Administrator on 2018/6/20.
 */

public class BannerPresenter{
    private BannerView mbannerView;
    private BannerModel bannerModel;
   public BannerPresenter(BannerView bannerView){
        this.mbannerView = bannerView;
        bannerModel = new BannerModel();
   }
   public void Home(){
       bannerModel.getDateUrl(new BannerModel.ModelIf() {
           @Override
           public void BannerSuccess(BannerBean bannerBean) {
               mbannerView.BannerSuccess(bannerBean);
           }
       });
       bannerModel.getUrl(new BannerModel.ModelIf2() {
           @Override
           public void JiuSuccess(RecyclerBean recyclerBean) {
               mbannerView.RecyclerSuccess(recyclerBean);
           }
       });
       bannerModel.getDate(new BannerModel.ModelIf3() {
           @Override
           public void BannerSuccess2(BannerBean bannerBean) {
               mbannerView.RecyclerSuccess2(bannerBean);
           }
       });
       bannerModel.getDateT(new BannerModel.ModelIf4() {
           @Override
           public void recyclerSuccess4(BannerBean bannerBean) {
               mbannerView.RecyclerSuccess3(bannerBean);
           }
       });
   }

}
