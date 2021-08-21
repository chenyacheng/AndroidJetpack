package com.chenyacheng.androidjetpack.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        Log.v("lifecycle", "onCreate");
        System.out.println(savedInstanceState);

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
    protected void onStart() {
        super.onStart();
        Log.v("lifecycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("lifecycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("lifecycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("lifecycle", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("lifecycle", "onRestart");
    }

    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
        Log.v("lifecycle", "onDestroy");
    }
}