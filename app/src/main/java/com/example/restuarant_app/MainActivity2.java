package com.example.restuarant_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView r2;
    ArrayList<String>name,price,desc,quantity,img,id;
    sql data;
    adapt2 a2;
    Button del;
    Button pay;
    dataBaseHelper db;
    DatabaseTable db_t;
    TextView cust_name , cust_phone,table_num;

    TextView total;



    NavigationView navView;
    Button List;
    DrawerLayout drawerLayout;

    int total_price=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db = new dataBaseHelper(getApplicationContext());
        customer cust = db.last_raw();
        cust_name = (TextView) findViewById(R.id.name_data) ;
        cust_phone = (TextView) findViewById(R.id.phone_data) ;
        table_num = (TextView) findViewById(R.id.Table_num);
        cust_name.setText(cust.getName());
        cust_phone.setText(cust.getPhoneNumber());
        table_inf t = table_act.db.table_by_id(HomeActivity.r.getT());
        table_num.setText(String.valueOf(t.getId()));
        db_t = new DatabaseTable(getApplicationContext());

    //    Cursor cursor2 = data.cal();

      //  if(cursor2.moveToFirst()) {

        //}



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

                        Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(), "food", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.contactUs:


                        Intent intent3 = new Intent(MainActivity2.this, contact_act.class);
                        startActivity(intent3);

                        Toast.makeText(getApplicationContext(), "contact", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.about:
                        Toast.makeText(getApplicationContext(), "rate", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity2.this, rate_act.class);
                        Toast.makeText(getApplicationContext(), "about", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.checkout:

                        Intent intent2 = new Intent(MainActivity2.this, MainActivity2.class);
                        startActivity(intent2);

                        Toast.makeText(getApplicationContext(), "out", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });







        r2=findViewById(R.id.rtyu);
        data=new sql(MainActivity2.this);


        name=new ArrayList<>();
        price =new ArrayList<>();
        desc=new ArrayList<>();
        quantity=new ArrayList<>();
        img=new ArrayList<>();
        id=new ArrayList<>();
        //rate=new ArrayList<>();
        del=findViewById(R.id.delete);
        pay=(Button) findViewById(R.id.Pay);


        final MediaPlayer mediaPlayer4 = MediaPlayer.create(this,R.raw.delete);


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer4.start();
                sql data= new sql(MainActivity2.this);
                db_t.revaild_table(HomeActivity.r.getT(),true);
                sql_relatio raw = new sql_relatio(MainActivity2.this);
                raw.add_re(HomeActivity.r);
                data.delete_all();
                Intent intent =new Intent(MainActivity2.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });




        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer4.start();

                sql data= new sql(MainActivity2.this);
                db_t.revaild_table(HomeActivity.r.getT(),true);
                sql_relatio raw = new sql_relatio(MainActivity2.this);
                raw.add_re(HomeActivity.r);
                data.delete_all();
                Intent intent =new Intent(MainActivity2.this,HomeActivity.class);
                startActivity(intent);
                finish();

            }
        });



        display_items();
        total_price=data.cal();
        total=findViewById(R.id.price_total);

        total.setText(String.valueOf(total_price));
        a2=new adapt2(MainActivity2.this,this,id,name,price,desc,img,quantity);

        r2.setLayoutManager(new LinearLayoutManager(this));
        r2.setAdapter(a2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            recreate();
        }
    }

    void display_items() {
        Cursor cursorr = data.items();
        if(cursorr.getCount()==0) {
            Toast.makeText(MainActivity2.this, "No Items", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursorr.moveToNext()){
                id.add(cursorr.getString(0));
                name.add(cursorr.getString(1));
                price.add(cursorr.getString(2));
                desc.add(cursorr.getString(3));
                img.add(cursorr.getString(4));
                quantity.add(cursorr.getString(5));
                //Rate.add(cursorr.getString(6));

            }
        }
    }

}