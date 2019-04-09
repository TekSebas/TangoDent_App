package com.example.tangodent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
EditText nombre, apellido,fechaNacimiento, direccion, email, pass, pass2;
Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre= findViewById(R.id.textNombre);
        apellido= findViewById(R.id.textApellido);
        fechaNacimiento= findViewById(R.id.textNacimiento);
        direccion= findViewById(R.id.textDireccion);
        email= findViewById(R.id.textEmail);
        pass= findViewById(R.id.textPass);
        pass2= findViewById(R.id.textPass2);

        guardar= findViewById(R.id.botonGuardar);

        guardar.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {

        String email_Registro= email.getText().toString();
        String pass_Registro= pass.getText().toString();

        registrar(email_Registro,pass_Registro);


    }


    private void registrar(String email, String pass){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("SESION","Usuario creado correctamente");
                }else{
                    Log.e("SESION",task.getException().getMessage()+"");
                }
            }
        });
    }

}
