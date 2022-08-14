package com.example.restuarant_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class adapt2 extends RecyclerView.Adapter<adapt2.MyViewHolder> {

    private Context context;
    private ArrayList id;
    private ArrayList name;
    private ArrayList price;
    private ArrayList desc;
    private ArrayList img;
    //private ArrayList rate;
    private ArrayList quantity;
    private Activity a;

    public adapt2(Activity a,Context context, ArrayList id,
                  ArrayList name,
                  ArrayList price,
                  ArrayList desc,
                  ArrayList img,
                  ArrayList quantity){

        this.context=context;

        this.id =id;
        this.name=name;
        this.price=price;
        this.desc=desc;
        this.img=img;
        this.quantity=quantity;
        this.a=a;
        //this.rate=rate;
    }



    @NonNull
    @Override
    public adapt2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.activity_items,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull adapt2.MyViewHolder holder, int position) {
        String namee=String.valueOf(name.get(position));
        String descc=String.valueOf(desc.get(position));
        int imgg= Integer.parseInt(String.valueOf(img.get(position)));
        int quantityy= Integer.parseInt(String.valueOf(quantity.get(position)));
        int pricee= Integer.parseInt(String.valueOf(price.get(position)));
        String ID=String.valueOf(id.get(position));

        //int ratee= Integer.parseInt(String.valueOf(rate.get(position)));




        holder.the_name.setText(namee);
        holder.the_description.setText(descc);
        holder.the_img.setImageResource(imgg);


       //holder.the_Rate.setImageResource(Ratee);
        //holder.main.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //  public void onClick(View view) {
        //     Intent intent=new Intent(context,buy.class);
        //   intent.putExtra("name",name);
        // intent.putExtra("img",img);
        // context.startActivity(intent);


        //}



        holder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(context,checkout.class);
                intent.putExtra("name",namee);
                // intent.putExtra("desc",descc);
                intent.putExtra("img",imgg);
                intent.putExtra("quantity",quantityy);
                intent.putExtra("price",pricee);
                intent.putExtra("id",ID);
                //intent.putExtra("rate",ratee);
                //context.startActivity(intent);
                a.startActivityForResult(intent,1);

            }
        });





    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView the_name;
        TextView the_description;
        ImageView the_img;
        //ImageView the_Rate;
        LinearLayoutCompat main;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            the_name=itemView.findViewById(R.id.name_order);
            the_description=itemView.findViewById(R.id.nn);
            the_img=itemView.findViewById(R.id.order_name);
            //the_Rate=itemView.findViewById(R.id.Star_rating);
            main=itemView.findViewById(R.id.main);

        }


    }
}