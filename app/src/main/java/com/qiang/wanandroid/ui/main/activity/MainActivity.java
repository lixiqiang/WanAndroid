package com.qiang.wanandroid.ui.main.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.qiang.wanandroid.R;
import com.qiang.wanandroid.base.BaseActivity;
import com.qiang.wanandroid.base.BasePresenter;
import com.qiang.wanandroid.ui.home.fragment.MainHomeFragment;
import com.qiang.wanandroid.ui.navigation.fragment.NavigationFragment;
import com.qiang.wanandroid.ui.system.fragment.SystemFragment;
import com.qiang.wanandroid.utils.TabEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author lixiqiang
 * @data：2018/09/10
 */
public class MainActivity extends BaseActivity {

    public static final String MAIN_TAB_POSITION = "main_tab_position";


    private String[] mTitles = {"首页", "知识体系", "导航", "项目"};
    private int[] mIconUnselectIds = {
            R.drawable.home, R.drawable.system, R.drawable.navigation, R.drawable.project};
    private int[] mIconSelectIds = {
            R.drawable.home_selected, R.drawable.system_selected, R.drawable.navigation_selected, R.drawable.project_selected};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();


    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.iv_toolbar_me)
    ImageView ivToolbarMe;
    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.ll_left)
    LinearLayout llLeft;
    @BindView(R.id.main_fragment)
    FrameLayout mainFragment;
    @BindView(R.id.main_tab)
    CommonTabLayout mainTab;

    MainHomeFragment mainHomeFragment;

    SystemFragment mainSystemFragment;

    NavigationFragment mainNavigationFragment;

    MainHomeFragment mainProjectFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTab();
        initFragment(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MAIN_TAB_POSITION, mainTab.getCurrentTab());
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        // 关闭手势滑动
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }


    @Override
    public void initData() {
    }

    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mainTab.setTabData(mTabEntities);
        mainTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                switchFragment(position);
                tvToolbarTitle.setText(mTitles[position]);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    private void initFragment(Bundle savedInstanceState) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        int currentTabPosition = 0;
        if (savedInstanceState != null) {
            mainHomeFragment = (MainHomeFragment) getSupportFragmentManager().findFragmentByTag("mainHomeFragment");
            mainSystemFragment = (SystemFragment) getSupportFragmentManager().findFragmentByTag("mainSystemFragment");
            mainNavigationFragment = (NavigationFragment) getSupportFragmentManager().findFragmentByTag("mainNavigationFragment");
            mainProjectFragment = (MainHomeFragment) getSupportFragmentManager().findFragmentByTag("mainProjectFragment");
            currentTabPosition = savedInstanceState.getInt(MAIN_TAB_POSITION);
        } else {
            mainHomeFragment = MainHomeFragment.newInstance("");
            mainSystemFragment = SystemFragment.newInstance("");
            mainNavigationFragment = NavigationFragment.newInstance("");
            mainProjectFragment = MainHomeFragment.newInstance("");

            fragmentTransaction.add(R.id.main_fragment, mainHomeFragment, "mainHomeFragment");
            fragmentTransaction.add(R.id.main_fragment, mainSystemFragment, "mainSystemFragment");
            fragmentTransaction.add(R.id.main_fragment, mainNavigationFragment, "mainNavigationFragment");
            fragmentTransaction.add(R.id.main_fragment, mainProjectFragment, "mainProjectFragment");
        }

        fragmentTransaction.commit();
        switchFragment(currentTabPosition);

    }

    private void switchFragment(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                fragmentTransaction.hide(mainSystemFragment);
                fragmentTransaction.hide(mainNavigationFragment);
                fragmentTransaction.hide(mainProjectFragment);
                fragmentTransaction.show(mainHomeFragment);
                fragmentTransaction.commitAllowingStateLoss();
                break;
            case 1:

                fragmentTransaction.hide(mainHomeFragment);
                fragmentTransaction.hide(mainNavigationFragment);
                fragmentTransaction.hide(mainProjectFragment);
                fragmentTransaction.show(mainSystemFragment);
                fragmentTransaction.commitAllowingStateLoss();
                break;
            case 2:
                fragmentTransaction.hide(mainHomeFragment);
                fragmentTransaction.hide(mainSystemFragment);
                fragmentTransaction.hide(mainProjectFragment);
                fragmentTransaction.show(mainNavigationFragment);
                fragmentTransaction.commitAllowingStateLoss();
                break;
            case 3:
                fragmentTransaction.hide(mainHomeFragment);
                fragmentTransaction.hide(mainSystemFragment);
                fragmentTransaction.hide(mainNavigationFragment);
                fragmentTransaction.show(mainProjectFragment);
                fragmentTransaction.commitAllowingStateLoss();
                break;
            default:
                break;
        }


    }


    @OnClick({R.id.iv_toolbar_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_me:
                if (!drawerLayout.isDrawerOpen(llLeft)) {
                    drawerLayout.openDrawer(llLeft);
                }
                break;
        }
    }
}
