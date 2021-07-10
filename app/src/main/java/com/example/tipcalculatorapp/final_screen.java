package com.example.tipcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class final_screen extends AppCompatActivity {
    TextView ba;
    TextView ta;
    String rupees = Character.toString((char)8377);
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);
        Intent intent = getIntent();
        String billAmount = intent.getStringExtra("BillAmt");
        float k = Float.parseFloat(billAmount);
        billAmount = String.format("%.2f",k);
        ba = findViewById(R.id.billamt);
        billAmount = rupees +" "+ billAmount;
        ba.setText(billAmount);
        String tipAmount = intent.getStringExtra("TipAmt");
        ta = findViewById(R.id.tipamt);
        tipAmount = rupees +" "+tipAmount;

        ta.setText(tipAmount);
    }
}