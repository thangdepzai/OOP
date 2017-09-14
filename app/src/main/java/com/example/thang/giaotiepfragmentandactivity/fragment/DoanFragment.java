package com.example.thang.giaotiepfragmentandactivity.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.thang.giaotiepfragmentandactivity.R;
import com.example.thang.giaotiepfragmentandactivity.ui.activity.PlayActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoanFragment extends Fragment {
    Button btnHuy;

    Button btnDoan;
    ArrayList<Button> data =new ArrayList<>();
    Button btnQ, btnW, btnE,btnR, btnT,btnY,btnU,btnI,btnO,btnP,btnA,btnS,btnD,btnF,btnG,
    btnH,btnJ,btnK,btnL,btnZ,btnX,btnC,btnV,btnB,btnN,btnM,btnBackSpace,btnSpace;
    TextView txtTraLoi;


    public DoanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_doan, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnHuy = (Button) view.findViewById(R.id.btnHuy);

      btnDoan = (Button) view.findViewById(R.id.btnDoan);
        data.add((Button) view.findViewById(R.id.btnQ));
        data.add((Button) view.findViewById(R.id.btnW));
        data.add((Button) view.findViewById(R.id.btnE));
        data.add( (Button) view.findViewById(R.id.btnR));
        data.add( (Button) view.findViewById(R.id.btnT));
        data.add( (Button) view.findViewById(R.id.btnY));
        data.add( (Button) view.findViewById(R.id.btnU));
        data.add( (Button) view.findViewById(R.id.btnI));
        data.add( (Button) view.findViewById(R.id.btnO));
        data.add( (Button) view.findViewById(R.id.btnP));
        data.add( (Button) view.findViewById(R.id.btnA));
        data.add( (Button) view.findViewById(R.id.btnS));
        data.add((Button) view.findViewById(R.id.btnD));
        data.add( (Button) view.findViewById(R.id.btnF));
        data.add((Button) view.findViewById(R.id.btnG));
        data.add( (Button) view.findViewById(R.id.btnH));
        data.add( (Button) view.findViewById(R.id.btnJ));
        data.add((Button) view.findViewById(R.id.btnK));
        data.add( (Button) view.findViewById(R.id.btnL));
        data.add((Button) view.findViewById(R.id.btnZ));
        data.add( (Button) view.findViewById(R.id.btnX));
        data.add( (Button) view.findViewById(R.id.btnC));
        data.add( (Button) view.findViewById(R.id.btnV));
        data.add( (Button) view.findViewById(R.id.btnB));
        data.add( (Button) view.findViewById(R.id.btnN));
        data.add( (Button) view.findViewById(R.id.btnM));
       txtTraLoi = (TextView) view.findViewById(R.id.txtTraLoi);
       btnBackSpace = (Button) view.findViewById(R.id.btnBackSpace);
       btnSpace = (Button) view.findViewById(R.id.btnSpace);
        btnDoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((PlayActivity)getActivity()).Check(txtTraLoi.getText().toString())){
                    ((PlayActivity)getActivity()).UpdateContext();
                    ((PlayActivity)getActivity()).UpdateMoney(true,1000);



                }
                else {

                    ((PlayActivity)getActivity()).UpdateMoney(true,-100);

                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTraLoi.setText("");
                ((PlayActivity)getActivity()).onBackPressed();
            }
        });
        for(final Button b :data){
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTraLoi.setText(txtTraLoi.getText().toString()+b.getText().toString());
                }
            });
        }


        btnSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTraLoi.setText(txtTraLoi.getText().toString()+" ");
            }
        });
        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if(txtTraLoi.getText().length()>0) {
                    txtTraLoi.setText(txtTraLoi.getText().subSequence(0, txtTraLoi.getText().length() - 1));
                }
            }
        });




    }
}
