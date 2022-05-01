package com.example.appbdtp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class EliminarTodas extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btn1, btn2;
    ConexionSQLiteHelper conn;
    String paisCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_todas);

        paisCity = "Argentina"; //Pais por defecto en caso de no cambiarlo
        btn1 = (Button)findViewById(R.id.button12);
        btn2 = (Button)findViewById(R.id.button13);
        conn = new ConexionSQLiteHelper(getApplicationContext(), "db_ciudades", null, 1);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = conn.getReadableDatabase();

                db.delete("ciudad", "pais = '" + paisCity + "'", null);

                Toast.makeText(getApplicationContext(), "¡Todas las ciudades fueron eliminadas con éxito!", Toast.LENGTH_LONG).show();
                db.close();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EliminarTodas.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        paisCity = text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //Método generado automaticamente por el AdapterView
    }
}