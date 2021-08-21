 package com.chenyacheng.androidjetpack.ui.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.chenyacheng.androidjetpack.R;
import com.chenyacheng.androidjetpack.base.BaseFragment;
import com.chenyacheng.androidjetpack.databinding.FragmentBlankBinding;

/**
 *
 */
public class BlankFragment extends BaseFragment {

    private FragmentBlankBinding binding;

    @Override
    protected View setRootView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initView(View view) {
        view.findViewById(R.id.blankButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                BlankFragmentArgs args = new BlankFragmentArgs();

                // 方法有两种，任选一种
//                Navigation.createNavigateOnClickListener(R.id.blankFragment_to_secondFragment);
                Navigation.findNavController(v).navigate(R.id.blankFragment_to_secondFragment);
            }
        });
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