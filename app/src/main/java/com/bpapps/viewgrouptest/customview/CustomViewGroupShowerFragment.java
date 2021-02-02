package com.bpapps.viewgrouptest.customview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bpapps.viewgrouptest.R;

public class CustomViewGroupShowerFragment extends Fragment {

    public CustomViewGroupShowerFragment() {
        // Required empty public constructor
    }

    public static CustomViewGroupShowerFragment newInstance() {
        CustomViewGroupShowerFragment fragment = new CustomViewGroupShowerFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom_view_group_shower, container, false);
    }
}