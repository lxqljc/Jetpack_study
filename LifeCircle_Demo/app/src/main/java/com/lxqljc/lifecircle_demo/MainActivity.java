package com.lxqljc.lifecircle_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.lxqljc.location.MyLocationListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLifecycle().addObserver(new MyLocationListener(this, new MyLocationListener.OnLocationChangedListener() {
            @Override
            public void onChanged(double latitude, double longitude) {
                Log.d(TAG, "onChanged: latitude -> " + latitude + "  longitude -> " + longitude);
            }
        }));
    }
}