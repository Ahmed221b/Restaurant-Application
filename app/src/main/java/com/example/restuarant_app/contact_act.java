package com.example.restuarant_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class contact_act extends AppCompatActivity {

    Spinner questions;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_contact);
        create();
    }

    private void create() {
        questions = (Spinner) findViewById(R.id.spinner);
        answer = (TextView) findViewById(R.id.textView5);

        questions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> var1, View var2, int var3, long var4) {
                String SelectedOption = questions.getSelectedItem().toString();

                if (SelectedOption.equals("What is the address?")) {
                    answer.setText("Address : 30th St.San Francisco \nCalifornia - United States");

                } else if (SelectedOption.equals("What are the phone numbers?")) {
                    answer.setText("(415)550-8114 \n(225)215-9856");

                } else if (SelectedOption.equals("What are the working days?")) {
                    answer.setText("Open every day");

                } else if (SelectedOption.equals("What are the working hours?")) {
                    answer.setText("From 12 pm \nto 3 am");

                } else if (SelectedOption.equals("What are its pages on FaceBook and Instagram?")) {
                    answer.setText("FaceBook : OrDer Restaurant \nInstagram :  OrDer_Restaurant_22");

                } else if (SelectedOption.equals("How do you rate this restaurant?")) {
                    answer.setText("Restaurant rate : 4 Stars");

                } else {
                    answer.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                answer.setText("");
            }

        });
    }
}