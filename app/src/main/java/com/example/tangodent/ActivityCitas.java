package com.example.tangodent;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tangodent.Conexion.ConexionSQLiteHelper;
import com.example.tangodent.FuncionesDoctor.*;
import java.sql.Connection;



public class ActivityCitas extends AppCompatActivity implements View.OnClickListener{

    EditText edServicio,edNombre,edEmail,edTelefono,edDireccion,edCiudad;
    TextView edFecha,edHora;
    Button botonCita;

    Connection cn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

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
        registrarCita();


    }

    private void registrarCita(){
        String nombreServicio= edServicio.getText().toString();
        String f= edFecha.getText().toString();
        String h= edHora.getText().toString();
        String nombre= edNombre.getText().toString();
        String email= edEmail.getText().toString();
        String telefono= edTelefono.getText().toString();
        String direccion= edDireccion.getText().toString();
        String ciudad= edCiudad.getText().toString();
        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"tangodentdb",null,1);
        SQLiteDatabase db= conn.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put("idCita",1);
        values.put("nombreServicio",nombreServicio);
        values.put("fecha",f);
        values.put("hora",h);
        values.put("nombrePaciente",nombre);
        values.put("email",email);
        values.put("telefono",telefono);
        values.put("direccion",direccion);
        values.put("ciudad",ciudad);

        Long idResultante= db.insert("citas","idCita",values);

        Toast.makeText(this, "Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }

    }

