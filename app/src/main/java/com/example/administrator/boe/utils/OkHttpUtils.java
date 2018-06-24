package com.example.administrator.boe.utils;


import android.content.Context;
import android.media.TimedMetaData;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.IMediaControllerCallback;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OkHttpUtils {
    private static OkHttpUtils okHttpUtils;
    private Context context;
    private static Handler handler;
    private OkHttpClient okHttpClient;

    private OkHttpUtils(final Context context){
       this.context=context;
       handler = new Handler(Looper.getMainLooper()) ;
       initOk();
    }

    //创建ok
    private void initOk() {
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(1000,TimeUnit.MILLISECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();

    }
    public static OkHttpUtils getInstance(Context context){
        if(okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                if(okHttpUtils==null){
                    okHttpUtils=new OkHttpUtils(context);
                }
            }

        }
        return okHttpUtils;
    }

    //get请求
    public void getData(String url, final ICallback iCallback){
        final Request request =  new Request.Builder()
                .url(url)
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {

            private String result;

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    if(response.isSuccessful()){
                        if(response.code()==200){
                            result = response.body().string();
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    iCallback.getData(result);
                                }
                            });


                        }
                    }
            }
        });
    }
    //post请求
        public void  post(String url, Map<String,String>params, final ICallback iCallback){

            FormBody.Builder builder = new FormBody.Builder();
            for(Map.Entry<String,String>stringStringEntry:params.entrySet()){
                builder.add(stringStringEntry.getKey(),stringStringEntry.getValue());
            }
           Request request = new Request.Builder()
                   .url(url)
                   .post(builder.build())
                   .build();
            okHttpClient.newCall(request).enqueue(new Callback() {

                private String result;

                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                        if(response.isSuccessful()){
                            if(response.code()==200){
                                result = response.body().string();
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                    iCallback.getData(result);
                                    }
                                });
                            }
                        }
                }
            });
        }
    public interface ICallback{
        void getData(String result);
    }
}
