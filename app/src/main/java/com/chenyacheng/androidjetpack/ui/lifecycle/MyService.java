package com.chenyacheng.androidjetpack.ui.lifecycle;

import androidx.lifecycle.LifecycleService;

/**
 * @author chenyacheng
 * @date 2021/07/01
 */
public class MyService extends LifecycleService {

    public MyService() {
        final MyServiceObserver myServiceObserver = new MyServiceObserver();
        //将观察者与被观察者绑定
        getLifecycle().addObserver(myServiceObserver);
    }
}
