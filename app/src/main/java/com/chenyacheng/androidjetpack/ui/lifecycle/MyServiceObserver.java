package com.chenyacheng.androidjetpack.ui.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author chenyacheng
 * @date 2021/07/01
 */
class MyServiceObserver implements LifecycleObserver {

    //当Service的onCreate()方法被调用时，该方法会被调用
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private  void startService(){
        Log.e("service","Service中的oncreate方法执行了");
    }

    //当Service的onDestroy()方法被调用时，该方法会被调用
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private  void stopService(){
        Log.e("service","Service中的onDestroy方法执行了");
    }
}
