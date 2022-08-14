package com.example.restuarant_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class sql extends SQLiteOpenHelper {

    private Context context;

    SQLiteDatabase a;

    public static final String database_name = "rt.db";
    public static final int version = 1;
    public static final String table_name = "orders";

    public static final String id = "id";
    private static final String name = "name";
    private static final String price = "price";
    private static final String description = "description";
    private static final String img = "img";
    private static final String quantity = "quantity";

    public sql(@Nullable Context context) {
        super(context, database_name, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "create table " + table_name + " ( " + id + " integer primary key autoincrement, " + name + " text, " + price + " integer, "
                + description + " text," + img + " integer, " + quantity + " integer)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists " + table_name);
        onCreate(db);


    }

    void add_to_cart(String namee, int pricee, String descriptionn, int quantityy, int imgg) {
        //SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(name, namee);
        cv.put(price, pricee);
        cv.put(description, descriptionn);
        cv.put(quantity, quantityy);
        cv.put(img, imgg);
        a = getWritableDatabase();
        long r = a.insert(table_name, null, cv);
        if (r == -1) {
            Toast.makeText(context, "Item deleted", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(context, "Item added", Toast.LENGTH_SHORT).show();

        a.close();
    }

    Cursor items() {
        String query = "select * from " + table_name;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {

            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void update_price_quantity(String q, String p, String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(price, p);
        cv.put(quantity, q);

        db.update(table_name, cv, "id=?", new String[]{ID});
    }

    void delete(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_name, "id=?", new String[]{ID});
    }

    void delete_all() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + table_name);
    }


    int cal() {
        int total = 0;
        String query = "select sum(" + price + ") from " + table_name;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {

            cursor = db.rawQuery(query, null);
        }
        if (cursor.moveToFirst())
            total = cursor.getInt(0);

        return total;

    }

    public int getLastId() {
        int _id = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(table_name, new String[]{id}, null, null, null, null, null);

        if (cursor.moveToLast()) {
            _id = cursor.getInt(0);
        }

        cursor.close();
        db.close();
        return _id;
    }
}