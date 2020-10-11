package com.lxqljc.service;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Author: luoxiaoquan
 * Date: 2020/10/11
 * description: 监听service的组件
 */
public class MyServiceObserver implements LifecycleObserver {

    private static final String TAG = "MyServiceObserver";

    public MyServiceObserver() {

    }

    /**
     * 当Service的onCreate方法回调时，该方法会被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void startGetLocation() {
        Log.d(TAG, "startGetLocation: ");
    }

    /**
     * 当Service的onDestroy方法回调时，该方法会被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void stopGetLocation() {
        Log.d(TAG, "stopGetLocation: ");
    }
}
