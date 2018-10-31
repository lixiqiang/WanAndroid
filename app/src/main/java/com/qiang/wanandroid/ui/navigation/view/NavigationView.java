package com.qiang.wanandroid.ui.navigation.view;

import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.base.BaseView;
import com.qiang.wanandroid.ui.navigation.model.Articles;

import java.util.List;

/**
 * @author lixiqiang
 * @data：2018/9/28 0028
 */
public interface NavigationView extends BaseView {


    void getNavigationSuccess(BaseResponse<List<Articles>> listBaseResponse);

    void getNavigationFail();
}
