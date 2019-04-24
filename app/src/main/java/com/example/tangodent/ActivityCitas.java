package com.example.tangodent;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tangodent.Conexion.Conexion;
import com.example.tangodent.FuncionesDoctor.*;
import com.example.tangodent.Objetos.Cita;
import com.example.tangodent.Objetos.FirebaseReferences;
import com.example.tangodent.Objetos.Usuario;
import com.example.tangodent.R;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;


public class ActivityCitas extends AppCompatActivity implements View.OnClickListener{

    EditText edServicio,edNombre,edEmail,edTelefono,edDireccion,edCiudad;
    TextView edFecha,edHora;
    Button botonCita;
    Conexion db;
    Connection cn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        cn=db.getConnection();

        edServicio=findViewById(R.id.textServicio);
        edFecha= findViewById(R.id.textFecha);
        edHora=findViewById(R.id.textHora);
        edNombre=findViewById(R.id.textNombre);
        edEmail=findViewById(R.id.textEmail);
        edTelefono=findViewById(R.id.textTelefono);
        edDireccion=findViewById(R.id.textDireccion);
        edCiudad=findViewById(R.id.textCiudad);

        botonCita=findViewById(R.id.botonGuardarCita);

        botonCita.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        CitaCRUD citaCRUD= new CitaCRUD();
        String nombreServicio= edServicio.getText().toString();
        String f= edFecha.getText().toString();
        String h= edHora.getText().toString();
        String nombre= edNombre.getText().toString();
        String email= edEmail.getText().toString();
        String telefono= edTelefono.getText().toString();
        String direccion= edDireccion.getText().toString();
        String ciudad= edCiudad.getText().toString();


        System.out.println(f);

        try {

        SimpleDateFormat formatFecha = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(f);
        java.util.Date fecha = formatFecha.parse(f);
        java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());


        SimpleDateFormat formatHora = new SimpleDateFormat("hh:mm");
        long sqlHora = formatHora.parse(h).getTime();





        Cita cita= new Cita(nombreServicio,sqlFecha,sqlHora,nombre,email,telefono,direccion,ciudad);

        citaCRUD.crearCita(cita,cn);
        } catch (ParseException e) {
        e.printStackTrace();
    }
    }
}
