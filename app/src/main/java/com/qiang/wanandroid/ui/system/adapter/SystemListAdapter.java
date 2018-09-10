package com.qiang.wanandroid.ui.system.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qiang.wanandroid.R;
import com.qiang.wanandroid.ui.home.model.ArticleListBean;
import com.qiang.wanandroid.ui.system.model.SystemChildren;

import java.util.List;

/**
 * @auther lixiqiang
 * @data：2018/9/10 0010
 */
public class SystemListAdapter extends BaseQuickAdapter<SystemChildren, BaseViewHolder> {

    public SystemListAdapter(@Nullable List<SystemChildren> data) {
        super(R.layout.item_system_article, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, SystemChildren item) {
        helper.setText(R.id.tv_system_title, item.getName());

        String childTitle = "";
        for (SystemChildren.ChildrenBean childrenBean : item.getChildren()) {
            childTitle += childrenBean.getName() + "  ";
        }
        helper.setText(R.id.tv_system_child_title, childTitle);

    }
}
