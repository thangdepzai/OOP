package com.example.thang.giaotiepfragmentandactivity.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.thang.giaotiepfragmentandactivity.R;
import com.example.thang.giaotiepfragmentandactivity.ui.activity.PlayActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeterFragment extends Fragment {
    ArrayList<Button> data = new ArrayList<>();
    TextView txtDiem ;
    private Animation scale;
    public boolean flag = true;

    public LeterFragment() {
        // Required empty public constructor
    }
    public static LeterFragment newObj (String noidung){
        LeterFragment fragmentletter = new LeterFragment();
        Bundle bd = new Bundle();
        bd.putString("noidung",noidung);
        fragmentletter.setArguments(bd); // luu gia tri





        return fragmentletter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leter, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtDiem =(TextView) view.findViewById(R.id.txtDiem);
        String noidungCanLay = getArguments().getString("noidung","");
        txtDiem.setText( noidungCanLay);
        data.add((Button) view.findViewById(R.id.btnA));
        data.add((Button) view.findViewById(R.id.btnB));
        data.add((Button) view.findViewById(R.id.btnC));
        data.add((Button) view.findViewById(R.id.btnD));
        data.add((Button) view.findViewById(R.id.btnE));
        data.add((Button) view.findViewById(R.id.btnF));
        data.add((Button) view.findViewById(R.id.btnG));
        data.add((Button) view.findViewById(R.id.btnH));
        data.add((Button) view.findViewById(R.id.btnI));
        data.add((Button) view.findViewById(R.id.btnJ));
        data.add((Button) view.findViewById(R.id.btnK));
        data.add((Button) view.findViewById(R.id.btnL));
        data.add((Button) view.findViewById(R.id.btnM));
        data.add((Button) view.findViewById(R.id.btnN));
        data.add((Button) view.findViewById(R.id.btnO));
        data.add((Button) view.findViewById(R.id.btnP));
        data.add((Button) view.findViewById(R.id.btnQ));
        data.add((Button) view.findViewById(R.id.btnR));
        data.add((Button) view.findViewById(R.id.btnS));
        data.add((Button) view.findViewById(R.id.btnT));
        data.add((Button) view.findViewById(R.id.btnU));
        data.add((Button) view.findViewById(R.id.btnV));
        data.add((Button) view.findViewById(R.id.btnW));
        data.add((Button) view.findViewById(R.id.btnX));
        data.add((Button) view.findViewById(R.id.btnY));
        data.add((Button) view.findViewById(R.id.btnZ));
        scale = AnimationUtils.loadAnimation(getActivity(),R.anim.scale);
        final boolean[] flag = ((PlayActivity)getActivity()).getFlag();
        for(int i=0;i<data.size();i++){
            final Button l = data.get(i);
            if (flag[i]) {

                final int finalI = i;
                l.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            scale.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {
                                    l.setBackgroundColor(Color.YELLOW);
                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    l.setBackgroundColor(Color.GRAY);
                                    flag[finalI]=false;

                                        int b= ((PlayActivity) getActivity()).Update(l.getText().toString().charAt(0));
                                        if(b!=0) {
                                            ((PlayActivity) getActivity()).UpdateMoney(true, b * Integer.parseInt(txtDiem.getText().toString()));
                                        }else ((PlayActivity) getActivity()).UpdateMoney(false, 0);
                                        ((PlayActivity) getActivity()).AddFragment(R.id.myLayout2, new ChoiThoiFragment());
                                   }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                            l.startAnimation(scale);


                        }
                    }
                );
            }else l.setBackgroundColor(Color.GRAY);
        }

    }

}
