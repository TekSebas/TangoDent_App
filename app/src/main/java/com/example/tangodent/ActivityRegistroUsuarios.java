package com.example.tangodent;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tangodent.Conexion.ConexionSQLiteHelper;
import com.example.tangodent.Objetos.FirebaseReferences;
import com.example.tangodent.Objetos.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityRegistroUsuarios extends AppCompatActivity implements View.OnClickListener {
    EditText nombre, apellido, fechaNacimiento, direccion, email, password, pass2;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre = findViewById(R.id.textNombre);
        apellido = findViewById(R.id.textApellido);
        fechaNacimiento = findViewById(R.id.textNacimiento);
        direccion = findViewById(R.id.textDireccion);
        email = findViewById(R.id.textEmail);
        password = findViewById(R.id.textPass);
        pass2 = findViewById(R.id.textPass2);

        guardar = findViewById(R.id.botonGuardar);
        guardar.setOnClickListener(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("¡Perfecto!")
                .setMessage("Se ha creado el usuario correctamente")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("Hola buenas tardes");
                            }
                        });
        builder.create();

    }


    @Override
    public void onClick(View v) {
        String nombre_Registro = nombre.getText().toString();
        String apellido_Registro = apellido.getText().toString();
        String direccion_Registro = direccion.getText().toString();
        String fechaNacimiento_Registro = fechaNacimiento.getText().toString();
        String email_Registro = email.getText().toString();
        String pass_Registro = password.getText().toString();
        String pass2_Registro = pass2.getText().toString();

        if (pass_Registro.equals(pass2_Registro)) {
            if (email_Registro.equals("") || pass_Registro.equals("") || nombre_Registro.equals("") || apellido_Registro.equals("") || direccion_Registro.equals("") || fechaNacimiento_Registro.equals("")) {
                DialogErrorCampos();
            } else {
                registrar();
            }

        }
    }


    private void registrar() {
        String nombre_Registro = nombre.getText().toString();
        String apellido_Registro = apellido.getText().toString();
        String direccion_Registro = direccion.getText().toString();
        String fechaNacimiento_Registro = fechaNacimiento.getText().toString();
        String email_Registro = email.getText().toString();
        String pass_Registro = password.getText().toString();

        if (email.equals("") || password.equals("")) {
            DialogErrorCampos();
        } else {

            ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "tangodentbd", null, 2);
            SQLiteDatabase db = conn.getWritableDatabase();
            ContentValues values = new ContentValues();



            values.put("nombre", nombre_Registro + " " + apellido_Registro);
            values.put("direccion", direccion_Registro);
            values.put("email", email_Registro);
            values.put("fechaNacimiento", fechaNacimiento_Registro);
            values.put("pass", pass_Registro);

            Long idResultante = db.insert("usuarios", "idUsuario", values);
            Toast.makeText(this, "Id Registro: " + idResultante, Toast.LENGTH_SHORT).show();
            db.close();
        }
    }

    public AlertDialog DialogErrorCampos() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());

        builder.setTitle("Error")
                .setMessage("Rellena todos los campos para registrarte")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

        return builder.create();
    }

    public AlertDialog DialogErrorRegistro() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());

        builder.setTitle("Error")
                .setMessage("Error al crear el usuario")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

        return builder.create();
    }

    public AlertDialog DialogRegistro() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("¡Perfecto!")
                .setMessage("Se ha creado el usuario correctamente")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("Hola buenas tardes");
                            }
                        });

        return builder.create();
    }

}
