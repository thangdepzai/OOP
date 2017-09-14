package com.example.thang.giaotiepfragmentandactivity.data;

/**
 * Created by thang on 9/12/2017.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class QuanLyCauHoiDatabase  extends SQLiteAssetHelper {


    public QuanLyCauHoiDatabase(Context context) {
        super(context,"CauHoiDataBase1.sqlite",null, 1);
    }
}
