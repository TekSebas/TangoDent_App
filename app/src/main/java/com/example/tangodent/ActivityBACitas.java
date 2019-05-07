package com.example.tangodent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ActivityBACitas extends AppCompatActivity {
EditText ed_Servicio,ed_Nombre,ed_DNI,ed_Email,ed_Telefono,ed_Direccion,ed_Ciudad;
Button boton_Actualizar,boton_Buscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacitas);

        ed_Servicio= findViewById(R.id.text_Servicio);
        ed_Nombre= findViewById(R.id.text_);
        ed_DNI= findViewById(R.id.text_Servicio);
        ed_Email= findViewById(R.id.text_Servicio);
        ed_Telefono= findViewById(R.id.text_Servicio);
        ed_Direccion= findViewById(R.id.text_Servicio);
        ed_Ciudad= findViewById(R.id.text_Servicio);






    }
}
