package com.qiang.wanandroid.ui.navigation.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qiang.wanandroid.R;

import java.util.List;

/**
 * @author lixiqiang
 * @data：2018/9/13 0013
 */
public class NavigationTitleAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public NavigationTitleAdapter(@Nullable List<String> data) {
        super(R.layout.item_navigation_title, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.tv_navigation_item_title, item);

    }
}
