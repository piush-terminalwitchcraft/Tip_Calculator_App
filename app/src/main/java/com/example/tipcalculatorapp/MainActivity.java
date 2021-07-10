package com.example.tipcalculatorapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.Slider;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button button;
    private TextInputLayout textInputLayout;
    private TextInputEditText tet;
    Slider slider;
    TextView tt;
    EditText tt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slider = findViewById(R.id.slider);
//        editText = findViewById(R.id.editTextNumber);

        tt = findViewById(R.id.textView);
        tet = findViewById(R.id.amount);
        button = findViewById(R.id.button);
        tt2 = findViewById(R.id.tt2);
        tt2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                slider.setValue(0.00f);
                tt2.setSelection(tt2.getText().length());
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length() != 0){
                float k = Float.parseFloat(s.toString());
                    if(k>=0 && k<=10){
                        slider.setValue(k);
                    }
                }
                else if(s.toString().length()==2){
                    tt2.getText().clear();
                }
            }
        });
        slider.addOnChangeListener(new Slider.OnChangeListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                //Use the value
                String f = String.valueOf(slider.getValue());
//                String val = String.valueOf(slider.getValue());
                if(f.length()>3){
                f = String.format("%.2f",slider.getValue());

                }
                tt2.setText(f);
            }
        });
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
                float tipAmt = billAmt*b/100.00f;
                @SuppressLint("DefaultLocale") String TipAmount = String.format("%.2f",tipAmt);
                Intent intent = new Intent(context, final_screen.class);
                intent.putExtra("BillAmt",BillAmount);
                intent.putExtra("TipAmt",TipAmount);
                startActivity(intent);
                overridePendingTransition(R.anim.animate, R.anim.animeleft);
            }
        });

    }
}
