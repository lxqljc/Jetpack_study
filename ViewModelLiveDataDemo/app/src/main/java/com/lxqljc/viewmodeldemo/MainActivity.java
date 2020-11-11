package com.lxqljc.viewmodeldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv);
        Button btnReset = findViewById(R.id.btn_reset);
        TimerViewModel timerViewModel = new ViewModelProvider(this).get(TimerViewModel.class);
        MutableLiveData<Integer> liveData = timerViewModel.getCurrentSecondLiveData();
        liveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tv.setText("Time-->" + integer);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set是用在主线程
                timerViewModel.reset();
            }
        });
        timerViewModel.startTiming();
    }
}