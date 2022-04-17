package com.example.loginappsmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnRegister;
    EditText txtUser, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button)findViewById(R.id.btnlogin);
        btnRegister = (Button)findViewById(R.id.btnregister);
        txtUser = (EditText)findViewById(R.id.editTextTextPersonName);
        txtPass = (EditText)findViewById(R.id.editTextTextPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txtUser.getText().toString().equals("Juan Torres") && txtPass.getText().toString().equals("1234utn")) {
                    Intent i = new Intent( MainActivity.this, Bienvenida.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Los datos son incorrectos", Toast.LENGTH_LONG).show();
                };

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent( MainActivity.this, Register.class);
                startActivity(i);
            }
        });
    }
}