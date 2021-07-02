package com.chenyacheng.androidjetpack.ui.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.chenyacheng.androidjetpack.databinding.ActivityLifecycleBinding;

/**
 * @author chenyacheng
 * @date 2021/06/30
 */
public class LifecycleTestActivity extends AppCompatActivity {

    private ActivityLifecycleBinding binding;
    private MyObserver myObserver;

    private final String TAG = "Lifecycle_Test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLifecycleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Lifecycle 生命周期
        myObserver = new MyObserver();
        // 将观察者与被观察者绑定
        getLifecycle().addObserver(myObserver);
        Log.i(TAG, "onCreate: ");

        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动服务
                startService(new Intent(LifecycleTestActivity.this, MyService.class));
            }
        });

        binding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 停止服务
                stopService(new Intent(LifecycleTestActivity.this, MyService.class));
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onDestroy() {
        binding = null;
        getLifecycle().removeObserver(myObserver);
        myObserver = null;
        super.onDestroy();
    }
}
