package com.example.tangodent;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tangodent.Conexion.ConexionSQLiteHelper;
import com.example.tangodent.Objetos.Cita;
import com.example.tangodent.Utilidades.Utilidades;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;


public class ActivityRegistroCitas extends AppCompatActivity implements View.OnClickListener{

    EditText edServicio,edNombre,edDNI,edEmail,edTelefono,edDireccion,edCiudad,edDuracion;
    TextView edFecha,edHora;
    Button botonCita;

    Connection cn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_citas);

        edServicio=findViewById(R.id.textServicio);
        edFecha= findViewById(R.id.textFecha);
        edHora=findViewById(R.id.textHora);
        edDuracion=findViewById(R.id.textDuracion);
        edNombre=findViewById(R.id.textNombre);
        edDNI=findViewById(R.id.textDNI);
        edEmail=findViewById(R.id.textEmail);
        edTelefono=findViewById(R.id.textTelefono);
        edDireccion=findViewById(R.id.textDireccion);
        edCiudad=findViewById(R.id.textCiudad);
        botonCita=findViewById(R.id.botonGuardarCita);


        botonCita.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        registrarCita();

    }

    private void registrarCita(){


        String nombreServicio= edServicio.getText().toString();
        String f= edFecha.getText().toString();
        String h= edHora.getText().toString();
        String duracion= edDuracion.getText().toString();
        String nombre= edNombre.getText().toString();
        String dni=edDNI.getText().toString();
        String email= edEmail.getText().toString();
        String telefono= edTelefono.getText().toString();
        String direccion= edDireccion.getText().toString();
        String ciudad= edCiudad.getText().toString();
        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"tangodentbd",null,3);

        //Recojo y trato la hora
        String horaYminutos= edHora.getText().toString();
        String[] horaMin= horaYminutos.split(":");
        String hora= horaMin[0];
        String minuto= horaMin[1];

        int horaI=Integer.parseInt(hora);
        int minutoI=Integer.parseInt(minuto);


        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, horaI);
        calendar.set(Calendar.MINUTE, minutoI);
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 45);
        calendar.set(Calendar.DAY_OF_MONTH, 12);
        calendar.set(Calendar.MONTH, 5);




        SQLiteDatabase db= conn.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("nombreServicio",nombreServicio);
        values.put("fecha",f);
        values.put("hora",h);
        values.put("duracion",duracion);
        values.put("nombrePaciente",nombre);
        values.put("DNI",dni);
        values.put("email",email);
        values.put("telefono",telefono);
        values.put("direccion",direccion);
        values.put("ciudad",ciudad);



        Long idResultante= db.insert("citas","idCita",values);

        Toast.makeText(this, "Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }


    public void comprobarHoras(){
        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"tangodentbd",null,3);
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {edHora.getText().toString()};
        String[] campos = {"nombreServicio", "fecha", "hora", "duracion", "nombrePaciente", "email", "telefono", "direccion", "ciudad"};

        try {
            Cursor cursor = db.query("citas", campos, "hora" + "=?", parametros, null, null, null);
            cursor.moveToFirst();




            //ed_Servicio.setText(cursor.getString(0));

            cursor.close();
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), "No existe la cita con ese DNI", Toast.LENGTH_LONG).show();
            //limpiar();
        }

    }


    }

