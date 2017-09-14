package com.example.thang.giaotiepfragmentandactivity.fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thang.giaotiepfragmentandactivity.R;
import com.example.thang.giaotiepfragmentandactivity.ui.activity.PlayActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChoiThoiFragment extends Fragment implements View.OnTouchListener {
    ImageView imgNon;
    private int mCurrAngle = 0;
    private int mPrevAngle = 0;
    TextView txtKQ;
    TextView txtImg;
    TextView txtNoiDungKim;
    TextView txtNhap;
    Button btnDoan;
    ArrayList<String> data = new ArrayList<>();
    ArrayList<String> dataLeter = new ArrayList<>();
    MediaPlayer song;




    public ChoiThoiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choi_thoi, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

         song = MediaPlayer.create(getActivity(), R.raw.quay);
        data.add("800");
        data.add("Mất điểm");
        data.add("100");
        data.add("200");
        data.add("Nhân 2");
        data.add("300");
        data.add("400");
        data.add("May Mắn");
        data.add("300");
        data.add("700");
        data.add("Mất Lượt");
        data.add("600");
        data.add("Chia 2");
        data.add("500");
        data.add("100");
        data.add("Thêm Lượt");
        data.add("200");
        data.add("300");
        data.add("Thưởng");
        data.add("900");
        imgNon = (ImageView) view.findViewById(R.id.imgNon);
        // txtKQ = (TextView) view.findViewById(R.id.txtKQ);
       //  txtImg = (TextView) view.findViewById(R.id.txtImg);
        txtNoiDungKim = (TextView) view.findViewById(R.id.txtNoiDungKim);
       // txtNhap = (TextView) view.findViewById(R.id.txtNhap);
        if(((PlayActivity)getActivity()).Live()&&(!((PlayActivity)getActivity()).CheckMustDoan())) {
            imgNon.setOnTouchListener(this);
        } else{
            if(((PlayActivity)getActivity()).CheckMustDoan()){
            Toast.makeText(getActivity(),"Nhấn button để Đoán Luôn",Toast.LENGTH_LONG);
            }
            imgNon.setOnTouchListener(null);
        }
        btnDoan = (Button) view.findViewById(R.id.btnDoan);
        btnDoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((PlayActivity)getActivity()).AddFragment(R.id.myLayout2,new DoanFragment());
            }
        });

    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        final float xc = (imgNon.getX() + imgNon.getWidth() / 2);
        final float yc = (imgNon.getY() + imgNon.getHeight() / 2);
       // txtImg.setText("Tâm x = " + xc + " ,y = " + yc);

        // Toast.makeText(getActivity(),xc+" "+yc,Toast.LENGTH_SHORT).show();
        final float x = motionEvent.getX();
        final float y = motionEvent.getY();
       // txtKQ.setText("x= " + x + " , y= " + y);
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                // Khi chạm vào một điểm trên màn hình
                imgNon.clearAnimation();


                break;
            }
//            case MotionEvent.ACTION_MOVE: {
//                //  ACTION_MOVE là sự kiện khi ta di chuyển ngón tay trên màn hình
//                // Hàm này sẽ cập nhập lại vị trí của điểm chạm khi di chuyển
//
//
//
//                break;
            // }
            case MotionEvent.ACTION_UP: {
                // ACTION_UP: Khi nhấc ngón tay lên

                    mCurrAngle = (int)(50*Math.toDegrees(Math.atan2( Math.abs(x - xc), Math.abs(yc - y))));
                    mCurrAngle = mCurrAngle - mCurrAngle%18;
                   // txtNhap.setText(String.valueOf(mCurrAngle/18));
                    animate(mPrevAngle, mCurrAngle, 3000);
                    mPrevAngle = mCurrAngle;
                    break;

            }

        }
        return true;
    }
    private void animate(double fromDegrees, double toDegrees, long durationMillis) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setInterpolator(((PlayActivity)getActivity()), android.R.anim.decelerate_interpolator);
        rotate.setDuration(durationMillis);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        imgNon.startAnimation(rotate);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                song.start();


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                song.stop();
                Animation   scale = AnimationUtils.loadAnimation(getActivity(),R.anim.scale);
                scale.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        txtNoiDungKim.setText( data.get( (int)(mCurrAngle/18)%data.size())   );
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (txtNoiDungKim.getText().toString().equals("Chia 2")) {
                            ((PlayActivity) getActivity()).Nhandiem(0.5);

                        } else if (txtNoiDungKim.getText().toString().equals("Mất Lượt")) {
                            ((PlayActivity) getActivity()).UpdateMoney(false, 0);

                        } else if (txtNoiDungKim.getText().toString().equals("Nhân 2") ) {
                            ((PlayActivity) getActivity()).Nhandiem(2);
                        }
                        else if(txtNoiDungKim.getText().toString().equals("May Mắn") || txtNoiDungKim.getText().toString().equals("Thưởng")){
                            ((PlayActivity) getActivity()).UpdateMoney(true,2500);

                        } else if (txtNoiDungKim.getText().toString().equals("Mất điểm")) {
                            ((PlayActivity) getActivity()).Nhandiem(0);

                        } else if (txtNoiDungKim.getText().toString().equals("Thêm Lượt")) {
                            ((PlayActivity) getActivity()).ThemLuot();


                        } else {

                            ((PlayActivity) getActivity()).AddFragment(R.id.myLayout2, new LeterFragment().newObj(txtNoiDungKim.getText().toString()));
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                txtNoiDungKim.startAnimation(scale);



            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }


}



