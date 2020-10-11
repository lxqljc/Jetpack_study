package com.lxqljc.service;

import androidx.lifecycle.LifecycleService;

/**
 * Author: luoxiaoquan
 * Date: 2020/10/11
 * description: 描述
 */
public class MyService extends LifecycleService {

    public MyService() {
        //将观察者与被观察者绑定
        getLifecycle().addObserver(new MyServiceObserver());
    }
}
