package com.example.tipcalculatorapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.Slider;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button button;
    private TextInputLayout textInputLayout;
    private TextInputEditText tet;
    EditText editText;
    Slider slider;
    TextView tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slider = findViewById(R.id.slider);
//        editText = findViewById(R.id.editTextNumber);

        tt = findViewById(R.id.textView);
        tet = findViewById(R.id.amount);
        button = findViewById(R.id.button);

        addListenerOnButton();


    }

        public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String BillAmount = Objects.requireNonNull(tet.getText()).toString();
                String TipPercentage = String.valueOf(slider.getValue());
                float billAmt =Float.parseFloat(BillAmount);
                float b = Float.parseFloat(TipPercentage);
                float tipAmt = billAmt*b/100;
                String TipAmount = Float.toString(tipAmt);
                Intent intent = new Intent(context, final_screen.class);
                intent.putExtra("BillAmt",BillAmount);
                intent.putExtra("TipAmt",TipAmount);
                startActivity(intent);
                overridePendingTransition(R.anim.animate, R.anim.animeleft);
            }

        });
    }
}
