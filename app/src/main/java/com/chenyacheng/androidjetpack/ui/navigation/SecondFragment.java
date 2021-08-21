package com.chenyacheng.androidjetpack.ui.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chenyacheng.androidjetpack.base.BaseFragment;
import com.chenyacheng.androidjetpack.databinding.FragmentSecondBinding;

/**
 *
 */
public class SecondFragment extends BaseFragment {

    private FragmentSecondBinding binding;

    @Override
    protected View setRootView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}