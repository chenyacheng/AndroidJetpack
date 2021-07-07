package com.chenyacheng.androidjetpack.ui.livedata;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.chenyacheng.androidjetpack.ui.viewmodel.BasicThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyacheng
 * @date 2021/07/07
 */
public class LiveDataViewModel extends ViewModel {

    private MutableLiveData<Integer> currentSecond;
    private int current;
    private ScheduledExecutorService scheduledExecutorService;

    public LiveData<Integer> getCurrentSecond() {
        if (currentSecond == null) {
            currentSecond = new MutableLiveData<>();
        }
        return currentSecond;
    }

    /**
     * 开始定时器
     */
    public void startTiming() {
        long initialDelay = 1;
        long period = 1;
        scheduledExecutorService = new ScheduledThreadPoolExecutor(1, new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            Log.e("Thread", "线程池");
            if (currentSecond != null) {
                currentSecond.postValue(current++);
            }
        }, initialDelay, period, TimeUnit.SECONDS);
    }

    /**
     * 关闭定时器
     */
    public void stopTiming() {
        current = 0;
        scheduledExecutorService.shutdown();
    }

    @Override
    protected void onCleared() {
        // 清理资源
        scheduledExecutorService.shutdown();
        scheduledExecutorService = null;
        currentSecond = null;
        super.onCleared();
    }
}
