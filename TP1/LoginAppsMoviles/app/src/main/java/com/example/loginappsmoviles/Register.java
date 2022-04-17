package com.example.loginappsmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Register extends AppCompatActivity {

    EditText txtUser, txtEmail, txtPass, txtPass2;
    Boolean condition1, condition2;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        btnRegister = (Button)findViewById(R.id.buttonR);
        txtUser = (EditText)findViewById(R.id.editTextTextPersonName2);
        txtEmail = (EditText)findViewById(R.id.editTextTextEmailAddress);
        txtPass = (EditText)findViewById(R.id.editTextTextPassword2);
        txtPass2 = (EditText)findViewById(R.id.editTextTextPassword3);
        condition1 = false;
        condition2 = false;

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtUser.getText().toString().length() == 0 || txtEmail.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Los campos NO pueden estar vacíos", Toast.LENGTH_LONG).show();
                } else {
                    condition1 = true;
                }

                if (txtPass.getText().toString().length() < 6 || txtPass2.getText().toString().length() < 6) {
                    Toast.makeText(getApplicationContext(), "Los contraseña NO debe tener menos de 6 caracteres", Toast.LENGTH_LONG).show();
                } else {
                    condition2 = true;
                }

                if (!txtPass.getText().toString().equals(txtPass2.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Las contraseñas deben ser iguales", Toast.LENGTH_LONG).show();
                }

                if (condition1 && condition2 && Objects.equals(txtPass.getText().toString(), txtPass2.getText().toString())) {
                    Intent i = new Intent( Register.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });

    }
}