package com.example.admin.cartest.View.Fragment.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.cartest.R;
import com.example.admin.cartest.View.Fragment.Bean.DataChangeBean;
import com.example.admin.cartest.View.Fragment.Bean.DataDataBean;
import com.example.admin.cartest.View.Fragment.Presenter.MyPresenter;
import com.example.admin.cartest.View.Fragment.Presenter.PresenterChange;
import com.example.admin.cartest.View.Fragment.adapter.MyAdapter;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.List;

/**
 * Created by admin on 2018/4/5.
 */

public class fragmentOne extends Fragment implements MyPresenter.PresenterListeren, PresenterChange.PresenterChangeListener {
    private RecyclerView recyclerView;
    private SpringView springView;
    private int num=1;
    private MyAdapter myAdapter;
    private MyPresenter myPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item1,container,false);
        recyclerView = view.findViewById(R.id.recyclerView01);
        springView = view.findViewById(R.id.springView);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        myPresenter = new MyPresenter();
        myPresenter.getData("71","1",this);



        springView.setHeader(new DefaultHeader(getActivity()));
        springView.setFooter(new DefaultFooter(getActivity()));
        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                num=1;
                String s = String.valueOf(num);
                myPresenter.getData("71",s,fragmentOne.this);
                springView.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
                num++;
                String s = String.valueOf(num);
                myPresenter.getData("71",s,fragmentOne.this);
                springView.onFinishFreshAndLoad();

            }
        });
    }

    @Override
    public void success(List<DataDataBean.DataBean> data) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myAdapter = new MyAdapter(getActivity(),data);

        myAdapter.setChangeStatus(new MyAdapter.SetStatus() {
            @Override
            public void getStatus(String status, String id) {
                PresenterChange presenterChange = new PresenterChange(fragmentOne.this);
                presenterChange.getData(status,id);
            }
        });
        recyclerView.setAdapter(myAdapter);

    }

    @Override
    public void failed() {

    }

    @Override
    public void mySuccess(DataChangeBean dataChangeBean) {
        myPresenter.getData("71","1",fragmentOne.this);

        if(dataChangeBean.getCode().equals("0")){
            Toast.makeText(getActivity(),dataChangeBean.getMsg()+"",Toast.LENGTH_SHORT).show();
        }
    }
}
