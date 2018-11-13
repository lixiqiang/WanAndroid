package com.qiang.wanandroid.ui.project.view;

import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.base.BaseView;
import com.qiang.wanandroid.ui.project.model.ProjectItemBean;

import java.util.List;

/**
 * @author lixiqiang
 * @data：2018/11/5 0005
 */
public interface ProjectView extends BaseView {


    void getProjectSuccess(BaseResponse<List<ProjectItemBean>> list);

    void getProjectFail();
}
