package com.bpapps.viewgrouptest.customview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bpapps.viewgrouptest.R;


public class CustomDividerShowerFragment extends Fragment {

    public CustomDividerShowerFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CustomDividerShowerFragment newInstance() {
        return new CustomDividerShowerFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom_divider_shower, container, false);
    }
}