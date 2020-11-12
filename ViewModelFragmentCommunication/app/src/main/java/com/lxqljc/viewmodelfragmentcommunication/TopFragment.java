package com.lxqljc.viewmodelfragmentcommunication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

/**
 * Author: luoxiaoquan
 * Date: 2020/11/13
 * description: 描述
 */
public class TopFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_top, container, false);
        SeekBar seekBar = view.findViewById(R.id.seek_bar);
        ShareDataViewModel shareDataViewModel = new ViewModelProvider(getActivity()).get(ShareDataViewModel.class);
        MutableLiveData<Integer> liveData = shareDataViewModel.getProgressLiveData();
        liveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                seekBar.setProgress(integer);
            }
        });
        return view;
    }
}
