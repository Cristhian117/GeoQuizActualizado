package com.example.geoquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnVerdadero;
    private Button btnFalso;
    private Button btnSiguiente;
    private Button btnAtras;

    private TextView txtPregunta;

    private pregunta[] preguntas ={
        new pregunta(R.string.Pregunta_1,true),
        new pregunta(R.string.Pregunta_2,true ),
        new pregunta(R.string.Pregunta_3,true),
        new pregunta(R.string.Pregunta_4,true),
        new pregunta(R.string.Pregunta_5,false),

    };

    int actual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVerdadero = findViewById(R.id.btn_verdadero);
        btnFalso = findViewById(R.id.btn_falso);
        btnSiguiente = findViewById(R.id.btn_siguiente);
        btnAtras = findViewById(R.id.btn_atras);

        txtPregunta = findViewById(R.id.text_pregunta);

        txtPregunta.setText(preguntas[actual].getTextoId());


        btnVerdadero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
               boolean respuestas = preguntas[actual].isRepuesta();
               if (respuestas == true){
                   Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(MainActivity.this, "InCorrecto", Toast.LENGTH_SHORT).show();
               }
            }
        });

        btnFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //Toast.makeText(MainActivity.this, "InCorrecto", Toast.LENGTH_SHORT).show();
                boolean respuestas = preguntas[actual].isRepuesta();
                if (respuestas == false){
                    Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "InCorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                actual = (actual+1) % preguntas.length;
                txtPregunta.setText(preguntas[actual].getTextoId());

            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                actual = actual-1;
                if(actual == -1)
                    actual = preguntas.length-1;
                txtPregunta.setText(preguntas[actual].getTextoId());
            }
        });


        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }





}