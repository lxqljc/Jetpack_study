package com.lxqljc.viewmodeldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv  = findViewById(R.id.tv);

        TimerViewModel timerViewModel = new ViewModelProvider(this).get(TimerViewModel.class);
        timerViewModel.setOnTimeChangeListener(new TimerViewModel.OnTimeChangeListener() {
            @Override
            public void onTimeChanged(int second) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("Time:" + second);
                    }
                });
            }
        });
        timerViewModel.startTiming();
    }
}