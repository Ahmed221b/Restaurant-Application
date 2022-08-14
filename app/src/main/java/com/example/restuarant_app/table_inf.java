package com.example.restuarant_app;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class table_inf {

    static int cnt = 1;
    private int id;
    private int nOfChiars;
    private boolean valid;

    public table_inf(int n) {
        id = cnt;
        cnt++;
        nOfChiars = n;
        valid = true;
    }

    public table_inf(int d, int n, boolean v) {
        id = d;
        nOfChiars = n;
        valid = v;
    }

    public int getId() {
        return id;
    }

    public void setnOfChiars(int nOfChiars) {
        this.nOfChiars = nOfChiars;
    }

    public int getnOfChiars() {
        return nOfChiars;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public static final String table_name = "tables";
    public static final String table_id = "id";
    public static final String table_chair = "nOfChairs";
    public static final String table_valid = "valid";

    public static final String create_table =
            "create table " + table_name + " ( "
                    + table_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + table_chair + " INTEGER, "
                    + table_valid + " INTEGER NOT NULL DEFAULT 1 "
                    + ")";

}
