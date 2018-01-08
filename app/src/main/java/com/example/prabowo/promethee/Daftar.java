package com.example.prabowo.promethee;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Daftar extends AppCompatActivity implements View.OnClickListener {

    private Button BTregister;
    private EditText ETemail;
    private EditText ETpassword;
    private TextView TVsignin;
    private DatabaseReference databaseReference;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        BTregister = (Button) findViewById(R.id.BTregister);
        ETemail = (EditText) findViewById(R.id.ETemaildaftar);
        ETpassword = (EditText) findViewById(R.id.ETpassworddaftar);
        TVsignin = (TextView) findViewById(R.id.TVsignin);

        BTregister.setOnClickListener(this);
        TVsignin.setOnClickListener(this);

    }

    public void registerUser() {

        String email = ETemail.getText().toString().trim();
        String password = ETpassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User .....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            databaseReference = FirebaseDatabase.getInstance().getReference();
                            databaseReference.child("User").child(user.getUid()).child("toko").setValue(0);


                            Toast.makeText(Daftar.this, "Registered Succesfull", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        } else {
                            Toast.makeText(Daftar.this, "Registered unsuccesfull", Toast.LENGTH_SHORT).show();
                        }
                    }


                });

    }

    @Override
    public void onClick(View v) {

        if (v == BTregister) {
            registerUser();
        }

        if (v == TVsignin) {

            startActivity(new Intent(this,Login.class));

        }


    }


}
