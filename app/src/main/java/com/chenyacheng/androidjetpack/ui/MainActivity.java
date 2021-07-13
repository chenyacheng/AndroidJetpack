package com.chenyacheng.androidjetpack.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.chenyacheng.androidjetpack.databinding.ActivityMainBinding;
import com.chenyacheng.androidjetpack.ui.lifecycle.LifecycleTestActivity;
import com.chenyacheng.androidjetpack.ui.livedata.LiveDataActivity;
import com.chenyacheng.androidjetpack.ui.navigation.NavigationActivity;
import com.chenyacheng.androidjetpack.ui.viewmodel.TimerActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.lifecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LifecycleTestActivity.class));
            }
        });

        binding.onlyViewModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TimerActivity.class));
            }
        });

        binding.livedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LiveDataActivity.class));
            }
        });

        binding.navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NavigationActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}