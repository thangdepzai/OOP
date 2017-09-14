package com.example.thang.giaotiepfragmentandactivity.ui.activity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thang.giaotiepfragmentandactivity.R;
import com.example.thang.giaotiepfragmentandactivity.data.QuanLiCauHoiDAO;
import com.example.thang.giaotiepfragmentandactivity.fragment.ChoiThoiFragment;
import com.example.thang.giaotiepfragmentandactivity.fragment.DoanFragment;
import com.example.thang.giaotiepfragmentandactivity.fragment.LeterFragment;
import com.example.thang.giaotiepfragmentandactivity.model.CauHoiModel;

import java.util.ArrayList;
import java.util.Collections;

public class PlayActivity extends AppCompatActivity {
    int dem=0;
    int len;
    TextView txtMang;
    TextView txtMoney;
    TextView txtLevel;
    CauHoiModel cauhoi;
    TextView txtCauHoi;
    public boolean[] flag = new boolean[26];
    ArrayList<TextView> dataLeter = new ArrayList<>();
    private QuanLiCauHoiDAO quanLiCauHoiDAO;
    private ArrayList<CauHoiModel> data;
    ArrayList<Integer> ArrayNumber = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        for (int i = 0; i < 26; i++) {
            flag[i] = true;
        }
        txtMang = (TextView) findViewById(R.id.txtMang);
        txtMoney = (TextView) findViewById(R.id.txtMoney);
        txtLevel = (TextView) findViewById(R.id.txtLevel);
        txtCauHoi = (TextView) findViewById(R.id.txtCauHoi);

        dataLeter.add((TextView) findViewById(R.id.txt0));
        dataLeter.add((TextView) findViewById(R.id.txt1));
        dataLeter.add((TextView) findViewById(R.id.txt2));
        dataLeter.add((TextView) findViewById(R.id.txt3));
        dataLeter.add((TextView) findViewById(R.id.txt4));
        dataLeter.add((TextView) findViewById(R.id.txt5));
        dataLeter.add((TextView) findViewById(R.id.txt6));
        dataLeter.add((TextView) findViewById(R.id.txt7));
        dataLeter.add((TextView) findViewById(R.id.txt8));
        dataLeter.add((TextView) findViewById(R.id.txt9));
        dataLeter.add((TextView) findViewById(R.id.txt10));
        dataLeter.add((TextView) findViewById(R.id.txt11));
        dataLeter.add((TextView) findViewById(R.id.txt12));
        dataLeter.add((TextView) findViewById(R.id.txt13));
        dataLeter.add((TextView) findViewById(R.id.txt14));
        dataLeter.add((TextView) findViewById(R.id.txt15));
        dataLeter.add((TextView) findViewById(R.id.txt16));
        dataLeter.add((TextView) findViewById(R.id.txt17));
        dataLeter.add((TextView) findViewById(R.id.txt18));
        dataLeter.add((TextView) findViewById(R.id.txt19));
        dataLeter.add((TextView) findViewById(R.id.txt20));
        dataLeter.add((TextView) findViewById(R.id.txt21));
        dataLeter.add((TextView) findViewById(R.id.txt22));
        dataLeter.add((TextView) findViewById(R.id.txt23));
        dataLeter.add((TextView) findViewById(R.id.txt24));
        dataLeter.add((TextView) findViewById(R.id.txt25));
        dataLeter.add((TextView) findViewById(R.id.txt26));

        quanLiCauHoiDAO = new QuanLiCauHoiDAO(PlayActivity.this);
        quanLiCauHoiDAO.open();
        data = quanLiCauHoiDAO.getData();
        quanLiCauHoiDAO.close();
        for(int i=0;i<data.size();i++){
            ArrayNumber.add(i);

        }

        Collections.shuffle(ArrayNumber);
        cauhoi = data.get(ArrayNumber.get(0));
        ArrayNumber.remove(0);

