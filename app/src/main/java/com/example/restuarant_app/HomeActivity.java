package com.example.restuarant_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private Button btn,menuBtn;
    private EditText txtname,txtnum;
    private TextView failMsg;
    static relatio r ;

    sql data=new sql(this);




    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        drawerLayout = findViewById(R.id.draw_layout);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()){
                    case R.id.food_menu:
                        Toast.makeText(getApplicationContext(), "Please Sign n", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.contactUs:
                        Toast.makeText(getApplicationContext(), "contact", Toast.LENGTH_SHORT).show();
                        intent = new Intent(HomeActivity.this, contact_act.class);
                        startActivity(intent);
                        break;

                    case R.id.about:
                        Toast.makeText(getApplicationContext(), "Please Sign in", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.checkout:
                        Toast.makeText(getApplicationContext(), "Please Sign in", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        failMsg = findViewById(R.id.fail);
        txtname = findViewById(R.id.txtName);
        txtnum = findViewById(R.id.txtNumber);
        btn= findViewById(R.id.orderBtn);
        menuBtn = findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtname.getText().toString().equals("") || txtnum.getText().toString().equals("") ) {
                    failMsg.setVisibility(View.VISIBLE);
                    return;
                }

                else{
                    customer c = new customer(txtname.getText().toString(),txtnum.getText().toString());
                    dataBaseHelper dbh = new dataBaseHelper(HomeActivity.this);
                    dbh.addOne(c);
                    r=new relatio(dbh.getLastId());
                    Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();

                    failMsg.setVisibility(View.GONE);

                    Intent intent =new Intent(HomeActivity.this,table_act.class);
                    startActivity(intent);
                    sql data= new sql(HomeActivity.this);
                    data.delete_all();

                }


            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}