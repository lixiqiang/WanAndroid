package com.qiang.wanandroid.base;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiqiang
 * @data：2018/8/16 0016
 * 需要处理有很多页，并且数据动态性较大、占用内存较多的情况使用改Adapter
 */
public class BaseFragmentStateAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragmentList = new ArrayList<>();

    List<String> titleList;


    public BaseFragmentStateAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    public void setTitleList(List<String> titles) {
        this.titleList = titles;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (titleList != null) {
            return titleList.get(position);
        }
        return " ";
    }
}
