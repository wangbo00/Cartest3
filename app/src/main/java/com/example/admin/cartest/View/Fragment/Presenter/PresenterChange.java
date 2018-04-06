package com.example.admin.cartest.View.Fragment.Presenter;

import android.os.Handler;
import android.os.Looper;


import com.example.admin.cartest.View.Fragment.Bean.DataChangeBean;
import com.example.admin.cartest.View.Fragment.Moudle.ModuleChange;
import com.google.gson.Gson;

/**
 * Created by admin on 2018/4/5.
 */

public class PresenterChange {
    private ModuleChange moduleChange = new ModuleChange();
    PresenterChangeListener presenterChangeListener;

    public PresenterChange(PresenterChangeListener presenterChangeListener) {
        this.presenterChangeListener = presenterChangeListener;
    }

    private Handler handler = new Handler(Looper.getMainLooper());
    public void getData(String status,String id){
        moduleChange.getData(status, id, new ModuleChange.ModuleChangeListener() {
            @Override
            public void success(final String s) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        DataChangeBean dataChangeBean = new Gson().fromJson(s, DataChangeBean.class);
                        if(presenterChangeListener !=null){

                            presenterChangeListener.mySuccess(dataChangeBean);

                        }
                    }
                });

            }
        });
    }
    public interface PresenterChangeListener{
        void mySuccess(DataChangeBean dataChangeBean);
    }
}
