package com.example.tangodent;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed;
    EditText ed1;
    Button boton;
    Button boton1;
    String nameV;
    String emailV;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = findViewById(R.id.emailText);
        ed1 = findViewById(R.id.passText);

        boton = findViewById(R.id.botonEnviar);
        boton1 = findViewById(R.id.botonRegistro);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser(); // <---- FirebaseAuth.getInstance().getCurrentUser();


                if (user != null) {

                    Log.i("SESION", "SESION INICIADA CON EMAIL: " + user.getEmail());

                } else {
                    Log.i("SESION", "Sesion cerrada");
                }

            }
        };


        boton1.setOnClickListener(this);
        boton.setOnClickListener(this);


    }


    private void iniciarUsuarios(String email, String pass) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.i("SESION", "sesion iniciada correctamente");
                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(intent);
                } else {
                    Log.e("SESION", task.getException().getMessage() + "");
                }
            }
        });
    }

    private void iniciarDoctor(String email, String pass) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.i("SESION", "Sesión iniciada correctamente como Doctor");
                    Intent intent = new Intent(getApplicationContext(), ActivityDoctor.class);
                    startActivity(intent);
                } else {
                    Log.e("SESION", task.getException().getMessage() + "");
                }
            }
        });
    }

    private void iniciarAdmin(String email, String pass) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.i("SESION", "Sesión iniciada correctamente como Admin");
                    Intent intent = new Intent(getApplicationContext(), ActivityAdmin.class);
                    startActivity(intent);
                } else {
                    Log.e("SESION", task.getException().getMessage() + "");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.botonEnviar:

                String email = ed.getText().toString();
                String pass = ed1.getText().toString();


                if (email.equals("danielschuler@hotmail.com")) {
                    iniciarDoctor(email, pass);
                } else if (email.equals("sebasschulerdeveloper@gmail.com")) {
                    iniciarAdmin(email, pass);
                } else {
                    iniciarUsuarios(email, pass);
                }


                break;
            case R.id.botonRegistro:

                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);


                break;

            case R.id.EntradaRapida:

                Intent intent1 = new Intent(getApplicationContext(), ActivityRegistroCitas.class);
                startActivity(intent1);

                break;

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }

    }
}
