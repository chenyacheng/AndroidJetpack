package com.chenyacheng.androidjetpack.ui.timer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.chenyacheng.androidjetpack.databinding.ActivityTimerBinding;

/**
 * @author chenyacheng
 * @date 2021/06/28
 */
public class TimerActivity extends AppCompatActivity {

    private ActivityTimerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTimerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        iniComponent();
    }

    private void iniComponent() {
        final TextView textView = binding.time;
        TimerViewModel timerViewModel =  new ViewModelProvider(this).get(TimerViewModel.class);
        timerViewModel.setOnTimeChangeListener(new TimerViewModel.OnTimeChangeListener() {
            @Override
            public void onTimeChanged(final int second) {
                //更新UI
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("TIME:"+second);
                    }
                });
            }
        });
        timerViewModel.startTiming();
    }

    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}
