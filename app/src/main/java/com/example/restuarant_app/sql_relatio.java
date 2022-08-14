package com.example.restuarant_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class sql_relatio extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Restaurant";

    public static final String book = "book";
    public static final String table = "table_id";
    public static final String order = "order_id";
    public static final String customer = "customer_id";

    public sql_relatio(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table " + book
                + " ( "+ table + " INTEGER NOT NULL, "+order + " INTEGER NOT NULL, "+customer + " INTEGER NOT NULL, "
                +"PRIMARY KEY ("+table+", "+order+", "+customer+"), "
                + "FOREIGN KEY (" + table + ") REFERENCES " + table_inf.table_name + " (" + table_inf.table_id + "), "
                + "FOREIGN KEY (" + order + ") REFERENCES " + sql.table_name + " (" + sql.id + "), "
                + "FOREIGN KEY (" + customer + ") REFERENCES " + dataBaseHelper.CUSTOMER_TABLE + " (" + dataBaseHelper.COL_ID+ "))";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + book);
        onCreate(db);
    }
    public void add_re(relatio r) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(table, r.getT());
        value.put(order,r.getO());
        value.put(customer,r.getC());
        db.insert(book, null, value);
    }
    public void update_re(relatio r) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(table, r.getT());
        value.put(order,r.getO());
        db.update(book, value, customer, new String[]{String.valueOf(r.getC())});
    }

}
