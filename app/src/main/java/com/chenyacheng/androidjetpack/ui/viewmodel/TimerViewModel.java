package com.chenyacheng.androidjetpack.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyacheng
 * @date 2021/06/29
 */
public class TimerViewModel extends ViewModel {

    private int currentSecond = 0;
    private ScheduledExecutorService scheduledExecutorService;
    private OnTimeChangeListener onTimeChangeListener;

    @Override
    protected void onCleared() {
        // 清理资源
        scheduledExecutorService.shutdown();
        scheduledExecutorService = null;
        onTimeChangeListener = null;
        super.onCleared();
    }

    /**
     * 开始计时
     */
    public void startTiming() {
        long initialDelay = 1;
        long period = 1;
        scheduledExecutorService = new ScheduledThreadPoolExecutor(1, new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            Log.e("Thread", "线程池");
            currentSecond++;
            if (onTimeChangeListener != null) {
                onTimeChangeListener.onTimeChanged(currentSecond);
            }
        },initialDelay,period, TimeUnit.SECONDS);
    }

    public void setOnTimeChangeListener(OnTimeChangeListener onTimeChangeListener) {
        this.onTimeChangeListener = onTimeChangeListener;
    }

    public interface OnTimeChangeListener {
        /**
         * 时间监听
         *
         * @param second 秒数
         */
        void onTimeChanged(int second);
    }

}
