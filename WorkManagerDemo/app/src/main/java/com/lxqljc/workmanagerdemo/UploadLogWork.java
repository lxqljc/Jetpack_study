package com.lxqljc.workmanagerdemo;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * Author: luoxiaoquan
 * Date: 2020/11/15
 * description: 描述
 */
public class UploadLogWork extends Worker {


    public UploadLogWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    /**
     * 耗时任务
     *
     * @return
     */
    @NonNull
    @Override
    public Result doWork() {
        return Result.success();
    }
}
