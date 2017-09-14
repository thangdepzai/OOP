package com.example.thang.giaotiepfragmentandactivity.model;

/**
 * Created by thang on 9/11/2017.
 */

public class CauHoiModel {
    int id;
    private String cauhoi;

    private String CauTraLoi;

    public CauHoiModel(int id, String cauhoi, String cauTraLoi) {
        this.id = id;
        this.cauhoi = cauhoi;
        this.CauTraLoi = cauTraLoi;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public String getCauTraLoi() {
        return CauTraLoi;
    }

    public CauHoiModel(String cauhoi, String cauTraLoi) {
        this.cauhoi = cauhoi;
        this.CauTraLoi = cauTraLoi;
    }
}
