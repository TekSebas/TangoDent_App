package com.example.tangodent;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tangodent.Conexion.ConexionSQLiteHelper;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed,ed1;
    Button boton,boton1,botonRapido;
    String nameV,emailV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = findViewById(R.id.emailText);
        ed1 = findViewById(R.id.passText);

        boton = findViewById(R.id.botonEnviar);
        boton1 = findViewById(R.id.botonRegistro);
        botonRapido=findViewById(R.id.EntradaRapida);

        boton1.setOnClickListener(this);
        boton.setOnClickListener(this);
        botonRapido.setOnClickListener(this);

    }


    private void iniciarUsuarios() {

        Intent intent = new Intent(getApplicationContext(), ActivityRegistroUsuarios.class);
        startActivity(intent);

    }

    private void iniciarDoctor() {

        Intent intent = new Intent(getApplicationContext(), ActivityDoctor.class);
        intent.putExtra("email",ed.getText().toString());
        startActivity(intent);

    }

    private void iniciarAdmin() {

        Intent intent = new Intent(getApplicationContext(), ActivityAdmin.class);
        startActivity(intent);

    }

    private void limpiar() {
        ed.setText("");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.botonEnviar:
                ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "tangodentbd", null, 2);
                ;
                String email = ed.getText().toString();
                String pass = ed1.getText().toString();

                SQLiteDatabase db = conn.getReadableDatabase();
                String[] parametros = {ed.getText().toString()};
                String[] campos = {"email", "pass"};

                try {
                    Cursor cursor = db.query("usuarios", campos, "email" + "=?", parametros, null, null, null);
                    cursor.moveToFirst();
                    System.out.println(cursor.getString(0)+" ------ "+cursor.getString(1));
                    if (cursor.getString(0).equals(ed.getText().toString()) && cursor.getString(1).equals(ed1.getText().toString())) {
                        iniciarDoctor();
                    } else if (cursor.getString(0).equals(ed.getText().toString()) && cursor.getString(1).equals(ed1.getText().toString())) {
                        iniciarAdmin();
                    } else if (cursor.getString(0).equals(ed.getText().toString()) && cursor.getString(1).equals(ed1.getText().toString())) {
                        iniciarUsuarios();
                    }

                    cursor.close();
                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "El email o la contraseña son incorrectos", Toast.LENGTH_LONG).show();
                    //limpiar();
                }


                break;
            case R.id.botonRegistro:

                Intent intent = new Intent(getApplicationContext(), ActivityRegistroUsuarios.class);
                startActivity(intent);


                break;

            case R.id.EntradaRapida:

                Intent intent1 = new Intent(getApplicationContext(), ActivityRegistroCitas.class);
                startActivity(intent1);


                break;

        }


    }


}
