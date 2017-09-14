package com.example.thang.giaotiepfragmentandactivity.model;

import android.graphics.Color;
import android.widget.Button;

import com.example.thang.giaotiepfragmentandactivity.R;

/**
 * Created by thang on 9/10/2017.
 */

public class LeterModel {
    Button btn;
    int id;

    public LeterModel(Button btn, int id) {
        this.btn = btn;
        this.id = id;
    }

    public Button getBtn() {
        return btn;
    }

    public int getId() {
        return id;
    }




}
