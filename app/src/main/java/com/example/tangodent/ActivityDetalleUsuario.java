package com.example.tangodent;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tangodent.Conexion.ConexionSQLiteHelper;

public class ActivityDetalleUsuario extends AppCompatActivity implements View.OnClickListener {

    TextView tx_Nombre,tx_Apellido,tx_Direccion,tx_Email,tx_FNacimiento,tx_Pass;
    Button boton_Pass,boton_Mostrar_Pass;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        conn = new ConexionSQLiteHelper(this, "tangodentbd", null, 3);

        tx_Nombre=findViewById(R.id.textViewNombre);
        tx_Apellido=findViewById(R.id.textViewApellido);
        tx_Direccion=findViewById(R.id.textViewDireccion);
        tx_Email=findViewById(R.id.textViewEmail);
        tx_FNacimiento=findViewById(R.id.textViewFNacimiento);
        tx_Pass=findViewById(R.id.textViewPass);

        boton_Pass=findViewById(R.id.boton_cambiar_pass);
        boton_Mostrar_Pass=findViewById(R.id.boton_Mostrar);

        boton_Pass.setOnClickListener(this);
        boton_Mostrar_Pass.setOnClickListener(this);

        String valor=getIntent().getExtras().getString("email");
        tx_Email.setText(valor);

        consultarUsuario();

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.boton_cambiar_pass:

                //Intent intent= new Intent(this,ActivityPassUsuario.class);
                //startActivity(intent);

                break;

            case R.id.boton_Mostrar:

                SQLiteDatabase db = conn.getReadableDatabase();
                String[] parametros = {tx_Email.getText().toString()};
                String[] campos = {"apellido"};

                try {
                    Cursor cursor = db.query("usuarios", campos, "email" + "=?", parametros, null, null, null);
                    cursor.moveToFirst();
                    tx_Pass.setText(cursor.getString(0));
                    cursor.close();

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "No hay ususario con ese Email", Toast.LENGTH_LONG).show();
                    //limpiar();
                }

                break;

        }




    }
    private void consultarUsuario() {

        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {tx_Email.getText().toString()};
        String[] campos = {"nombre","apellido","direccion","fechaNacimiento"};

        try {
            Cursor cursor = db.query("usuarios", campos, "email" + "=?", parametros, null, null, null);
            cursor.moveToFirst();
            tx_Nombre.setText(cursor.getString(0));
            tx_Apellido.setText(cursor.getString(1));
            tx_Direccion.setText(cursor.getString(2));
            tx_FNacimiento.setText(cursor.getString(3));

            cursor.close();

        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), "No hay usuario con ese Email", Toast.LENGTH_LONG).show();
            //limpiar();
        }
    }

}
