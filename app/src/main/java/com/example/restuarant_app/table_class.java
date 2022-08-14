package com.example.restuarant_app;

import android.content.Intent;
import de.hdodenhof.circleimageview.CircleImageView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class table_class extends ArrayAdapter<table_inf> {

    Context context;
    int resource;
    public Activity activity;
    sql s;


    public table_class(@NonNull Context context, @LayoutRes int resource, @NonNull List<table_inf> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        s = new sql(context);

        convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        CircleImageView img = (CircleImageView) convertView.findViewById(R.id.id_table);
        Button btn = (Button) convertView.findViewById(R.id.id_button);
        TextView txt = (TextView) convertView.findViewById(R.id.id_chair);

        table_inf tbl = getItem(position);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(context, "Table selected", Toast.LENGTH_SHORT).show();
                int table_id = tbl.getId();
                HomeActivity.r.setT(table_id);
                table_act.db.revaild_table(table_id,false);

                img.setCircleBackgroundColor(0x000000);
                img.setBorderColor(0xFF018786);
                img.setBorderWidth(5);
                btn.setTextColor(Color.DKGRAY);
                btn.setText("Unavailable");
                txt.setTextColor(Color.DKGRAY);
                txt.setText("0 Chair");

                Intent intent =new Intent(context,MainActivity3.class);
                context.startActivity(intent);

            }
        });
        if (tbl.isValid() == true) {
            img.setCircleBackgroundColor(0xFF018786);
            btn.setText("Available");
            txt.setTextColor(Color.WHITE);
            txt.setText(String.valueOf(tbl.getnOfChiars()) + " Chair");
        }

        return convertView;
    }
}