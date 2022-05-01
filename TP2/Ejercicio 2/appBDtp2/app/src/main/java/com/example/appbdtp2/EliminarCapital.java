package com.example.appbdtp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appbdtp2.utilidades.Utilidades;

public class EliminarCapital extends AppCompatActivity {

    Button btn1, btn2;
    ConexionSQLiteHelper conn;
    EditText searchCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_capital);

        btn1 = (Button)findViewById(R.id.button11);
        btn2 = (Button)findViewById(R.id.button10);
        conn = new ConexionSQLiteHelper(getApplicationContext(), "db_ciudades", null, 1);
        searchCity = (EditText)findViewById(R.id.editTextTextPersonName3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EliminarCapital.this, MainActivity.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (searchCity.getText().toString().equals("")) {

                    Toast.makeText(getApplicationContext(), "No pueden haber campos vacíos", Toast.LENGTH_LONG).show();

                } else {

                    SQLiteDatabase db = conn.getReadableDatabase();
                    String[] parametros = {searchCity.getText().toString()};

                    db.delete(Utilidades.TABLA_CIUDAD, Utilidades.CAMPO_NOMBRE + "=?", parametros);
                    Toast.makeText(getApplicationContext(), "¡La ciudad se eliminó correctamente!", Toast.LENGTH_LONG).show();
                    db.close();
                }
            }
        });

    }
}