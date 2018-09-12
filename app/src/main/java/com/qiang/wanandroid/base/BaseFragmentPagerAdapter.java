package com.qiang.wanandroid.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiqiang
 * @data：2018/8/15
 * 该类内的每一个生成的 Fragment 都将保存在内存之中，适用于相对静态，数量也比较少的页
 */

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList = new ArrayList<>();

    public BaseFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragmentListl) {
        super(fm);
        this.fragmentList = fragmentListl;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}
