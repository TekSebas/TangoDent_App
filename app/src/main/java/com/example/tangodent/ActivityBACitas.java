package com.example.tangodent;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tangodent.Conexion.ConexionSQLiteHelper;

public class ActivityBACitas extends AppCompatActivity implements View.OnClickListener {
    EditText ed_Servicio, ed_Nombre, ed_DNI, ed_Email, ed_Telefono, ed_Direccion, ed_Ciudad, ed_Hora, ed_Fecha, ed_Duracion;
    Button boton_Actualizar, boton_Buscar, boton_Borrar;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacitas);

        conn = new ConexionSQLiteHelper(this, "tangodentbd", null, 3);


        ed_Servicio = findViewById(R.id.text_Servicio);
        ed_Nombre = findViewById(R.id.text_Nombre);
        ed_DNI = findViewById(R.id.text_DNI);
        ed_Email = findViewById(R.id.text_Email);
        ed_Telefono = findViewById(R.id.text_Tlf);
        ed_Direccion = findViewById(R.id.text_Direccion);
        ed_Ciudad = findViewById(R.id.text_Ciudad);
        ed_Fecha = findViewById(R.id.text_Fecha);
        ed_Hora = findViewById(R.id.text_Hora);
        ed_Duracion = findViewById(R.id.text_Duracion);
        boton_Actualizar = findViewById(R.id.botonActualizar);
        boton_Buscar = findViewById(R.id.botonBuscar);
        boton_Borrar = findViewById(R.id.botonBorrar);

        boton_Actualizar.setOnClickListener(this);
        boton_Buscar.setOnClickListener(this);
        boton_Borrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.botonActualizar:

                actualizarUsuario();
                break;

            case R.id.botonBuscar:

                consultarCita();
                break;

            case R.id.botonBorrar:

                eliminarCita();
                break;

        }

    }

    private void consultarCita() {

        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {ed_DNI.getText().toString()};
        String[] campos = {"nombreServicio", "fecha", "hora", "duracion", "nombrePaciente", "email", "telefono", "direccion", "ciudad"};

        try {
            Cursor cursor = db.query("citas", campos, "dni" + "=?", parametros, null, null, null);
            cursor.moveToFirst();
            ed_Servicio.setText(cursor.getString(0));
            ed_Fecha.setText(cursor.getString(1));
            ed_Hora.setText(cursor.getString(2));
            ed_Duracion.setText(cursor.getString(3));
            ed_Nombre.setText(cursor.getString(4));
            ed_Email.setText(cursor.getString(5));
            ed_Telefono.setText(cursor.getString(6));
            ed_Direccion.setText(cursor.getString(7));
            ed_Ciudad.setText(cursor.getString(8));
            cursor.close();
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), "No existe la cita con ese DNI", Toast.LENGTH_LONG).show();
            limpiar();
        }
    }

    private void eliminarCita() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {ed_DNI.getText().toString()};

        db.delete("citas", "dni" + "=?", parametros);
        Toast.makeText(getApplicationContext(), "Ya se Eliminó el usuario", Toast.LENGTH_LONG).show();
        ed_DNI.setText("");
        limpiar();
        db.close();
    }

    private void actualizarUsuario() {

        String nombreServicio = ed_Servicio.getText().toString();
        String f = ed_Fecha.getText().toString();
        String h = ed_Hora.getText().toString();
        String duracion = ed_Duracion.getText().toString();
        String nombre = ed_Nombre.getText().toString();
        String dni = ed_DNI.getText().toString();
        String email = ed_Email.getText().toString();
        String telefono = ed_Telefono.getText().toString();
        String direccion = ed_Direccion.getText().toString();
        String ciudad = ed_Ciudad.getText().toString();

        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {ed_DNI.getText().toString()};
        ContentValues values = new ContentValues();

        values.put("nombreServicio", nombreServicio);
        values.put("fecha", f);
        values.put("hora", h);
        values.put("duracion", duracion);
        values.put("nombrePaciente", nombre);
        values.put("DNI", dni);
        values.put("email", email);
        values.put("telefono", telefono);
        values.put("direccion", direccion);
        values.put("ciudad", ciudad);

        db.update("citas", values, "dni" + "=?", parametros);
        Toast.makeText(getApplicationContext(), "Ya se actualizó el usuario", Toast.LENGTH_LONG).show();
        db.close();

    }

    private void limpiar() {
        ed_Servicio.setText("");
        ed_Fecha.setText("");
        ed_Hora.setText("");
        ed_Nombre.setText("");
        ed_Email.setText("");
        ed_Telefono.setText("");
        ed_Direccion.setText("");
        ed_Ciudad.setText("");
        ed_Duracion.setText("");

    }
}
