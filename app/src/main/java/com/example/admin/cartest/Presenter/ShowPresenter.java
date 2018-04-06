package com.example.admin.cartest.Presenter;

import com.example.admin.cartest.Moudle.Bean.MyCartBean;
import com.example.admin.cartest.Moudle.ShowModel;
import com.example.admin.cartest.View.Fragment.ShowVImp;

/**
 * Created by admin on 2018/4/5.
 */

public class ShowPresenter implements ShowPImp{

    ShowVImp showVImp;

    public ShowPresenter(ShowVImp showVImp) {
        this.showVImp = showVImp;
    }

    /*
     * 调model层方法
     * */
    public void getData(String base_url) {
        ShowModel sm = new ShowModel(this);
        sm.getData(base_url);

    }

    @Override
    public void onSuccess(MyCartBean myCartBean) {
        showVImp.onSuccess(myCartBean);
    }

    @Override
    public void onError() {

    }
}
