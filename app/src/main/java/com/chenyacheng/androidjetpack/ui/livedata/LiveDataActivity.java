package com.chenyacheng.androidjetpack.ui.livedata;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
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

    private void iniComponent() {
        // 通过ViewModelProvider得到ViewModel
        LiveDataViewModel liveDataViewModel = new ViewModelProvider(this).get(LiveDataViewModel.class);
        // 得到ViewModel中的LiveData
        final MutableLiveData<Integer> liveData = (MutableLiveData<Integer>) liveDataViewModel.getCurrentSecond();
        //通过liveData.observer()观察ViewModel中数据的变化
        liveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.textView.setText("Time:" + integer);
            }
        });
        // 记时开始
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liveDataViewModel.startTiming();
            }
        });
        // 关闭定时器
        binding.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 通过LiveData.setValue()/LiveData.postValue()
                // 完成对ViewModel中数据的更新
                liveData.setValue(0);
                // 关闭定时器
                liveDataViewModel.stopTiming();
            }
        });
    }

    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}
