package com.qiang.wanandroid.ui.project.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qiang.wanandroid.ui.project.model.ProjectItemBean;

import java.util.List;

/**
 * @author lixiqiang
 * @data：2018/11/5 0005
 */
public class ProjectAdapter extends BaseQuickAdapter<ProjectItemBean,BaseViewHolder> {

    public ProjectAdapter(int layoutResId, @Nullable List<ProjectItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProjectItemBean item) {

    }
}
