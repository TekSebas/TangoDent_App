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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
EditText ed;
EditText ed1;
Button boton;
Button boton1;

FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed=findViewById(R.id.emailText);
        ed1=findViewById(R.id.passText);

        boton=findViewById(R.id.botonEnviar);
        boton1=findViewById(R.id.botonRegistro);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser(); // <---- FirebaseAuth.getInstance().getCurrentUser();

                if(user!=null){

                    Log.i("SESION","SESION INICIADA CON EMAIL: "+user.getEmail());

                }else{
                    Log.i("SESION","Sesion cerrada");
                }

            }
        };



        /*boton=findViewById(R.id.button);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference usuariosRef = database.getReference(FirebaseReferences.FIREBASE_REFERENCE);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Coche coche= new Coche("Ford","Toni",5,4);

                usuariosRef.child(FirebaseReferences.COCHE_REFERENCE).push().setValue(coche);

            }
        });*/

        boton1.setOnClickListener(this);
        boton.setOnClickListener(this);


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
    private void iniciar(String email, String pass){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("SESION","sesion iniciada correctamente");
                    Intent intent= new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(intent);
                }else{
                    Log.e("SESION",task.getException().getMessage()+"");
                }
            }
        });;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.botonEnviar:

                String email= ed.getText().toString();
                String pass= ed1.getText().toString();

                iniciar(email,pass);


                break;
            case R.id.botonRegistro:

                String email_Registro= ed.getText().toString();
                String pass_Registro= ed1.getText().toString();

                registrar(email_Registro,pass_Registro);


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
        if(mAuthListener!=null){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }

    }

    /*
                usuariosRef.child(FirebaseReferences.COCHE_REFERENCE).addValueEventListener(new ValueEventListener() {
                     @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        Coche coche = dataSnapshot.getValue(Coche.class);

                        Log.i("COCHE", dataSnapshot.toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                */


                /*myRef.push().setValue(5);
                ValueEventListener valueEventListener= new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int valor= dataSnapshot.getValue(Integer.class);
                        Log.i("DATOS", valor+"");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.i("Error",databaseError.getMessage());
                    }
                };

                myRef.addValueEventListener(valueEventListener);
*/
                /*FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment,new Fragmento());
                fragmentTransaction.commit();*/


        }


