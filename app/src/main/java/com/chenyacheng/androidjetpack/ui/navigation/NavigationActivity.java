package com.chenyacheng.androidjetpack.ui.navigation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.chenyacheng.androidjetpack.databinding.ActivityNavigationBinding;

/**
 * @author chenyacheng
 * @date 2021/07/13
 */
public class NavigationActivity extends AppCompatActivity {

    private ActivityNavigationBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }

    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}
