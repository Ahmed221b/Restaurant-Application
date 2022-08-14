package com.example.restuarant_app;
import com.example.restuarant_app.Model;
import com.example.restuarant_app.ShowActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder> {


    List<Model> modelList;
    Context context;
    public OrderAdapter(Context context, List<Model> modelList){
        this.context=context;
        this.modelList=modelList;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.listitem,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

        String nameofFood = modelList.get(position).getmFoodName();
        String discripeofFood = modelList.get(position).getmFoodDetail();
        int PriceFood = modelList.get(position).getmFoodPrice();
        int imagesofFood = modelList.get(position).getmFoodPhoto();
        int RatefFood = modelList.get(position).getmFoodRate();

        holder.mFoodName.setText(nameofFood);
        holder.mFoodDescription.setText(discripeofFood);
        holder.imageView.setImageResource(imagesofFood);
        holder.imageView2.setImageResource(RatefFood);


        holder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowActivity.class);
                intent.putExtra("name",nameofFood);
                intent.putExtra("img",imagesofFood);
                intent.putExtra("price",PriceFood);
                intent.putExtra("Star_rating",RatefFood);
                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {

        return modelList.size();
    }



    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mFoodName,mFoodDescription;
        ImageView imageView;
        ImageView imageView2;
        LinearLayoutCompat main;


        public viewHolder(View itemView) {
            super(itemView);
            mFoodName = itemView.findViewById(R.id.name_order);
            mFoodDescription = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.order_name);
            imageView2 = itemView.findViewById(R.id.Star_rating);
            main=itemView.findViewById(R.id.main);

        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();

        }
    }

}
