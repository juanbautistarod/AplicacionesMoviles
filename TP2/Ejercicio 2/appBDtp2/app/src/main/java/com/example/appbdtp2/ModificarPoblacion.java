package com.example.appbdtp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appbdtp2.utilidades.Utilidades;

public class ModificarPoblacion extends AppCompatActivity {

    EditText searchCity, newPobCity;
    Button btn1, btn2;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_poblacion);

        btn1 = (Button)findViewById(R.id.button14);
        btn2 = (Button)findViewById(R.id.button15);
        searchCity = (EditText)findViewById(R.id.editTextTextPersonName4);
        newPobCity = (EditText)findViewById(R.id.editTextNumber2);
        conn = new ConexionSQLiteHelper(getApplicationContext(), "db_ciudades", null, 1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (searchCity.getText().toString().equals("") || newPobCity.getText().toString().equals("")) {

                    Toast.makeText(getApplicationContext(), "No pueden haber campos vacíos", Toast.LENGTH_LONG).show();

                } else {

                    SQLiteDatabase db = conn.getWritableDatabase();
                    String[] parametros = {searchCity.getText().toString()};
                    ContentValues values = new ContentValues();
                    values.put(Utilidades.CAMPO_POBLACION, newPobCity.getText().toString());

                    db.update(Utilidades.TABLA_CIUDAD, values, Utilidades.CAMPO_NOMBRE + "=?", parametros);
                    Toast.makeText(getApplicationContext(),"¡Población modificada con éxito!", Toast.LENGTH_LONG).show();
                    db.close();

                }
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ModificarPoblacion.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}