package com.example.appbdtp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appbdtp2.utilidades.Utilidades;

public class CargarCapital extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btn1, btn2;
    EditText nomCity, pobCity;
    String paisCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_capital);

        nomCity = (EditText)findViewById(R.id.editTextTextPersonName);
        pobCity = (EditText)findViewById(R.id.editTextNumber);
        paisCity = "Argentina"; //Pais por defecto en caso de no cambiarlo
        btn1 = (Button)findViewById(R.id.button6);
        btn2 = (Button)findViewById(R.id.button7);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nomCity.getText().toString().equals("") || pobCity.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "No pueden haber campos vacíos",Toast.LENGTH_LONG).show();
                } else {
                    registrarCiudadSQL();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(CargarCapital.this, MainActivity.class);
                startActivity(i2);
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

    private void registrarCiudadSQL(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"db_ciudades", null, 1);
        SQLiteDatabase db=conn.getWritableDatabase();

        String insert="INSERT INTO " + Utilidades.TABLA_CIUDAD
                +" ( " + Utilidades.CAMPO_NOMBRE + ", " + Utilidades.CAMPO_PAIS + ", " + Utilidades.CAMPO_POBLACION + ") " +
                "VALUES ('"+ nomCity.getText().toString() +"', '"+ paisCity + "', " + pobCity.getText().toString() + ")";
        db.execSQL(insert);
        Toast.makeText(getApplicationContext(), "¡Ciudad cargada con éxito!", Toast.LENGTH_LONG).show();
        db.close();
    }
}

