package com.example.admin.cartest.Util;

import android.os.Environment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by admin on 2018/4/5.
 */

public class RetrofitHelper {
    public static OkHttpClient okHttpClient;
    public static ApiService apiService;

    static {
        getOkHttpClient();
    }

    public static OkHttpClient getOkHttpClient(){
        if(okHttpClient == null){
            synchronized (OkHttpClient.class) {
                if(okHttpClient == null){
                    File fileDir = new File(Environment.getExternalStorageDirectory(), "cache");
                    long fileSize = 10 * 1024 * 1024;
                    okHttpClient = new OkHttpClient.Builder()
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .readTimeout(15, TimeUnit.SECONDS)
                            .writeTimeout(15, TimeUnit.SECONDS)
                            .cache(new Cache(fileDir, fileSize))
                            .build();
                }
            }
        }
        return okHttpClient;
    }

    public static ApiService getApiService(String url){
        if(apiService == null){
            synchronized (OkHttpClient.class) {
                apiService = createApiService(ApiService.class,url);

            }
        }
        return apiService;
    }

    private static <T>T createApiService(Class<T> tClass,String url) {
        T t = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(tClass);
        return t;
    }


}
