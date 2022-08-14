package com.example.restuarant_app;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dataBaseHelper extends SQLiteOpenHelper {

    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String CUSTOMER_NAME = "COL_CUSTOMER_NAME";
    public static final String CUSTOMER_PHONE = "COL_CUSTOMER_PHONE";
    public static final String COL_ID = "ID";

    public dataBaseHelper(@Nullable Context context) {

        super(context, "customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatment = "CREATE TABLE " + CUSTOMER_TABLE + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + CUSTOMER_NAME + " TEXT," + CUSTOMER_PHONE + " INTEGER)";
        sqLiteDatabase.execSQL(createTableStatment);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }


    public boolean addOne (customer customer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CUSTOMER_NAME,customer.getName());
        cv.put(CUSTOMER_PHONE,customer.getPhoneNumber());

        db.insert(CUSTOMER_TABLE,null,cv);
        return true;
    }


    public customer last_raw (){
        customer cust=null;
        String select_query = "SELECT * FROM " + CUSTOMER_TABLE+ " WHERE id=(SELECT max(id) FROM "+CUSTOMER_TABLE+")";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);
        if (cursor != null) {
            cursor.moveToLast();
            String name= cursor.getString(cursor.getColumnIndex(CUSTOMER_NAME));
            String phoneNumber= cursor.getString(cursor.getColumnIndex(CUSTOMER_PHONE));
            cust = new customer(name, phoneNumber);
            cursor.close();
            db.close();
        }
        return cust;
    }

    public int getLastId() {
        int _id = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(CUSTOMER_TABLE, new String[] {COL_ID}, null, null, null, null, null);

        if (cursor.moveToLast()) {
            _id = cursor.getInt(0);
        }

        cursor.close();
        db.close();
        return _id;
    }

}

