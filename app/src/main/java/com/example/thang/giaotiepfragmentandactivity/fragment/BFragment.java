package com.example.thang.giaotiepfragmentandactivity.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thang.giaotiepfragmentandactivity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {


    public BFragment() {
        // Required empty public constructor
    }

    public static BFragment newObj (String noidung){
        BFragment fragmentB = new BFragment();
        Bundle bd = new Bundle();
        bd.putString("noidung",noidung);
        fragmentB.setArguments(bd); // luu gia tri





        return fragmentB;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txt = (TextView) view.findViewById(R.id.txt);
        String noidungCanLay = getArguments().getString("noidung","");
        txt.setText(noidungCanLay);
    }
}
