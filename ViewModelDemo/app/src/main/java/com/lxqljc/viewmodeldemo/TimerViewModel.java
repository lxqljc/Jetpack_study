package com.lxqljc.viewmodeldemo;

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
                    if (onTimeChangeListener != null) {
                        onTimeChangeListener.onTimeChanged(currentSecond);
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

    /**
     * 由于没还未学习LiveData，所以暂时采用接口方式
     */
    public interface OnTimeChangeListener {

        void onTimeChanged(int second);
    }

    private OnTimeChangeListener onTimeChangeListener;

    public void setOnTimeChangeListener(OnTimeChangeListener onTimeChangeListener) {
        this.onTimeChangeListener = onTimeChangeListener;
    }
}
