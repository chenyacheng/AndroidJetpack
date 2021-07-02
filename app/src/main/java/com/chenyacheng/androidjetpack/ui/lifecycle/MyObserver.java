package com.chenyacheng.androidjetpack.ui.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * LifecycleOwner(被观察者)和LifecycleObserver(观察者)
 *
 * @author chenyacheng
 * @date 2021/06/30
 */
public class MyObserver implements LifecycleObserver {

    private final String TAG = "Lifecycle_Test";

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    public void connect(){
        Log.i(TAG, "connect: ");
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_PAUSE)
    public void disConnect(){
        Log.i(TAG, "disConnect: ");
    }
}
