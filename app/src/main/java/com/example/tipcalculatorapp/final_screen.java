package com.example.tipcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class final_screen extends AppCompatActivity {
    TextView ba;
    TextView ta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);
//        Bundle bundle = getIntent().getExtras();
//        billAmount = bundle.getString("BillAmt");
//        tipAmount = bundle.getString("TipAmt");
        Intent intent = getIntent();
        String billAmount = intent.getStringExtra("BillAmt");
        ba = findViewById(R.id.billamt);
        ba.setText(billAmount);
        String tipAmount = intent.getStringExtra("TipAmt");
        ta = findViewById(R.id.tipamt);
        ta.setText(String.valueOf(tipAmount));
    }
}