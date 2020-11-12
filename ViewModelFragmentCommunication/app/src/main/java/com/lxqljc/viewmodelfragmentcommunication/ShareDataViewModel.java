package com.lxqljc.viewmodelfragmentcommunication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Author: luoxiaoquan
 * Date: 2020/11/13
 * description: 描述
 */
public class ShareDataViewModel extends ViewModel {

    private MutableLiveData<Integer> progressLiveData;

    public MutableLiveData<Integer> getProgressLiveData() {
        if (progressLiveData == null) {
            progressLiveData = new MutableLiveData<>();
        }
        return progressLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        progressLiveData = null;
    }
}
