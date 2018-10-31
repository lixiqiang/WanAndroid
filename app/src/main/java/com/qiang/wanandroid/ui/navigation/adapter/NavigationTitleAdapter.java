package com.qiang.wanandroid.ui.navigation.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qiang.wanandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiqiang
 * @data：2018/9/13 0013
 */
public class NavigationTitleAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    List<Boolean> isSelected;

    public NavigationTitleAdapter(@Nullable List<String> data) {
        super(R.layout.item_navigation_title, data);
        isSelected = new ArrayList<>();

    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        if (item != null) {

            helper.setText(R.id.tv_navigation_item_title, item);
            if (isSelected.size() > 0) {

                if (isSelected.get(helper.getAdapterPosition())) {
                    helper.getView(R.id.tv_navigation_item_title).setSelected(true);
                } else {
                    helper.getView(R.id.tv_navigation_item_title).setSelected(false);
                }
            }
        }


    }


    public void setSelected(int position) {

        isSelected.clear();

        for (int i = 0; i < getData().size(); i++) {
            isSelected.add(i, false);
        }
        isSelected.set(position, true);
        notifyDataSetChanged();

    }

    @Override
    public void setNewData(@Nullable List<String> data) {
        super.setNewData(data);

        isSelected.clear();
        for (int i = 0; i < getData().size(); i++) {
            isSelected.add(i, false);
        }
        isSelected.set(0, true);
        notifyDataSetChanged();
    }
}
