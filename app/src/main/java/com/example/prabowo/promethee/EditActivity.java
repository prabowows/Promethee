package com.example.prabowo.promethee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton CBtipe, CBbobot, CBbatas1;
    DatabaseReference mRootref;
    EditText ETkriteria, ETskor,ETbatas1,ETbatas2;
    Button BTselesai;
    int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        mRootref = FirebaseDatabase.getInstance().getReference();

        ETkriteria = findViewById(R.id.ETkriteria);
        ETskor = findViewById(R.id.ETeditskorkriteria);
        CBtipe = findViewById(R.id.CBtipe);
        CBbobot = findViewById(R.id.CBbobot);
        CBbatas1 = findViewById(R.id.CBbatas1);
        BTselesai = findViewById(R.id.BTselesaieditkriteria);
        ETbatas1 = findViewById(R.id.ETeditbatas1);
        ETbatas2=findViewById(R.id.ETeditbatas2);
        BTselesai.setOnClickListener(this);



        }


    @Override
    public void onClick(View v) {

        if (CBtipe.isChecked()) {
            DatabaseReference reftipe = mRootref;
            c=0;
            reftipe.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child("Kriteria").child(ETkriteria.getText().toString()).child("Preferensi" + ETkriteria.getText().toString()).exists()&&(c==0)) {

                        if(ETskor.getText().toString().equals("1")) {
                            mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Preferensi" + ETkriteria.getText().toString()).setValue(ETskor.getText().toString());
                            mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Batas1").setValue("n/a");
                            mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Batas2").setValue("n/a");
                            c++;
                            CBtipe.setChecked(false);
                            startActivity(new Intent(EditActivity.this, MainActivity.class));
                        }
                        if(ETskor.getText().toString().equals("2")){
                            if(ETbatas1.getText().toString().matches("")){
                                Toast.makeText(EditActivity.this,"Isi Batasnya",Toast.LENGTH_LONG).show();
                            }
                            else {
                                mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Preferensi" + ETkriteria.getText().toString()).setValue(ETskor.getText().toString());
                                mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Batas1").setValue(ETbatas1.getText().toString());
                                c++;
                                CBtipe.setChecked(false);
                                startActivity(new Intent(EditActivity.this, MainActivity.class));
                            }
                        }

                        if(ETskor.getText().toString().equals("3")){
                            if(ETbatas1.getText().toString().matches("")){
                                Toast.makeText(EditActivity.this,"Isi Batasnya",Toast.LENGTH_LONG).show();
                            }
                            else {
                                mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Preferensi" + ETkriteria.getText().toString()).setValue(ETskor.getText().toString());
                                mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Batas1").setValue(ETbatas1.getText().toString());
                                c++;
                                CBtipe.setChecked(false);
                                startActivity(new Intent(EditActivity.this, MainActivity.class));
                            }
                        }
                        if(ETskor.getText().toString().equals("4")){
                            if(ETbatas1.getText().toString().matches("")||ETbatas2.getText().toString().matches("") ){
                                Toast.makeText(EditActivity.this,"Isi Batasnya",Toast.LENGTH_LONG).show();
                            }
                            else {
                                mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Preferensi" + ETkriteria.getText().toString()).setValue(ETskor.getText().toString());
                                mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Batas1").setValue(ETbatas1.getText().toString());
                                mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Batas2").setValue(ETbatas2.getText().toString());
                                c++;
                                CBtipe.setChecked(false);
                                startActivity(new Intent(EditActivity.this, MainActivity.class));}
                        }
                        if(ETskor.getText().toString().equals("5")){
                            if(ETbatas1.getText().toString().matches("")||ETbatas2.getText().toString().matches("") ){
                                Toast.makeText(EditActivity.this,"Isi Batasnya",Toast.LENGTH_LONG).show();
                            }
                            else {
                                mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Preferensi" + ETkriteria.getText().toString()).setValue(ETskor.getText().toString());
                                mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Batas1").setValue(ETbatas1.getText().toString());
                                mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Batas2").setValue(ETbatas2.getText().toString());
                                c++;
                                CBtipe.setChecked(false);
                                startActivity(new Intent(EditActivity.this, MainActivity.class));
                            }

                        }


                    }
                    else if (c==0){
                        Toast.makeText(EditActivity.this,"Coba Lagi",Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }




        if (CBbobot.isChecked()) {
            DatabaseReference refbobot = mRootref;
            c=0;
            refbobot.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child("Kriteria").child(ETkriteria.getText().toString()).child("Bobot" + ETkriteria.getText().toString()).exists() &&(c ==0)) {
                        mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Bobot" + ETkriteria.getText().toString()).setValue(ETskor.getText().toString());
                        //startActivity(new Intent(EditActivity.this, MainActivity.class));
                        CBbobot.setChecked(false);
                        //Toast.makeText(EditActivity.this, "Telah Berhasil Diperbarui", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(EditActivity.this, MainActivity.class));
                        //finish();
                        c++;
                        //startActivity(getIntent());



                    }

                    else if (c==0) {
                        Toast.makeText(EditActivity.this, "Coba Lagi", Toast.LENGTH_LONG).show();}

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }

        if (CBbatas1.isChecked()) {
            DatabaseReference refbatas1 = mRootref;
            c=0;
            refbatas1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child("Kriteria").child(ETkriteria.getText().toString()).child("Kaidah").exists()&&(c ==0)) {
                        mRootref.child("Kriteria").child(ETkriteria.getText().toString()).child("Kaidah").setValue(ETskor.getText().toString());
                        CBbatas1.setChecked(false);
                        c++;
                        startActivity(new Intent(EditActivity.this, MainActivity.class));
                    }

                    else  if (c==0) {
                        Toast.makeText(EditActivity.this, "Coba Lagi", Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }





    }
}





