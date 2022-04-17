package com.example.loginappsmoviles;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Bienvenida extends AppCompatActivity {

    RadioButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    ImageView imgAndroid, imgApple;
    EditText pInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida2);

        btn1 = (RadioButton)findViewById(R.id.radioButton);
        btn2 = (RadioButton)findViewById(R.id.radioButton2);
        btn3 = (RadioButton)findViewById(R.id.radioButton13);
        btn4 = (RadioButton)findViewById(R.id.radioButton12);
        btn5 = (RadioButton)findViewById(R.id.radioButton11);
        btn6 = (RadioButton)findViewById(R.id.radioButton10);
        btn7 = (RadioButton)findViewById(R.id.radioButton9);
        pInput = (EditText)findViewById(R.id.editTextTextPreference);

        imgAndroid = (ImageView)findViewById(R.id.imageView2);
        imgApple = (ImageView)findViewById(R.id.imageView4);

        pInput.setVisibility(View.INVISIBLE);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imgApple.setVisibility(View.INVISIBLE);
                imgAndroid.setVisibility(View.VISIBLE);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imgApple.setVisibility(View.VISIBLE);
                imgAndroid.setVisibility(View.INVISIBLE);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    pInput.setVisibility(View.INVISIBLE);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    pInput.setVisibility(View.INVISIBLE);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    pInput.setVisibility(View.INVISIBLE);

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    pInput.setVisibility(View.INVISIBLE);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    pInput.setVisibility(View.VISIBLE);
            }
        });
        }

    }
