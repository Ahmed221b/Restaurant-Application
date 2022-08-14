package com.example.restuarant_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity {

    Button addto;
    int count=0;
    TextView counter,name,price;
    ImageView img;
    ImageButton plus,minus;
    int pprice;
    String namee;
    int imgg;
    int p;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        addto=findViewById(R.id.add_cart);
        counter=findViewById(R.id.countt);
        name=findViewById(R.id.name__order);
        price=findViewById(R.id.price);
        plus=findViewById(R.id.add_btn);
        minus=findViewById(R.id.minus_btn);
        img=findViewById(R.id.imageView2);

        final MediaPlayer mediaPlayer2 = MediaPlayer.create(this,R.raw.plus_minus);
        final MediaPlayer mediaPlayer3 = MediaPlayer.create(this,R.raw.add_to_cart);


        addto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer3.start();

                if (count!=0) {
                    sql data = new sql(ShowActivity.this);
                    data.add_to_cart(namee,pprice, "ab", count, imgg);
                    HomeActivity.r.setO(data.getLastId());
                    Intent intent =new Intent(ShowActivity.this,MainActivity3.class);
                    startActivity(intent);
                    }
                else
                    Toast.makeText(ShowActivity.this,"error",Toast.LENGTH_SHORT).show();

            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer2.start();

                count++;
                counter.setText(String.valueOf(count));

                if (count == 1)
                    pprice = p;

                else
                    pprice = p * count;
                price.setText(String.valueOf(pprice));

          //      sql data = new sql(ShowActivity.this);
            //    data.update_price_quantity(String.valueOf(count), String.valueOf(pprice), id);

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer2.start();

                if(count!=0){
                pprice=pprice-p;
                price.setText(String.valueOf(pprice));
                    count--;
                    counter.setText(String.valueOf(count));
                }
                else
                        Toast.makeText(ShowActivity.this, "Error", Toast.LENGTH_SHORT).show();


            }
        });
        getdata();
        setdata();

    }

    private void getdata(){
        if(getIntent().hasExtra("name")&&getIntent().hasExtra("img")&&getIntent().hasExtra("price")){

            namee=getIntent().getStringExtra("name");
            pprice=getIntent().getIntExtra("price",1);
            imgg=getIntent().getIntExtra("img",1);
            p=pprice;

        }
    }

    private void setdata(){
        name.setText(namee);
        img.setImageResource(imgg);
        price.setText(String.valueOf(pprice));
    }
}