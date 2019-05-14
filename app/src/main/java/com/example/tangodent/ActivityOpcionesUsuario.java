package com.example.tangodent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ActivityOpcionesUsuario extends AppCompatActivity {

    EditText ed_NombreAct, ed_ApellidoAct, ed_DireccionAct, ed_EmailAct, ed_FechaNacimientoAct, ed_PassAct, ed_Pass2Act;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_usuario);

        ed_NombreAct=findViewById(R.id.textNombreAct);
        ed_ApellidoAct=findViewById(R.id.textApellidoAct);
        ed_DireccionAct=findViewById(R.id.textDireccionAct);
        ed_EmailAct=findViewById(R.id.textEmailAct);
        ed_FechaNacimientoAct=findViewById(R.id.textNacimientoAct);
        ed_PassAct=findViewById(R.id.textPassAct);
        ed_Pass2Act=findViewById(R.id.textPass2Act);

    }
}
