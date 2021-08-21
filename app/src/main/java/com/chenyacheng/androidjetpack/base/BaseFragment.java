package com.chenyacheng.androidjetpack.base;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author chenyacheng
 * @date 2021/07/14
 */
public abstract class BaseFragment extends Fragment {

    public boolean isFragmentViewInit = true;
    public View lastView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.v("--------", "onCreateView");
        if (null == lastView) {
            Log.v("--------", "null == lastView");
            lastView = setRootView(inflater, container, savedInstanceState);
        }
        return lastView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.v("--------", "--onViewCreated");
        if (isFragmentViewInit) {
            Log.v("--------", "isFragmentViewInit");
            initView(view);
            initData();
            isFragmentViewInit = false;
        }
    }

    /**
     * 设置根view
     *
     * @param inflater           inflater
     * @param container          container
     * @param savedInstanceState savedInstanceState
     * @return view
     */
    protected abstract View setRootView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    /**
     * view初始化
     *
     * @param view 布局
     */
    protected abstract void initView(View view);

    /**
     * 初始化数据
     */
    protected abstract void initData();
}