package com.example.admin.cartest.View.Fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by admin on 2018/4/5.
 */

public class MyViewpagerAdapter extends FragmentPagerAdapter {
    List<Fragment> data;
    public MyViewpagerAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        this.data=data;

    }


    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
