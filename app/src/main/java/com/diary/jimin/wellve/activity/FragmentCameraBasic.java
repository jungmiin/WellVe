package com.diary.jimin.wellve.activity;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.diary.jimin.wellve.R;

import android.view.View;

public class FragmentCameraBasic extends Fragment {

    public FragmentCameraBasic() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_camera2_basic, container, false);
    }
}