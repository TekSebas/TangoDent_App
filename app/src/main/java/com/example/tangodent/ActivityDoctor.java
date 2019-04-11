package com.example.tangodent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityDoctor extends AppCompatActivity implements View.OnClickListener{

    Button botonCita,botonEventos,botonOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        botonCita=findViewById(R.id.botonTomaCitas);
        botonEventos=findViewById(R.id.botonCalendario);
        botonOpciones=findViewById(R.id.botonOpcionesUser);

        botonCita.setOnClickListener(this);
        botonEventos.setOnClickListener(this);
        botonOpciones.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){





        }
    }
}
