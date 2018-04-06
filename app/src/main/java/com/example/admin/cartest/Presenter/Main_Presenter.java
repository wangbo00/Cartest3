package com.example.admin.cartest.Presenter;

import com.example.admin.cartest.Moudle.Bean.XQDataBean;
import com.example.admin.cartest.Moudle.Main_Model;
import com.example.admin.cartest.View.Fragment.Main_View;

/**
 * Created by admin on 2018/4/5.
 */

public class Main_Presenter implements Main_P {
    private Main_Model main_model;
    Main_View main_view;

    public Main_Presenter(Main_View main_view) {
        this.main_view = main_view;
        main_model = new Main_Model(this);
    }
    public void getDataUrl() {
        main_model.getDataUrl();
    }

    @Override
    public void success(XQDataBean xqDataBean) {
        main_view.success(xqDataBean);
    }
}
