package com.example.restuarant_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class checkout extends AppCompatActivity {

    Button cancel;
    int count;
    TextView counter,name,price;
    ImageView img;
    ImageButton plus,minus;

    String namee;
    int imgg;
    int quantityy;
    int pricee;
    int p;

    String id;

    boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        cancel=findViewById(R.id.cancel_all);
        counter=findViewById(R.id.counttt);
        name=findViewById(R.id.name__order2);
        price=findViewById(R.id.price2);
        plus=findViewById(R.id.add_btn2);
        minus=findViewById(R.id.minus_btn2);
        img=findViewById(R.id.imageView3);

        final MediaPlayer mediaPlayer3 = MediaPlayer.create(this,R.raw.add_to_cart);
        final MediaPlayer mediaPlayer2 = MediaPlayer.create(this,R.raw.plus_minus);

        getdata();
        setdata();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer3.start();

                sql data= new sql(checkout.this);
                data.delete(id);
                flag=false;

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer2.start();

                if(flag) {


                    count++;
                    counter.setText(String.valueOf(count));

                    if (count == 1)
                        pricee = p;

                    else
                        pricee = p * count;
                    price.setText(String.valueOf(pricee));

                    sql data = new sql(checkout.this);
                    data.update_price_quantity(String.valueOf(count), String.valueOf(pricee), id);

                }
                else
                    Toast.makeText(checkout.this, "No Items", Toast.LENGTH_SHORT).show();


            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer2.start();

                if(flag){
                    if(count!=0){
                        pricee=pricee-p;
                        price.setText(String.valueOf(pricee));
                        count--;
                        counter.setText(String.valueOf(count));
                        sql data= new sql(checkout.this);
                        data.update_price_quantity(String.valueOf(count),String.valueOf(pricee),id);



                    }
                    else
                        Toast.makeText(checkout.this, "you can't cancel", Toast.LENGTH_SHORT).show();}

                else
                    Toast.makeText(checkout.this, "this item is deleted", Toast.LENGTH_SHORT).show();




            }
        });

    }


    private void getdata(){
        if(getIntent().hasExtra("name")&&getIntent().hasExtra("img")&&getIntent().hasExtra("quantity")&&getIntent().hasExtra("price")){

            namee=getIntent().getStringExtra("name");
            imgg=getIntent().getIntExtra("img",1);
            pricee=getIntent().getIntExtra("price",1);
            count=getIntent().getIntExtra("quantity",1);
            p=pricee/count;
            id=getIntent().getStringExtra("id");



        }
    }

    private void setdata(){
        name.setText(namee);
        img.setImageResource(imgg);
        counter.setText(String.valueOf(count));
        price.setText(String.valueOf(pricee));

    }


}