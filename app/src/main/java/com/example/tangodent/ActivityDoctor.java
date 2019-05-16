package com.example.tangodent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tangodent.Conexion.ConexionSQLiteHelper;

public class ActivityDoctor extends AppCompatActivity implements View.OnClickListener {

    Button botonCita, botonEventos, botonOpciones, botonBA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "tangodentdb", null, 2);

        botonCita = findViewById(R.id.botonTomaCitas);
        botonEventos = findViewById(R.id.botonCalendario);
        botonOpciones = findViewById(R.id.botonOpcionesUser);
        botonBA = findViewById(R.id.botonBA);

        botonCita.setOnClickListener(this);
        botonEventos.setOnClickListener(this);
        botonOpciones.setOnClickListener(this);
        botonBA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.botonTomaCitas:

                Intent intentCitas = new Intent(this, ActivityRegistroCitas.class);


                startActivity(intentCitas);


                break;
            case R.id.botonCalendario:


                break;
            case R.id.botonOpcionesUser:
                Intent intentOpcionesUsuarios=new Intent(this,ActivityDetalleUsuario.class);
                startActivity(intentOpcionesUsuarios);
                break;

            case R.id.botonBA:

                Intent intentBA = new Intent(this, ActivityBACitas.class);
                startActivity(intentBA);

                break;
        }
    }
}
