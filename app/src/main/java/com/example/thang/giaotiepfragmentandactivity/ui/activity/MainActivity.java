package com.example.thang.giaotiepfragmentandactivity.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.thang.giaotiepfragmentandactivity.R;
import com.example.thang.giaotiepfragmentandactivity.fragment.AFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

       AddFragment(R.id.myLayout,new AFragment());



    }
    public void AddFragment(int id, Fragment fragment){
        String name = fragment.getClass().getName();
        FragmentManager quanlyFragment = getSupportFragmentManager();
        FragmentTransaction giaodich = quanlyFragment.beginTransaction();
        giaodich.replace(id,fragment);
        giaodich.addToBackStack(name);
        giaodich.commit();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.myLayout);
        if(!(fragment instanceof AFragment)){
            super.onBackPressed();
        }
        else{
            super.onBackPressed();
            System.exit(0);
        }
    }
}
