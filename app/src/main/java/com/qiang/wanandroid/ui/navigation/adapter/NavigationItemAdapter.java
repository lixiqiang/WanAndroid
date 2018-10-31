package com.qiang.wanandroid.ui.navigation.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qiang.wanandroid.R;

import java.util.List;

/**
 * @author lixiqiang
 * @data：2018/10/31 0031
 */
public class NavigationItemAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public NavigationItemAdapter( @Nullable List<String> data) {
        super(R.layout.item_navigation_content, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if (item != null) {
            helper.setText(R.id.content, item);
        }
    }
}
