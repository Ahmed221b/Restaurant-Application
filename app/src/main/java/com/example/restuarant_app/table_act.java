package com.example.restuarant_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class table_act extends AppCompatActivity {

    ListView table_list;
    ArrayList<table_inf> tables;
    table_class tbl_adbt;
    public static DatabaseTable db;


    NavigationView navView;
    Button List;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(R.drawable.backgroundblur);
        setContentView(R.layout.act_table);
        db = new DatabaseTable(getApplicationContext()); //data base
        create();



        List =findViewById(R.id.menuBtn);
        drawerLayout =findViewById(R.id.draw_layout);

        List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.food_menu:

                        Intent intent = new Intent(table_act.this, MainActivity3.class);
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(), "food", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.contactUs:


                        Intent intent3 = new Intent(table_act.this, contact_act.class);
                        startActivity(intent3);

                        Toast.makeText(getApplicationContext(), "contact", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.about:

                        Intent intent4 = new Intent(table_act.this, rate_act.class);
                        startActivity(intent4);
                        Toast.makeText(getApplicationContext(), "rate", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.checkout:

                        Intent intent2 = new Intent(table_act.this, MainActivity2.class);
                        startActivity(intent2);

                        Toast.makeText(getApplicationContext(), "out", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });





    }

    private void create() {

            db.delete_data();
            db.add_table(new table_inf(2));
            db.add_table(new table_inf(2));
            db.add_table(new table_inf(2));
            db.add_table(new table_inf(3));
            db.add_table(new table_inf(3));
            db.add_table(new table_inf(4));
            db.add_table(new table_inf(4));
            db.add_table(new table_inf(4));
            db.add_table(new table_inf(5));
            db.add_table(new table_inf(6));

        try {
            table_list = (ListView) findViewById(R.id.tablelist);
            tables = db.get_tables();
            tbl_adbt = new table_class(this, R.layout.item_table, tables);
            table_list.setAdapter(tbl_adbt);
        } catch (Exception exception) {
            startActivity(new Intent(table_act.this, no_table.class));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        create();
    }

}