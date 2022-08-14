package com.example.restuarant_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restuarant_app.Model;
import com.google.android.material.navigation.NavigationView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    List<Model> modelList,bb ,pizza , bbb, Burger ,bbbb ,Drink;
    RecyclerView recyclerView;
    OrderAdapter mAdapter,x,xx,xxx;

    Button move1;
    Button move2;
    Button move3;


    NavigationView navView;
    Button List;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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

                        Intent intent = new Intent(MainActivity3.this, MainActivity3.class);
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(), "food", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.contactUs:


                        Intent intent3 = new Intent(MainActivity3.this, contact_act.class);
                        startActivity(intent3);

                        Toast.makeText(getApplicationContext(), "contact", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.about:
                        Toast.makeText(getApplicationContext(), "rate", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity3.this, rate_act.class);
                        Toast.makeText(getApplicationContext(), "about", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.checkout:

                        Intent intent2 = new Intent(MainActivity3.this, MainActivity2.class);
                        startActivity(intent2);

                        Toast.makeText(getApplicationContext(), "out", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });








        modelList = new ArrayList<>();
        pizza = new ArrayList<>();
        Burger = new ArrayList<>();
        Drink = new ArrayList<>();


        modelList.add(new Model("Margherita", getString(R.string.Pizza1), R.drawable.margrita,20, R.drawable.star_rate4));
        modelList.add(new Model("Cheese Burger", getString(R.string.Burger1), R.drawable.cheeseburger,30, R.drawable.star_rate5));
        modelList.add(new Model("Rolled Ice Cream", getString(R.string.drink5), R.drawable.rolledicecream,15, R.drawable.star_rate3));
        modelList.add(new Model("Classic Pepperoni", getString(R.string.Pizza4), R.drawable.classicbayrone,25, R.drawable.star_rate5));
        modelList.add(new Model("Buffalo Burger", getString(R.string.Burger5), R.drawable.bufflo,30, R.drawable.star_rate4));
        modelList.add(new Model("Sherbet", getString(R.string.drink2), R.drawable.shetbet,5, R.drawable.star_rate1));
        modelList.add(new Model("Super Supreme", getString(R.string.Pizza3), R.drawable.supersoprem,25, R.drawable.star_rate5));
        modelList.add(new Model("Steak Burger", getString(R.string.Burger9), R.drawable.steakburger,20, R.drawable.star_rate4));
        modelList.add(new Model("Falooda", getString(R.string.drink4), R.drawable.falooda,1, R.drawable.star_rate3));




        pizza.add(new Model("Margherita", getString(R.string.Pizza1), R.drawable.margrita,20, R.drawable.star_rate4));
        pizza.add(new Model("Chicken Supreme", getString(R.string.Pizza2), R.drawable.chickensuperem,30, R.drawable.star_rate3));
        pizza.add(new Model("Classic Pepperoni", getString(R.string.Pizza4), R.drawable.classicbayrone,25, R.drawable.star_rate5));
        pizza.add(new Model("Vegetarian", getString(R.string.Pizza5), R.drawable.vegata,35, R.drawable.star_rate1));
        pizza.add(new Model("Prawn", getString(R.string.Pizza6), R.drawable.gambree,15, R.drawable.star_rate3));
        pizza.add(new Model("Super Supreme", getString(R.string.Pizza3), R.drawable.supersoprem,25, R.drawable.star_rate5));
        pizza.add(new Model("Cheese", getString(R.string.Pizza7), R.drawable.gbna,25, R.drawable.star_rate2));
        pizza.add(new Model("Sea Food", getString(R.string.Pizza8), R.drawable.fawkh,10, R.drawable.star_rate4));
        pizza.add(new Model("Spicy Chicken Ranch", getString(R.string.Pizza9), R.drawable.spaicecheken,25, R.drawable.star_rate5));




        Burger.add(new Model("Cheese Burger", getString(R.string.Burger1), R.drawable.cheeseburger,30, R.drawable.star_rate5));
        Burger.add(new Model("Mushroom Burger", getString(R.string.Burger2), R.drawable.portobello_mushroom_burger,35, R.drawable.star_rate4));
        Burger.add(new Model("50/50 burger", getString(R.string.Burger3), R.drawable.halfhalfburger,30, R.drawable.star_rate2));
        Burger.add(new Model("Chill Burger", getString(R.string.Burger4), R.drawable.chillburger,45, R.drawable.star_rate3));
        Burger.add(new Model("Buffalo Burger", getString(R.string.Burger5), R.drawable.bufflo,30, R.drawable.star_rate4));
        Burger.add(new Model("Rice Burger", getString(R.string.Burger6), R.drawable.riceburger,40, R.drawable.star_rate3));
        Burger.add(new Model("Salmon Burger", getString(R.string.Burger7), R.drawable.salmon,45, R.drawable.star_rate5));
        Burger.add(new Model("Luther Burger", getString(R.string.Burger8), R.drawable.lutherburger,30, R.drawable.star_rate1));
        Burger.add(new Model("Steak Burger", getString(R.string.Burger9), R.drawable.steakburger,20, R.drawable.star_rate4));



        Drink.add(new Model("Mochi", getString(R.string.drink1), R.drawable.mochi,10, R.drawable.star_rate3));
        Drink.add(new Model("Philadelphia Ice", getString(R.string.drink3), R.drawable.philadelphiaicecream,5, R.drawable.star_rate5));
        Drink.add(new Model("Sherbet", getString(R.string.drink2), R.drawable.shetbet,5, R.drawable.star_rate4));
        Drink.add(new Model("Falooda", getString(R.string.drink4), R.drawable.falooda,15, R.drawable.star_rate3));
        Drink.add(new Model("Rolled Ice Cream", getString(R.string.drink5), R.drawable.rolledicecream,1, R.drawable.star_rate4));
        Drink.add(new Model("Baobing", getString(R.string.drink6), R.drawable.baobing,3, R.drawable.star_rate5));
        Drink.add(new Model("Kulfi", getString(R.string.drink7), R.drawable.kulfi,4, R.drawable.star_rate2));
        Drink.add(new Model("Soft Serve", getString(R.string.drink8), R.drawable.softserve,3, R.drawable.star_rate5));
        Drink.add(new Model("Frozen Yogurt", getString(R.string.drink9), R.drawable.frozenyogurt,2, R.drawable.star_rate4));


        bb=modelList;
        bbb=modelList;
        bbbb= modelList;

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));

        mAdapter = new OrderAdapter(this, bb);
        mAdapter = new OrderAdapter(this, bbb);
        mAdapter = new OrderAdapter(this, bbbb);

        recyclerView.setAdapter(mAdapter);


        x = new OrderAdapter(this,pizza);
        move1=findViewById(R.id.Move_card11);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.btnsound);

        move1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(x);
                mediaPlayer.start();

            }
        });

        xx = new OrderAdapter(this,Burger);
        move2=findViewById(R.id.Move_card22);

        move2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(xx);
                mediaPlayer.start();
            }
        });

        xxx = new OrderAdapter(this,Drink);
        move3=findViewById(R.id.Move_card33);

        move3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(xxx);
                mediaPlayer.start();
            }
        });



        /*check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(intent);
                mediaPlayer.start();
            }
        });*/


    }
}