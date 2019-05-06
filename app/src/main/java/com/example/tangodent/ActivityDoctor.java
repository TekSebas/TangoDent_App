package com.example.tangodent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tangodent.Conexion.ConexionSQLiteHelper;

public class ActivityDoctor extends AppCompatActivity implements View.OnClickListener{

    Button botonCita,botonEventos,botonOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"tangodentdb",null,1);

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

            case R.id.botonTomaCitas:

                Intent intentCitas= new Intent(this, ActivityRegistroCitas.class);



                startActivity(intentCitas);


                break;
            case R.id.botonCalendario:




                break;
            case R.id.botonOpcionesUser:




                break;


        }
    }
}
