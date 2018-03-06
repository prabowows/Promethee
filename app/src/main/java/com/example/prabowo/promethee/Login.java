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

public class Login extends AppCompatActivity implements View.OnClickListener{

    private Button BTsignin;
    private EditText ETemail;
    private EditText ETpassword;
    private TextView TVsignup;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            finish();
            //startActivity(new Intent(getApplicationContext(),MainActivity.class));
            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.putExtra("kode", "pindah");
            startActivity(intent);
        }

        ETemail = (EditText) findViewById(R.id.ETemail);
        ETpassword = (EditText) findViewById(R.id.ETpassword);
        BTsignin = (Button) findViewById(R.id.BTsignin);
        TVsignup = (TextView) findViewById(R.id.TVsignup);

        progressDialog = new ProgressDialog(this);
        BTsignin.setOnClickListener(this);
        TVsignup.setOnClickListener(this);


    }

    private void UserLogin(){
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

        progressDialog.setMessage("Wait a minute .....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {

        if (v == BTsignin){
            UserLogin();
        }

        if (v == TVsignup){
            finish();
            startActivity(new Intent(this, Daftar.class));
        }
    }
}
