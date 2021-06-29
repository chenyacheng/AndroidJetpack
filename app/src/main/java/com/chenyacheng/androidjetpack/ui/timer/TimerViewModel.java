package com.chenyacheng.androidjetpack.ui.timer;

import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author chenyacheng
 * @date 2021/06/29
 */
public class TimerViewModel extends ViewModel {

    private Timer timer;
    private int currentSecond;

    @Override
    protected void onCleared() {
        //清理资源
        timer.cancel();
        timer = null;
        super.onCleared();
    }

    //开始计时
    public void startTiming() {
        if (timer == null) {
            currentSecond = 0;
            timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    currentSecond++;
                    if (onTimeChangeListener != null) {
                        onTimeChangeListener.onTimeChanged(currentSecond);
                    }
                }
            };
            timer.schedule(timerTask, 1000, 1000);
        }
    }

    private OnTimeChangeListener onTimeChangeListener;

    public void setOnTimeChangeListener(OnTimeChangeListener onTimeChangeListener) {
        this.onTimeChangeListener = onTimeChangeListener;
    }

    public interface OnTimeChangeListener {
        void onTimeChanged(int second);
    }

}
