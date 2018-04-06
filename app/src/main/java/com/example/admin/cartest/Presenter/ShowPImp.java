package com.example.admin.cartest.Presenter;

import com.example.admin.cartest.Moudle.Bean.MyCartBean;

/**
 * Created by admin on 2018/4/5.
 */

public interface ShowPImp {
    void onSuccess(MyCartBean myCartBean);
    void onError();

}
