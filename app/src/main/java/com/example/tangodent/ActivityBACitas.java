package com.example.tangodent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tangodent.Conexion.ConexionSQLiteHelper;

public class ActivityBACitas extends AppCompatActivity implements View.OnClickListener{
EditText ed_Servicio,ed_Nombre,ed_DNI,ed_Email,ed_Telefono,ed_Direccion,ed_Ciudad,ed_Hora,ed_Fecha,ed_Duracion;
Button boton_Actualizar,boton_Buscar;

ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacitas);

        conn=new ConexionSQLiteHelper(this,"tangodentbd",null,2);



        ed_Servicio= findViewById(R.id.text_Servicio);
        ed_Nombre= findViewById(R.id.text_Nombre);
        ed_DNI= findViewById(R.id.text_DNI);
        ed_Email= findViewById(R.id.text_Email);
        ed_Telefono= findViewById(R.id.text_Tlf);
        ed_Direccion= findViewById(R.id.text_Direccion);
        ed_Ciudad= findViewById(R.id.text_Ciudad);
        ed_Fecha=findViewById(R.id.text_Fecha);
        ed_Hora=findViewById(R.id.text_Hora);
        ed_Duracion=findViewById(R.id.text_Duracion);
        boton_Actualizar=findViewById(R.id.botonActualizar);
        boton_Buscar=findViewById(R.id.botonBuscar);

        boton_Actualizar.setOnClickListener(this);
        boton_Buscar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){


            case R.id.botonActualizar:

                break;
            case R.id.botonBuscar:
                consultarCita();
                break;
        }

    }

    private void consultarCita() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={ed_DNI.getText().toString()};
        String[] campos={"nombreServicio","fecha","hora","duracion","nombrePaciente","dni","email","telefono","direccion","ciudad"};

        try {
            Cursor cursor =db.query("citas",campos,"dni"+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            ed_Servicio.setText(cursor.getString(1));
            ed_Fecha.setText(cursor.getString(2));
            ed_Hora.setText(cursor.getString(3));
            ed_Duracion.setText(cursor.getString(4));
            ed_Nombre.setText(cursor.getString(5));
            //ed_DNI.setText(cursor.getString(6));
            ed_Email.setText(cursor.getString(7));
            ed_Telefono.setText(cursor.getString(8));
            ed_Direccion.setText(cursor.getString(9));
            ed_Ciudad.setText(cursor.getString(10));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }
    }
    private void limpiar() {
        ed_Servicio.setText("");
        ed_Fecha.setText("");
        ed_Hora.setText("");
        ed_Nombre.setText("");
        ed_DNI.setText("");
        ed_Email.setText("");
        ed_Telefono.setText("");
        ed_Direccion.setText("");
        ed_Ciudad.setText("");
        ed_Duracion.setText("");

    }
}
