package com.example.restuarant_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseTable extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Restaurant";

    public DatabaseTable(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_inf.create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_inf.table_name);
        onCreate(db);
    }

    public void add_table(table_inf t) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(table_inf.table_chair, t.getnOfChiars());
        value.put(table_inf.table_valid, 1);

        db.insert(table_inf.table_name, null, value);
    }

    public ArrayList<table_inf> get_tables() {

        ArrayList<table_inf> tables = new ArrayList<>();
        String select_query = "SELECT * FROM " + table_inf.table_name + " WHERE valid = " + 1 + " ORDER BY "+table_inf.table_chair + " ASC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);
        if (cursor != null) {
            cursor.moveToFirst();
            do {
                int id = cursor.getInt(cursor.getColumnIndex(table_inf.table_id));
                int nofchair = cursor.getInt(cursor.getColumnIndex(table_inf.table_chair));
                boolean valid = (cursor.getInt(cursor.getColumnIndex(table_inf.table_valid)) == 1);
                tables.add(new table_inf(id, nofchair, valid));
            } while (cursor.moveToNext());

            cursor.close();
            db.close();
        }
        return tables;
    }

    public table_inf table_by_id(int id_c) {

        table_inf table = null;
        String select_query = "SELECT * FROM " + table_inf.table_name + " WHERE ID = " + id_c;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor != null) {
            cursor.moveToFirst();
            int id = cursor.getInt(cursor.getColumnIndex(table_inf.table_id));
            int nofchair = cursor.getInt(cursor.getColumnIndex(table_inf.table_chair));
            boolean valid = (cursor.getInt(cursor.getColumnIndex(table_inf.table_valid)) == 1);
            table = new table_inf(id, nofchair, valid);

            cursor.close();
            db.close();
        }
        return table;
    }

    public void update_table(table_inf t) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(table_inf.table_chair, t.getnOfChiars());
        int valid = t.isValid() ? 1 : 0;
        value.put(table_inf.table_valid, valid);

        db.update(table_inf.table_name, value, "id=?", new String[]{String.valueOf(t.getId())});
    }

    public void delete_data (){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("DELETE FROM "+ table_inf.table_name); //delete table
    }

    public void revaild_table (int id,boolean valid){
        table_inf tbl = table_by_id(id);
        tbl.setValid(valid);
        update_table(tbl);
    }
}
