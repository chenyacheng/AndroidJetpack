package com.chenyacheng.androidjetpack.ui.livedata;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.chenyacheng.androidjetpack.databinding.ActivityLivedataBinding;

/**
 * @author chenyacheng
 * @date 2021/07/07
 */
public class LiveDataActivity extends AppCompatActivity {

    private ActivityLivedataBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLivedataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        iniComponent();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println(intent);
    }

    private void iniComponent() {
        // 通过ViewModelProvider得到ViewModel
        LiveDataViewModel liveDataViewModel = new ViewModelProvider(this).get(LiveDataViewModel.class);
        // 得到ViewModel中的LiveData
        final MutableLiveData<Integer> liveData = (MutableLiveData<Integer>) liveDataViewModel.getCurrentSecond();
        // 通过liveData.observer()观察ViewModel中数据的变化
        liveData.observe(this, integer -> {
            String time = "Time:" + integer;
            binding.textView.setText(time);
        });
        // 记时开始
        binding.button.setOnClickListener(v -> liveDataViewModel.startTiming());
        // 关闭定时器
        binding.reset.setOnClickListener(v -> {
            // 通过LiveData.setValue()/LiveData.postValue()
            // 完成对ViewModel中数据的更新
            liveData.setValue(0);
            // 关闭定时器
            liveDataViewModel.stopTiming();
        });
    }

    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}
