package com.example.restuarant_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class rate_act extends AppCompatActivity {

    Button out;

    NavigationView navView;
    Button List;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_act);

        out = (Button) findViewById(R.id.outbtn);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Thanks for your opinion", Toast.LENGTH_SHORT).show();
            }
        });

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

                        Intent intent = new Intent(rate_act.this, MainActivity2.class);
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(), "food", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.contactUs:


                        Intent intent3 = new Intent(rate_act.this, contact_act.class);
                        startActivity(intent3);

                        Toast.makeText(getApplicationContext(), "contact", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.about:
                        Toast.makeText(getApplicationContext(), "rate", Toast.LENGTH_SHORT).show();
                        intent = new Intent(rate_act.this, rate_act.class);
                        Toast.makeText(getApplicationContext(), "about", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.checkout:

                        Intent intent2 = new Intent(rate_act.this, MainActivity2.class);
                        startActivity(intent2);

                        Toast.makeText(getApplicationContext(), "out", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}