package com.example.admin.cartest.View.Fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.admin.cartest.R;
import com.example.admin.cartest.View.Fragment.Fragment.fragmentFour;
import com.example.admin.cartest.View.Fragment.Fragment.fragmentOne;
import com.example.admin.cartest.View.Fragment.Fragment.fragmentThree;
import com.example.admin.cartest.View.Fragment.Fragment.fragmentTwo;
import com.example.admin.cartest.View.Fragment.Presenter.MyPresenter;
import com.example.admin.cartest.View.Fragment.adapter.MyViewpagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class XiaDanActivity extends AppCompatActivity {
    /**
     * 待支付
     */
    private RadioButton mRaido01;
    /**
     * 已支付
     */
    private RadioButton mRaido02;
    /**
     * 已取消
     */
    private RadioButton mRaido03;
    private RadioGroup mGroup;
    private ViewPager mViewpager;
    private MyPresenter myPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xia_dan);
        initView();
        myPresenter = new MyPresenter();

        mGroup.setOnCheckedChangeListener(myPresenter);
        List<Fragment> list = new ArrayList<>();
        list.add(new fragmentOne());
        list.add(new fragmentTwo());
        list.add(new fragmentThree());
        list.add(new fragmentFour());

        myPresenter.setToast(new MyPresenter.ContentListeren() {
            @Override
            public void setContent(int i) {
                switch (i){
                    default:break;
                    case 0:
                        mViewpager.setCurrentItem(0,true);

                        break;
                    case 1:
                        mViewpager.setCurrentItem(1,true);

                        break;
                    case 2:
                        mViewpager.setCurrentItem(2,true);

                        break;
                    case 3:
                        mViewpager.setCurrentItem(3,true);

                        break;
                }
            }
        });
        MyViewpagerAdapter myViewpagerAdapter = new MyViewpagerAdapter(getSupportFragmentManager(),list);


        mViewpager.setAdapter(myViewpagerAdapter);
    }

    private void initView() {
        mRaido01 = findViewById(R.id.raido01);
        mRaido02 =  findViewById(R.id.raido02);
        mRaido03 = findViewById(R.id.raido03);
        mGroup =  findViewById(R.id.group);
        mViewpager =  findViewById(R.id.viewpager);
    }

}
