package com.example.appbdtp2;

import static com.example.appbdtp2.utilidades.Utilidades.CAMPO_POBLACION;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appbdtp2.utilidades.Utilidades;

public class ConsultarCapital extends AppCompatActivity {

    Button btn1, btn2;
    EditText searchCity;
    TextView paisCity, pobCity;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_capital);

        btn1 = (Button)findViewById(R.id.button8);
        btn2 = (Button)findViewById(R.id.button9);
        searchCity = (EditText)findViewById(R.id.editTextTextPersonName2);
        paisCity = (TextView) findViewById(R.id.textView9);
        pobCity = (TextView) findViewById(R.id.textView11);
        conn = new ConexionSQLiteHelper(getApplicationContext(), "db_ciudades", null, 1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConsultarCapital.this, MainActivity.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = conn.getReadableDatabase();
                String[] parametros = {searchCity.getText().toString()};
                String[] campos = {Utilidades.CAMPO_PAIS, Utilidades.CAMPO_POBLACION};

                try {

                    Cursor cursor = db.query(Utilidades.TABLA_CIUDAD, campos, Utilidades.CAMPO_NOMBRE + "=?", parametros, null, null, null);
                    cursor.moveToFirst();
                    paisCity.setText(cursor.getString(0));
                    pobCity.setText(cursor.getString(1));
                    cursor.close();

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "¡Esa ciudad NO esta cargada en la BD!", Toast.LENGTH_LONG).show();
                    cleanScreen();

                }
            }
        });
    }

    private void cleanScreen() {
        paisCity.setText("No se ingresó ninguna ciudad.");
        pobCity.setText("0");
    }
}