        txtCauHoi.setText( cauhoi.getCauhoi());
        ArrayList<String> c = ToArray(cauhoi);
        ArrayList<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < c.size(); i++) {
            len+= c.get(i).length();

            for (int j = 0; j < c.get(i).length(); j++) {

                tmp.add(i * 9 + (9 - c.get(i).length()) / 2 + j);
            }

        }
        for (int i = 0; i < 27; i++) {
            if (!tmp.contains(i)) {
                dataLeter.get(i).setBackgroundColor(Color.GRAY);
            }
        }


        AddFragment(R.id.myLayout2, new ChoiThoiFragment());


    }

    public boolean[] getFlag() {
        return flag;
    }

    public void AddFragment(int id, Fragment fragment) {
        String name = fragment.getClass().getName();
        FragmentManager quanlyFragment = getSupportFragmentManager();
        FragmentTransaction giaodich = quanlyFragment.beginTransaction();
        giaodich.replace(id, fragment);
        giaodich.addToBackStack(name);
        giaodich.commit();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.myLayout2);
        if (fragment instanceof LeterFragment) {

        } else if (fragment instanceof DoanFragment) {
            super.onBackPressed();
        } else if (fragment instanceof ChoiThoiFragment) {
            System.exit(0);
        }
    }

    public int Update(char ch) {
        int flag = 0;
        ArrayList<String> c = ToArray(cauhoi);
        for (int i = 0; i < c.size(); i++) {
            char[] a = c.get(i).toCharArray();
            for (int j = 0; j < a.length; j++) {
                if (a[j] == ch) {
                    dataLeter.get(i * 9 + (9 - c.get(i).length()) / 2 + j).setText(String.valueOf(ch));
                    flag++;
                }
            }


        }
        dem +=flag;
        return flag;


    }
    public  boolean CheckMustDoan(){
        if(dem==len){

           return true;
        }
        else return false;

    }

    public void UpdateContext() {
        Toast.makeText(this,"Chính Xác !!!, Câu Hỏi Tiếp Theo",Toast.LENGTH_LONG);

        dem=0;

        txtMang.setText("3");
        for (int i = 0; i < 26; i++) {
            flag[i] = true;
        }

        for (int i = 0; i < 27; i++) {
            dataLeter.get(i).setBackgroundResource(R.drawable.button_mini);
            dataLeter.get(i).setText("");
        }
        AddFragment(R.id.myLayout2, new ChoiThoiFragment());
        Collections.shuffle(ArrayNumber);
        cauhoi = data.get(ArrayNumber.get(0));
        ArrayNumber.remove(0);

        txtCauHoi.setText(cauhoi.getCauhoi());
        ArrayList<String> c = ToArray(cauhoi);

        ArrayList<Integer> tmp = new ArrayList<>();
        len =0;
        for (int i = 0; i < c.size(); i++) {
            len+=c.get(i).length();

            for (int j = 0; j < c.get(i).length(); j++) {

                tmp.add(i * 9 + (9 - c.get(i).length()) / 2 + j);
            }

        }
        for (int i = 0; i < 27; i++) {
            if (!tmp.contains(i)) {
                dataLeter.get(i).setBackgroundColor(Color.GRAY);
            }
        }


    }

    public void ThemLuot() {
        txtMang.setText(String.valueOf(Integer.parseInt(txtMang.getText().toString()) + 1));
        Toast.makeText(this, "Bạn Được Thêm 1 Lượt Chơi, Mời Bạn Quay Tiếp", Toast.LENGTH_LONG).show();

    }

    public void Nhandiem(double j) {
        txtMoney.setText(String.valueOf((int) (Integer.parseInt(txtMoney.getText().toString()) * j)));
    }

    public ArrayList<String> ToArray(CauHoiModel cauhoi) {
        String[] str = cauhoi.getCauTraLoi().split(" ");
        int len = 0;
        for (int i = 0; i < str.length; i++) len += str[i].length();
        ArrayList<String> c = new ArrayList<>();
        int start = 0;
        int size = 0;
        while (size != len) {
            String buff = new String();
            int dem = 0;
            for (int i = start; i < str.length; i++) {

                if (dem + str[i].length() <= 9) {
                    buff += str[i];
                    dem += str[i].length();
                } else {
                    start = i;
                    break;

                }


            }

            if (!buff.isEmpty()) {
                c.add(buff);
                size += buff.length();

            }

        }
        return c;


    }

    public boolean Check(String s) {
        if (cauhoi.getCauTraLoi().equals(s)) {

            return true;
        } else return false;
    }

    public boolean Live() {
        if (Integer.parseInt(txtMang.getText().toString()) > 0) {
            return true;
        } else return false;

    }

    public void UpdateMoney(boolean b, int point) {
        if (b) {
            if(Integer.parseInt(txtMoney.getText().toString())+point>=0) {
                if(point>0){
                    Toast.makeText(this,"Bạn được cộng thêm "+point,Toast.LENGTH_SHORT).show();
                    MediaPlayer song = MediaPlayer.create(PlayActivity.this, R.raw.tingting);
                    song.start();

                }
                else {
                    Toast.makeText(this, "Bạn bị trừ 100đ ", Toast.LENGTH_SHORT).show();
                    MediaPlayer song = MediaPlayer.create(PlayActivity.this, R.raw.failure);
                    song.start();
                }
                    txtMoney.setText(String.valueOf(Integer.parseInt(txtMoney.getText().toString()) + point));
            }else{
                if(Integer.parseInt(txtMang.getText().toString())>0) {
                    txtMang.setText(String.valueOf(Integer.parseInt(txtMang.getText().toString()) - 1));
                    Toast.makeText(this, "Bạn bị mất 1 lượt chơi", Toast.LENGTH_SHORT).show();
                    MediaPlayer song = MediaPlayer.create(PlayActivity.this, R.raw.failure);
                    song.start();

                }else{
                    Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show();
                    MediaPlayer song = MediaPlayer.create(PlayActivity.this, R.raw.wrong);
                    song.start();
                    song.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            System.exit(0);
                        }
                    });

                    }

            }
            }
         else {
            txtMang.setText(String.valueOf(Integer.parseInt(txtMang.getText().toString()) - 1));

            if (Integer.parseInt(txtMang.getText().toString()) > 0) {

                MediaPlayer song = MediaPlayer.create(PlayActivity.this, R.raw.failure);
                song.start();
                Toast.makeText(this, "Bạn Mất 1 Lượt Chơi, Mời Bạn Quay Tiếp", Toast.LENGTH_SHORT).show();


            } else {
                Toast.makeText(this, "Bạn Hết Lượt Quay, Bạn Chỉ Có Thể Đoán Luôn", Toast.LENGTH_LONG).show();
                MediaPlayer song = MediaPlayer.create(PlayActivity.this, R.raw.failure);
                song.start();
            }

        }
    }
}
