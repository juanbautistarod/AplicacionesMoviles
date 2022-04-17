package com.example.appjuegotp2;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView displayRandomN, actualScore, displayHighscore;
    EditText inputN;
    Button btn1;
    String stringRandomN, highscore;
    Integer randomN, newScore, mistakes;
    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayRandomN = (TextView) findViewById(R.id.textView4);
        btn1 = (Button) findViewById(R.id.button);
        inputN = (EditText) findViewById(R.id.editTextNumber);
        actualScore = (TextView) findViewById(R.id.textView6);
        displayHighscore = (TextView) findViewById(R.id.textView8);
        newScore = 0;
        mistakes = 0;

        loadPreferences();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (inputN.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "¡Debe ingresar un número!", Toast.LENGTH_LONG).show();
                } else {
                    if (Integer.parseInt(String.valueOf(inputN.getText())) > 5 || Integer.parseInt(String.valueOf(inputN.getText())) < 1 || "".equals(inputN.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "¡El número debe estar entre 1 y 5!", Toast.LENGTH_LONG).show();
                    } else {
                        //Acá generamos el nro aleatorio entre 1 y 5, con la librería "random" que importamos
                        randomN = random.nextInt(4 + 1) + 1;
                        stringRandomN = randomN.toString();
                        displayRandomN.setText(stringRandomN);

                        if (String.valueOf(inputN.getText()).equals(stringRandomN)) {
                            newScore = Integer.parseInt(String.valueOf(actualScore.getText())) + 10;
                            actualScore.setText(newScore.toString());
                            mistakes = 0;
                        } else {
                            mistakes = mistakes + 1;
                        }
                    }
            }

                if (mistakes == 5) {
                    Toast.makeText(getApplicationContext(), "¡5 errores! Perdiste", Toast.LENGTH_LONG).show();
                    actualScore.setText("0");
                    mistakes = 0;
                }

                if (Integer.parseInt(String.valueOf(actualScore.getText())) > Integer.parseInt(String.valueOf(displayHighscore.getText()))) {
                    savePreferences();
                }
            }
        });
    }

    private void savePreferences() {
        SharedPreferences prefs = getSharedPreferences("data", Context.MODE_PRIVATE);

        highscore = actualScore.getText().toString();

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("highscore", highscore);

        displayHighscore.setText(highscore);
        editor.commit();

    }

    private void loadPreferences() {
        SharedPreferences prefs = getSharedPreferences("data", Context.MODE_PRIVATE);

        String highscore = prefs.getString("highscore", "0");
        displayHighscore.setText(highscore);
    }

}
