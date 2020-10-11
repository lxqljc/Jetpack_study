package com.lxqljc.location;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Author: luoxiaoquan
 * Date: 2020/10/11
 * description: 封装获取地理位置代码
 */
public class MyLocationListener implements LifecycleObserver {

    private static final String TAG = "MyLocationListener";

    private OnLocationChangedListener listener;


    public MyLocationListener(Activity activity, OnLocationChangedListener listener) {
        this.listener = listener;
        initLocationManager();
    }

    /**
     * 初始化操作
     */
    private void initLocationManager() {
    }

    /**
     * 当Activity执行onResume() 方法时，该方法会被自动调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void startGetLocation() {

        Log.d(TAG, "startGetLocation: ");
        if (this.listener != null) {
            this.listener.onChanged(23, 115);
        }
    }

    /**
     * 当Activity执行onPause() 方法时，该方法会被自动调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void stopGetLocation() {

        Log.d(TAG, "stopGetLocation: ");
    }

    /**
     * 当地理位置发生变化时，通过该接口通知调用者
     */
    public interface OnLocationChangedListener {

        void onChanged(double latitude, double longitude);
    }
}
