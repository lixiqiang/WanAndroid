package com.qiang.wanandroid.ui.system.view;

import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.base.BaseView;
import com.qiang.wanandroid.ui.system.model.SystemChildren;

import java.util.List;

/**
 * @author lixiqiang
 * @data：2018/9/10 0010
 */
public interface SystemFragmentView extends BaseView {


    public void getSystemListSuccess(BaseResponse<List<SystemChildren>> listBaseResponse);

    public void getSystemListFail();
}
