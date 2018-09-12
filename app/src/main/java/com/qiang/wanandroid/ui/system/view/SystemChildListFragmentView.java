package com.qiang.wanandroid.ui.system.view;

import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.base.BaseView;
import com.qiang.wanandroid.ui.system.model.SystemChildList;

/**
 * @author lixiqiang
 * @data：2018/9/12 0012
 */
public interface SystemChildListFragmentView extends BaseView {

    public void getSystemChildListSuccess(BaseResponse<SystemChildList> response);

    public void getSystemChildListFail();

}
