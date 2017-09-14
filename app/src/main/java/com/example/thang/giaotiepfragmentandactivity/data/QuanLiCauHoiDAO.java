package com.example.thang.giaotiepfragmentandactivity.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thang.giaotiepfragmentandactivity.model.CauHoiModel;

import java.util.ArrayList;

/**
 * Created by thang on 9/12/2017.
 */

public class QuanLiCauHoiDAO {
    private QuanLyCauHoiDatabase quanLyCauHoiDatabase;
    private SQLiteDatabase database;
    public  QuanLiCauHoiDAO(Context context){
        quanLyCauHoiDatabase = new QuanLyCauHoiDatabase(context);
    }
    public void open(){
        database =  quanLyCauHoiDatabase.getWritableDatabase();
    }
    public  void close(){
        database.close();
    }

    // xem( lay) du lieu
    public ArrayList<CauHoiModel> getData(){
        ArrayList<CauHoiModel>  data = new ArrayList<>();
        String sql ="SELECT * FROM question";

        Cursor contro =  database.rawQuery(sql,null);
        contro.moveToFirst(); // con tro o hag dau tien
        while(!contro.isAfterLast()){
            // doc den khi nao het du lieu thi thoi
            int id = contro.getInt(contro.getColumnIndex("id"));
            String tencauhoi = contro.getString(contro.getColumnIndex("tencauhoi"));
            String cautraloi  = contro.getString(contro.getColumnIndex("cautraloi"));
            CauHoiModel sv = new CauHoiModel(id,tencauhoi,cautraloi);
            data.add(sv);
            contro.moveToNext();

        }



        return data;
    }
}
