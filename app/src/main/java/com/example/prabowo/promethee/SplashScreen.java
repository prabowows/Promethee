package com.example.prabowo.promethee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SplashScreen extends AppCompatActivity {
DatabaseReference mRootref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mRootref = FirebaseDatabase.getInstance().getReference();

        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {

                    mRootref.child("Kode").child("Row").setValue("0");

                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(),Login.class); //first
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}