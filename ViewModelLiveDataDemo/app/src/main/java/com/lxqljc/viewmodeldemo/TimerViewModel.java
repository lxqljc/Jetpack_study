package com.lxqljc.viewmodeldemo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: luoxiaoquan
 * Date: 2020/11/12
 * description: 描述
 */
public class TimerViewModel extends ViewModel {

    private Timer timer;

    private int currentSecond;

    private MutableLiveData<Integer> currentSecondLiveData;

    /**
     * LiveData对象
     *
     * @return
     */
    public MutableLiveData<Integer> getCurrentSecondLiveData() {
        if (currentSecondLiveData == null) {
            currentSecondLiveData = new MutableLiveData<>();
        }
        return currentSecondLiveData;
    }

    /**
     * 重置
     */
    public void reset() {
        currentSecond = 0;
        currentSecondLiveData.setValue(0);
    }

    /**
     * 开始计时
     */
    public void startTiming() {
        if (timer == null) {
            currentSecond = 0;
            timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    currentSecond++;
                    if (currentSecondLiveData != null) {
                        //post是用在子线程中
                        currentSecondLiveData.postValue(currentSecond);
                    }
                }
            };
            timer.schedule(timerTask, 1000, 1000);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        timer.cancel();
    }

}
