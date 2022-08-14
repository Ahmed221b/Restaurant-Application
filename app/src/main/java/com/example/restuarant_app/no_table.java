package com.example.restuarant_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class no_table extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_table);
        getWindow().setBackgroundDrawableResource(R.drawable.backgroundblur);
    }
}