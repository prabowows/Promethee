package com.example.prabowo.promethee.ListKecamatanSet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prabowo.promethee.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.prabowo.promethee.ListKecamatanSet.SetKecamatanActivity.countKriteria;

public class EditKecamatanActivity extends AppCompatActivity {

    private EditText KK11, KK12, KK21, KK22, KK31, KK32, KK41, KK42,
            KK51, KK52, KK61, KK62, KK71, KK72, KK81, KK82,
            KK91, KK92, KKT1, KKT2;
    private TextView namaKecamatan;
    DatabaseReference mRootref;
    String id, nama1, nama2, nama3, nama4, nama5, nama6, nama7, nama8, nama9, nama10;
    ImageView CheckNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_kecamatan);
        mRootref = FirebaseDatabase.getInstance().getReference();


        KK11 = findViewById(R.id.KK1);
        KK21 = findViewById(R.id.KK2);
        KK31 = findViewById(R.id.KK3);
        KK41 = findViewById(R.id.KK4);
        KK51 = findViewById(R.id.KK5);
        KK61 = findViewById(R.id.KK6);
        KK71 = findViewById(R.id.KK7);
        KK81 = findViewById(R.id.KK8);
        KK91 = findViewById(R.id.KK9);
        KKT1 = findViewById(R.id.KKT);
        namaKecamatan = findViewById(R.id.namaKecamatanEdit);

        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getStringExtra("id");
            nama1 = intent.getStringExtra("nama1");
            switch (countKriteria) {
                case 10:
                    nama10 = intent.getStringExtra("nama10");

                case 9:
                    nama9 = intent.getStringExtra("nama9");

                case 8:
                    nama8 = intent.getStringExtra("nama8");

                case 7:
                    nama7 = intent.getStringExtra("nama7");
                case 6:
                    nama6 = intent.getStringExtra("nama6");

                case 5:
                    nama5 = intent.getStringExtra("nama5");

                case 4:
                    nama4 = intent.getStringExtra("nama4");

                case 3:
                    nama3 = intent.getStringExtra("nama3");

                case 2:
                    nama2 = intent.getStringExtra("nama2");

                case 1:
                    nama1 = intent.getStringExtra("nama1");
            }
        }


        switch (countKriteria) {
            case 10:
                KKT1.setVisibility(View.VISIBLE);

                DatabaseReference ref = mRootref.child("Kecamatan");

                ref.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        KKT1.setHint(snapshot.child(id).child(nama10).getValue().toString());
                        //KKT1.setText(snapshot.child(id).child(nama10).getValue().toString());


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
            case 9:
                KK91.setVisibility(View.VISIBLE);

                DatabaseReference sref = mRootref.child("Kecamatan");

                sref.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        KK91.setHint(snapshot.child(id).child(nama9).getValue().toString());
                        //KK91.setText(snapshot.child(id).child(nama9).getValue().toString());


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
            case 8:
                KK81.setVisibility(View.VISIBLE);
                DatabaseReference xref = mRootref.child("Kecamatan");

                xref.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        KK81.setHint(snapshot.child(id).child(nama8).getValue().toString());
                        //KK81.setText(snapshot.child(id).child(nama8).getValue().toString());


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
            case 7:
                KK71.setVisibility(View.VISIBLE);

                DatabaseReference dref = mRootref.child("Kecamatan");

                dref.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        KK71.setHint(snapshot.child(id).child(nama7).getValue().toString());
                        //KK71.setText(snapshot.child(id).child(nama7).getValue().toString());


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
            case 6:
                KK61.setVisibility(View.VISIBLE);

                DatabaseReference gref = mRootref.child("Kecamatan");

                gref.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        KK61.setHint(snapshot.child(id).child(nama6).getValue().toString());
                        //KK61.setText(snapshot.child(id).child(nama6).getValue().toString());


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
            case 5:
                KK51.setVisibility(View.VISIBLE);

                DatabaseReference jref = mRootref.child("Kecamatan");

                jref.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        KK51.setHint(snapshot.child(id).child(nama5).getValue().toString());
                       // KK51.setText(snapshot.child(id).child(nama5).getValue().toString());


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
            case 4:
                KK41.setVisibility(View.VISIBLE);
                DatabaseReference tref = mRootref.child("Kecamatan");

                tref.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        KK41.setHint(snapshot.child(id).child(nama4).getValue().toString());
                        //KK41.setText(snapshot.child(id).child(nama4).getValue().toString());


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
            case 3:
                KK31.setVisibility(View.VISIBLE);
                DatabaseReference refs = mRootref.child("Kecamatan");

                refs.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        KK31.setHint(snapshot.child(id).child(nama3).getValue().toString());
                        //KK31.setText(snapshot.child(id).child(nama3).getValue().toString());


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
            case 2:
                KK21.setVisibility(View.VISIBLE);
                DatabaseReference kref = mRootref.child("Kecamatan");

                kref.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        KK21.setHint(snapshot.child(id).child(nama2).getValue().toString());
                     //   KK21.setText(snapshot.child(id).child(nama2).getValue().toString());


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
            case 1:

                KK11.setVisibility(View.VISIBLE);
                DatabaseReference refd = mRootref.child("Kecamatan");

                refd.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        KK11.setHint(snapshot.child(id).child(nama1).getValue().toString());
//                        KK11.setText(snapshot.child(id).child(nama1).getValue().toString());


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });





        }
        namaKecamatan.setText(id);

        CheckNext = findViewById(R.id.checkEdit);
        CheckNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference event = mRootref.child("Kecamatan");
                final DatabaseReference Real= mRootref.child("Nilai Real");
                switch (countKriteria) {



                    case 10:


                        if(TextUtils.isEmpty(KKT1.getText().toString())){
                            DatabaseReference refd = mRootref.child("Nilai Real");

                            refd.addValueEventListener(new ValueEventListener() {


                                @Override
                                public void onDataChange(DataSnapshot snapshot) {

                                    //KK11.setHint(snapshot.child(id).child(nama1).getValue().toString());
                                    KKT1.setText(snapshot.child(id).child(nama10).getValue().toString());
                                    KK91.setText(snapshot.child(id).child(nama9).getValue().toString());
                                    KK81.setText(snapshot.child(id).child(nama8).getValue().toString());
                                    KK71.setText(snapshot.child(id).child(nama7).getValue().toString());
                                    KK61.setText(snapshot.child(id).child(nama6).getValue().toString());
                                    KK51.setText(snapshot.child(id).child(nama5).getValue().toString());
                                    KK41.setText(snapshot.child(id).child(nama4).getValue().toString());
                                    KK31.setText(snapshot.child(id).child(nama3).getValue().toString());
                                    KK21.setText(snapshot.child(id).child(nama2).getValue().toString());
                                    KK11.setText(snapshot.child(id).child(nama1).getValue().toString());


                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }


                            });}

                        else {
                            Real.child(id).child(nama8).setValue(KK91.getText().toString());
                        }

                        DatabaseReference kriteria = mRootref.child("Kriteria");
                        kriteria.addValueEventListener(new ValueEventListener() {


                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                Real.child(id).child(nama10).setValue(KKT1.getText().toString());
                                if (snapshot.child(nama10).child("Tipe Data").getValue().toString().equals("Kualitatif")) {

                                    if (snapshot.child(nama10).child("Kaidah").getValue().toString().equals("max")) {
                                        if (Integer.parseInt(KKT1.getText().toString()) < Integer.parseInt(snapshot.child(nama10).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama10).setValue(1);
                                        else if (Integer.parseInt(KKT1.getText().toString()) < Integer.parseInt(snapshot.child(nama10).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama10).setValue(2);
                                        else if (Integer.parseInt(KKT1.getText().toString()) < Integer.parseInt(snapshot.child(nama10).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama10).setValue(3);
                                        else if (Integer.parseInt(KKT1.getText().toString()) < Integer.parseInt(snapshot.child(nama10).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama10).setValue(4);
                                        else if (Integer.parseInt(KKT1.getText().toString()) > Integer.parseInt(snapshot.child(nama10).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama10).setValue(5);
                                    } else {
                                        if (Integer.parseInt(KKT1.getText().toString()) < Integer.parseInt(snapshot.child(nama10).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama10).setValue(5);
                                        else if (Integer.parseInt(KKT1.getText().toString()) < Integer.parseInt(snapshot.child(nama10).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama10).setValue(4);
                                        else if (Integer.parseInt(KKT1.getText().toString()) < Integer.parseInt(snapshot.child(nama10).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama10).setValue(3);
                                        else if (Integer.parseInt(KKT1.getText().toString()) < Integer.parseInt(snapshot.child(nama10).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama10).setValue(2);
                                        else if (Integer.parseInt(KKT1.getText().toString()) > Integer.parseInt(snapshot.child(nama10).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama10).setValue(1);
                                    }

                                }
                                else {
                                    if (snapshot.child(nama10).child("Kaidah").getValue().toString().equals("max")) {
                                    event.child(id).child(nama10).setValue(Integer.parseInt(KKT1.getText().toString()));
                                    }
                                    else{
                                        event.child(id).child(nama10).setValue(Integer.parseInt(KKT1.getText().toString())*-1);
                                    }

                                }

                                }

                                @Override
                                public void onCancelled (DatabaseError databaseError){

                                }


                        });




                    case 9:
                        if(TextUtils.isEmpty(KK91.getText().toString())){
                            DatabaseReference refd = mRootref.child("Nilai Real");

                            refd.addValueEventListener(new ValueEventListener() {


                                @Override
                                public void onDataChange(DataSnapshot snapshot) {

                                    //KK11.setHint(snapshot.child(id).child(nama1).getValue().toString());
                                    KK91.setText(snapshot.child(id).child(nama9).getValue().toString());
                                    KK81.setText(snapshot.child(id).child(nama8).getValue().toString());
                                    KK71.setText(snapshot.child(id).child(nama7).getValue().toString());
                                    KK61.setText(snapshot.child(id).child(nama6).getValue().toString());
                                    KK51.setText(snapshot.child(id).child(nama5).getValue().toString());
                                    KK41.setText(snapshot.child(id).child(nama4).getValue().toString());
                                    KK31.setText(snapshot.child(id).child(nama3).getValue().toString());
                                    KK21.setText(snapshot.child(id).child(nama2).getValue().toString());
                                    KK11.setText(snapshot.child(id).child(nama1).getValue().toString());


                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }


                            });}

                        else {
                            Real.child(id).child(nama8).setValue(KK91.getText().toString());
                        }
                        kriteria = mRootref.child("Kriteria");
                        kriteria.addValueEventListener(new ValueEventListener() {


                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                if (snapshot.child(nama9).child("Tipe Data").getValue().toString().equals("Kualitatif")) {

                                    if (snapshot.child(nama9).child("Kaidah").getValue().toString().equals("max")) {
                                        if (Integer.parseInt(KK91.getText().toString()) < Integer.parseInt(snapshot.child(nama9).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama9).setValue(1);
                                        else if (Integer.parseInt(KK91.getText().toString()) < Integer.parseInt(snapshot.child(nama9).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama9).setValue(2);
                                        else if (Integer.parseInt(KK91.getText().toString()) < Integer.parseInt(snapshot.child(nama9).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama9).setValue(3);
                                        else if (Integer.parseInt(KK91.getText().toString()) < Integer.parseInt(snapshot.child(nama9).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama9).setValue(4);
                                        else if (Integer.parseInt(KK91.getText().toString()) > Integer.parseInt(snapshot.child(nama9).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama9).setValue(5);
                                    } else {
                                        if (Integer.parseInt(KK91.getText().toString()) < Integer.parseInt(snapshot.child(nama9).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama9).setValue(5);
                                        else if (Integer.parseInt(KK91.getText().toString()) < Integer.parseInt(snapshot.child(nama9).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama9).setValue(4);
                                        else if (Integer.parseInt(KK91.getText().toString()) < Integer.parseInt(snapshot.child(nama9).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama9).setValue(3);
                                        else if (Integer.parseInt(KK91.getText().toString()) < Integer.parseInt(snapshot.child(nama9).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama9).setValue(2);
                                        else if (Integer.parseInt(KK91.getText().toString()) > Integer.parseInt(snapshot.child(nama9).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama9).setValue(1);
                                    }


                                }
                                else{
                                    if (snapshot.child(nama9).child("Kaidah").getValue().toString().equals("max")) {
                                        event.child(id).child(nama9).setValue(Integer.parseInt(KK91.getText().toString()));
                                    }
                                    else {
                                        event.child(id).child(nama9).setValue(Integer.parseInt(KK91.getText().toString()) * -1);

                                    }
                                    }

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }


                        });


                    case 8:
                        if(TextUtils.isEmpty(KK81.getText().toString())){
                            DatabaseReference refd = mRootref.child("Nilai Real");

                            refd.addValueEventListener(new ValueEventListener() {


                                @Override
                                public void onDataChange(DataSnapshot snapshot) {

                                    //KK11.setHint(snapshot.child(id).child(nama1).getValue().toString());
                                    KK81.setText(snapshot.child(id).child(nama8).getValue().toString());
                                    KK71.setText(snapshot.child(id).child(nama7).getValue().toString());
                                    KK61.setText(snapshot.child(id).child(nama6).getValue().toString());
                                    KK51.setText(snapshot.child(id).child(nama5).getValue().toString());
                                    KK41.setText(snapshot.child(id).child(nama4).getValue().toString());
                                    KK31.setText(snapshot.child(id).child(nama3).getValue().toString());
                                    KK21.setText(snapshot.child(id).child(nama2).getValue().toString());
                                    KK11.setText(snapshot.child(id).child(nama1).getValue().toString());


                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }


                            });}

                        else {
                            Real.child(id).child(nama8).setValue(KK81.getText().toString());
                        }

                        kriteria = mRootref.child("Kriteria");
                        kriteria.addValueEventListener(new ValueEventListener() {


                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                if (snapshot.child(nama8).child("Tipe Data").getValue().toString().equals("Kualitatif")) {


                                    if (snapshot.child(nama8).child("Kaidah").getValue().toString().equals("max")) {
                                        if (Integer.parseInt(KK81.getText().toString()) < Integer.parseInt(snapshot.child(nama8).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama8).setValue(1);
                                        else if (Integer.parseInt(KK81.getText().toString()) < Integer.parseInt(snapshot.child(nama8).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama8).setValue(2);
                                        else if (Integer.parseInt(KK81.getText().toString()) < Integer.parseInt(snapshot.child(nama8).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama8).setValue(3);
                                        else if (Integer.parseInt(KK81.getText().toString()) < Integer.parseInt(snapshot.child(nama8).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama8).setValue(4);
                                        else if (Integer.parseInt(KK81.getText().toString()) > Integer.parseInt(snapshot.child(nama8).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama8).setValue(5);
                                    } else {
                                        if (Integer.parseInt(KK81.getText().toString()) < Integer.parseInt(snapshot.child(nama8).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama8).setValue(5);
                                        else if (Integer.parseInt(KK81.getText().toString()) < Integer.parseInt(snapshot.child(nama8).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama8).setValue(4);
                                        else if (Integer.parseInt(KK81.getText().toString()) < Integer.parseInt(snapshot.child(nama8).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama8).setValue(3);
                                        else if (Integer.parseInt(KK81.getText().toString()) < Integer.parseInt(snapshot.child(nama8).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama8).setValue(2);
                                        else if (Integer.parseInt(KK81.getText().toString()) > Integer.parseInt(snapshot.child(nama8).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama8).setValue(1);
                                    }
                                }
                                else{
                                    if (snapshot.child(nama8).child("Kaidah").getValue().toString().equals("max")) {
                                        event.child(id).child(nama8).setValue(Integer.parseInt(KK81.getText().toString()));
                                    }
                                    else {
                                        event.child(id).child(nama8).setValue(Integer.parseInt(KK81.getText().toString()) * -1);

                                    }
                                }


                            }


                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }


                        });



                    case 7:
                        if(TextUtils.isEmpty(KK71.getText().toString())){
                            DatabaseReference refd = mRootref.child("Nilai Real");

                            refd.addValueEventListener(new ValueEventListener() {


                                @Override
                                public void onDataChange(DataSnapshot snapshot) {

                                    //KK11.setHint(snapshot.child(id).child(nama1).getValue().toString());
                                    KK71.setText(snapshot.child(id).child(nama7).getValue().toString());
                                    KK61.setText(snapshot.child(id).child(nama6).getValue().toString());
                                    KK51.setText(snapshot.child(id).child(nama5).getValue().toString());
                                    KK41.setText(snapshot.child(id).child(nama4).getValue().toString());
                                    KK31.setText(snapshot.child(id).child(nama3).getValue().toString());
                                    KK21.setText(snapshot.child(id).child(nama2).getValue().toString());
                                    KK11.setText(snapshot.child(id).child(nama1).getValue().toString());


                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }


                            });}

                        else {
                            Real.child(id).child(nama7).setValue(KK71.getText().toString());
                        }

                        kriteria = mRootref.child("Kriteria");

                        kriteria.addValueEventListener(new ValueEventListener() {


                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                if (snapshot.child(nama7).child("Tipe Data").getValue().toString().equals("Kualitatif")) {

                                    if (snapshot.child(nama7).child("Kaidah").getValue().toString().equals("max")) {
                                        if (Integer.parseInt(KK71.getText().toString()) < Integer.parseInt(snapshot.child(nama7).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama7).setValue(1);
                                        else if (Integer.parseInt(KK71.getText().toString()) < Integer.parseInt(snapshot.child(nama7).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama7).setValue(2);
                                        else if (Integer.parseInt(KK71.getText().toString()) < Integer.parseInt(snapshot.child(nama7).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama7).setValue(3);
                                        else if (Integer.parseInt(KK71.getText().toString()) < Integer.parseInt(snapshot.child(nama7).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama7).setValue(4);
                                        else if (Integer.parseInt(KK71.getText().toString()) > Integer.parseInt(snapshot.child(nama7).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama7).setValue(5);
                                    } else {
                                        if (Integer.parseInt(KK71.getText().toString()) < Integer.parseInt(snapshot.child(nama7).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama7).setValue(5);
                                        else if (Integer.parseInt(KK71.getText().toString()) < Integer.parseInt(snapshot.child(nama7).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama7).setValue(4);
                                        else if (Integer.parseInt(KK71.getText().toString()) < Integer.parseInt(snapshot.child(nama7).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama7).setValue(3);
                                        else if (Integer.parseInt(KK71.getText().toString()) < Integer.parseInt(snapshot.child(nama7).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama7).setValue(2);
                                        else if (Integer.parseInt(KK71.getText().toString()) > Integer.parseInt(snapshot.child(nama7).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama7).setValue(1);
                                    }
                                }
                                else{
                                    if (snapshot.child(nama7).child("Kaidah").getValue().toString().equals("max")) {
                                        event.child(id).child(nama7).setValue(Integer.parseInt(KK71.getText().toString()));
                                    }
                                    else {
                                        event.child(id).child(nama7).setValue(Integer.parseInt(KK71.getText().toString()) * -1);

                                    }

                                }

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }


                        });


                    case 6:


                        if(TextUtils.isEmpty(KK61.getText().toString())){
                            DatabaseReference refd = mRootref.child("Nilai Real");

                            refd.addValueEventListener(new ValueEventListener() {


                                @Override
                                public void onDataChange(DataSnapshot snapshot) {

                                    //KK11.setHint(snapshot.child(id).child(nama1).getValue().toString());
                                    KK61.setText(snapshot.child(id).child(nama6).getValue().toString());
                                    KK51.setText(snapshot.child(id).child(nama5).getValue().toString());
                                    KK41.setText(snapshot.child(id).child(nama4).getValue().toString());
                                    KK31.setText(snapshot.child(id).child(nama3).getValue().toString());
                                    KK21.setText(snapshot.child(id).child(nama2).getValue().toString());
                                    KK11.setText(snapshot.child(id).child(nama1).getValue().toString());


                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }


                            });}

                            else {
                            Real.child(id).child(nama6).setValue(KK61.getText().toString());
                        }


                        kriteria = mRootref.child("Kriteria");

                        kriteria.addValueEventListener(new ValueEventListener() {


                            @Override
                            public void onDataChange(DataSnapshot snapshot) {

                                if (snapshot.child(nama6).child("Tipe Data").getValue().toString().equals("Kualitatif")) {

                                    if (snapshot.child(nama6).child("Kaidah").getValue().toString().equals("max")) {
                                        if (Integer.parseInt(KK61.getText().toString()) < Integer.parseInt(snapshot.child(nama6).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama6).setValue(1);
                                        else if (Integer.parseInt(KK61.getText().toString()) < Integer.parseInt(snapshot.child(nama6).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama6).setValue(2);
                                        else if (Integer.parseInt(KK61.getText().toString()) < Integer.parseInt(snapshot.child(nama6).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama6).setValue(3);
                                        else if (Integer.parseInt(KK61.getText().toString()) < Integer.parseInt(snapshot.child(nama6).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama6).setValue(4);
                                        else if (Integer.parseInt(KK61.getText().toString()) > Integer.parseInt(snapshot.child(nama6).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama6).setValue(5);
                                    } else {
                                        if (Integer.parseInt(KK61.getText().toString()) < Integer.parseInt(snapshot.child(nama6).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama6).setValue(5);
                                        else if (Integer.parseInt(KK61.getText().toString()) < Integer.parseInt(snapshot.child(nama6).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama6).setValue(4);
                                        else if (Integer.parseInt(KK61.getText().toString()) < Integer.parseInt(snapshot.child(nama6).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama6).setValue(3);
                                        else if (Integer.parseInt(KK61.getText().toString()) < Integer.parseInt(snapshot.child(nama6).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama6).setValue(2);
                                        else if (Integer.parseInt(KK61.getText().toString()) > Integer.parseInt(snapshot.child(nama6).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama6).setValue(1);
                                    }
                                }
                                else{ if (snapshot.child(nama6).child("Kaidah").getValue().toString().equals("max")) {
                                    event.child(id).child(nama6).setValue(Integer.parseInt(KK61.getText().toString()));
                                }
                                else {
                                    event.child(id).child(nama6).setValue(Integer.parseInt(KK61.getText().toString()) * -1);

                                }

                                }

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }


                        });

                    case 5:


                        if(TextUtils.isEmpty(KK51.getText().toString())){
                            DatabaseReference refd = mRootref.child("Nilai Real");

                            refd.addValueEventListener(new ValueEventListener() {


                                @Override
                                public void onDataChange(DataSnapshot snapshot) {

                                    //KK11.setHint(snapshot.child(id).child(nama1).getValue().toString());
                                    KK51.setText(snapshot.child(id).child(nama5).getValue().toString());
                                    KK41.setText(snapshot.child(id).child(nama4).getValue().toString());
                                    KK31.setText(snapshot.child(id).child(nama3).getValue().toString());
                                    KK21.setText(snapshot.child(id).child(nama2).getValue().toString());
                                    KK11.setText(snapshot.child(id).child(nama1).getValue().toString());

                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }


                            });}

                            else {
                            Real.child(id).child(nama5).setValue(KK51.getText().toString());
                        }


                        kriteria = mRootref.child("Kriteria");

                        kriteria.addValueEventListener(new ValueEventListener() {


                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                if (snapshot.child(nama5).child("Tipe Data").getValue().toString().equals("Kualitatif")) {
                                    if (snapshot.child(nama5).child("Kaidah").getValue().toString().equals("max")) {
                                        if (Integer.parseInt(KK51.getText().toString()) < Integer.parseInt(snapshot.child(nama5).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama5).setValue(1);
                                        else if (Integer.parseInt(KK51.getText().toString()) < Integer.parseInt(snapshot.child(nama5).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama5).setValue(2);
                                        else if (Integer.parseInt(KK51.getText().toString()) < Integer.parseInt(snapshot.child(nama5).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama5).setValue(3);
                                        else if (Integer.parseInt(KK51.getText().toString()) < Integer.parseInt(snapshot.child(nama5).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama5).setValue(4);
                                        else if (Integer.parseInt(KK51.getText().toString()) > Integer.parseInt(snapshot.child(nama5).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama5).setValue(5);
                                    } else {
                                        if (Integer.parseInt(KK51.getText().toString()) < Integer.parseInt(snapshot.child(nama5).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama5).setValue(5);
                                        else if (Integer.parseInt(KK51.getText().toString()) < Integer.parseInt(snapshot.child(nama5).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama5).setValue(4);
                                        else if (Integer.parseInt(KK51.getText().toString()) < Integer.parseInt(snapshot.child(nama5).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama5).setValue(3);
                                        else if (Integer.parseInt(KK51.getText().toString()) < Integer.parseInt(snapshot.child(nama5).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama5).setValue(2);
                                        else if (Integer.parseInt(KK51.getText().toString()) > Integer.parseInt(snapshot.child(nama5).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama5).setValue(1);
                                    }

                                }
                                else{
                                    if (snapshot.child(nama5).child("Kaidah").getValue().toString().equals("max")) {
                                        event.child(id).child(nama5).setValue(Integer.parseInt(KK51.getText().toString()));
                                    }
                                    else {
                                        event.child(id).child(nama5).setValue(Integer.parseInt(KK51.getText().toString()) * -1);

                                    }

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }


                        });


                    case 4:


                        if(TextUtils.isEmpty(KK41.getText().toString())){
                            DatabaseReference refd = mRootref.child("Nilai Real");

                            refd.addValueEventListener(new ValueEventListener() {


                                @Override
                                public void onDataChange(DataSnapshot snapshot) {

                                    //KK11.setHint(snapshot.child(id).child(nama1).getValue().toString());
                                    //KK41.setText(snapshot.child(id).child(nama4).getValue().toString());
                                    KK41.setText(snapshot.child(id).child(nama4).getValue().toString());
                                    KK31.setText(snapshot.child(id).child(nama3).getValue().toString());
                                    KK21.setText(snapshot.child(id).child(nama2).getValue().toString());
                                    KK11.setText(snapshot.child(id).child(nama1).getValue().toString());


                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }


                            });}


                            else {Real.child(id).child(nama4).setValue(KK41.getText().toString());}



                        kriteria = mRootref.child("Kriteria");

                        kriteria.addValueEventListener(new ValueEventListener() {


                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                if (snapshot.child(nama4).child("Tipe Data").getValue().toString().equals("Kualitatif")) {
                                    if (snapshot.child(nama4).child("Kaidah").getValue().toString().equals("max")) {
                                        if (Integer.parseInt(KK41.getText().toString()) < Integer.parseInt(snapshot.child(nama4).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama4).setValue(1);
                                        else if (Integer.parseInt(KK41.getText().toString()) < Integer.parseInt(snapshot.child(nama4).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama4).setValue(2);
                                        else if (Integer.parseInt(KK41.getText().toString()) < Integer.parseInt(snapshot.child(nama4).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama4).setValue(3);
                                        else if (Integer.parseInt(KK41.getText().toString()) < Integer.parseInt(snapshot.child(nama4).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama4).setValue(4);
                                        else if (Integer.parseInt(KK41.getText().toString()) > Integer.parseInt(snapshot.child(nama4).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama4).setValue(5);
                                    } else {
                                        if (Integer.parseInt(KK41.getText().toString()) < Integer.parseInt(snapshot.child(nama4).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama4).setValue(5);
                                        else if (Integer.parseInt(KK41.getText().toString()) < Integer.parseInt(snapshot.child(nama4).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama4).setValue(4);
                                        else if (Integer.parseInt(KK41.getText().toString()) < Integer.parseInt(snapshot.child(nama4).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama4).setValue(3);
                                        else if (Integer.parseInt(KK41.getText().toString()) < Integer.parseInt(snapshot.child(nama4).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama4).setValue(2);
                                        else if (Integer.parseInt(KK41.getText().toString()) > Integer.parseInt(snapshot.child(nama4).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama4).setValue(1);
                                    }
                                }
                                else{
                                    if (snapshot.child(nama4).child("Kaidah").getValue().toString().equals("max")) {
                                        event.child(id).child(nama4).setValue(Integer.parseInt(KK41.getText().toString()));
                                    }
                                    else {
                                        event.child(id).child(nama4).setValue(Integer.parseInt(KK41.getText().toString()) * -1);

                                    }
                                }

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }


                        });


                    case 3:


                        if(TextUtils.isEmpty(KK31.getText().toString())){
                            DatabaseReference refd = mRootref.child("Nilai Real");

                            refd.addValueEventListener(new ValueEventListener() {


                                @Override
                                public void onDataChange(DataSnapshot snapshot) {

                                    //KK11.setHint(snapshot.child(id).child(nama1).getValue().toString());
                                    KK31.setText(snapshot.child(id).child(nama3).getValue().toString());
                                    KK21.setText(snapshot.child(id).child(nama2).getValue().toString());
                                    KK11.setText(snapshot.child(id).child(nama1).getValue().toString());

                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }


                            });}

                            else {
                            Real.child(id).child(nama3).setValue(KK31.getText().toString());
                        }


                        kriteria = mRootref.child("Kriteria");

                        kriteria.addValueEventListener(new ValueEventListener() {


                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                if (snapshot.child(nama3).child("Tipe Data").getValue().toString().equals("Kualitatif")) {
                                    if (snapshot.child(nama3).child("Kaidah").getValue().toString().equals("max")) {
                                        if (Integer.parseInt(KK31.getText().toString()) < Integer.parseInt(snapshot.child(nama3).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama3).setValue(1);
                                        else if (Integer.parseInt(KK31.getText().toString()) < Integer.parseInt(snapshot.child(nama3).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama3).setValue(2);
                                        else if (Integer.parseInt(KK31.getText().toString()) < Integer.parseInt(snapshot.child(nama3).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama3).setValue(3);
                                        else if (Integer.parseInt(KK31.getText().toString()) < Integer.parseInt(snapshot.child(nama3).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama3).setValue(4);
                                        else if (Integer.parseInt(KK31.getText().toString()) > Integer.parseInt(snapshot.child(nama3).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama3).setValue(5);
                                    } else {
                                        if (Integer.parseInt(KK31.getText().toString()) < Integer.parseInt(snapshot.child(nama3).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama3).setValue(5);
                                        else if (Integer.parseInt(KK31.getText().toString()) < Integer.parseInt(snapshot.child(nama3).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama3).setValue(4);
                                        else if (Integer.parseInt(KK31.getText().toString()) < Integer.parseInt(snapshot.child(nama3).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama3).setValue(3);
                                        else if (Integer.parseInt(KK31.getText().toString()) < Integer.parseInt(snapshot.child(nama3).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama3).setValue(2);
                                        else if (Integer.parseInt(KK31.getText().toString()) > Integer.parseInt(snapshot.child(nama3).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama3).setValue(1);
                                    }

                                }
                                else{
                                    if (snapshot.child(nama3).child("Kaidah").getValue().toString().equals("max")) {
                                        event.child(id).child(nama3).setValue(Integer.parseInt(KK31.getText().toString()));
                                    }
                                    else {
                                        event.child(id).child(nama3).setValue(Integer.parseInt(KK31.getText().toString()) * -1);

                                    }
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }


                        });


                    case 2:

                        if(TextUtils.isEmpty(KK21.getText().toString())){
                            DatabaseReference refd = mRootref.child("Nilai Real");

                            refd.addValueEventListener(new ValueEventListener() {


                                @Override
                                public void onDataChange(DataSnapshot snapshot) {

                                    //KK11.setHint(snapshot.child(id).child(nama1).getValue().toString());
                                    KK21.setText(snapshot.child(id).child(nama2).getValue().toString());
                                    KK11.setText(snapshot.child(id).child(nama1).getValue().toString());


                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }


                            });}


                            else {Real.child(id).child(nama2).setValue(KK21.getText().toString());}




                        /*if(Integer.parseInt(KK21.getText().toString())<1000)
                            event.child(id).child(nama2).setValue(1);
                        else if(Integer.parseInt(KK21.getText().toString())<2000)
                            event.child(id).child(nama2).setValue(2);
                        else if(Integer.parseInt(KK21.getText().toString())<3000)
                            event.child(id).child(nama2).setValue(3);
                        else if(Integer.parseInt(KK21.getText().toString())<4000)
                            event.child(id).child(nama2).setValue(4);
                        else if(Integer.parseInt(KK21.getText().toString())>4000)
                            event.child(id).child(nama2).setValue(5);*/

                        kriteria = mRootref.child("Kriteria");

                        kriteria.addValueEventListener(new ValueEventListener() {


                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                if (snapshot.child(nama2).child("Tipe Data").getValue().toString().equals("Kualitatif")) {
                                    if (snapshot.child(nama2).child("Kaidah").getValue().toString().equals("max")) {
                                        if (Integer.parseInt(KK21.getText().toString()) < Integer.parseInt(snapshot.child(nama2).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama2).setValue(1);
                                        else if (Integer.parseInt(KK21.getText().toString()) < Integer.parseInt(snapshot.child(nama2).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama2).setValue(2);
                                        else if (Integer.parseInt(KK21.getText().toString()) < Integer.parseInt(snapshot.child(nama2).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama2).setValue(3);
                                        else if (Integer.parseInt(KK21.getText().toString()) < Integer.parseInt(snapshot.child(nama2).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama2).setValue(4);
                                        else if (Integer.parseInt(KK21.getText().toString()) > Integer.parseInt(snapshot.child(nama2).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama2).setValue(5);
                                    } else {
                                        if (Integer.parseInt(KK21.getText().toString()) < Integer.parseInt(snapshot.child(nama2).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama2).setValue(5);
                                        else if (Integer.parseInt(KK21.getText().toString()) < Integer.parseInt(snapshot.child(nama2).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama2).setValue(4);
                                        else if (Integer.parseInt(KK21.getText().toString()) < Integer.parseInt(snapshot.child(nama2).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama2).setValue(3);
                                        else if (Integer.parseInt(KK21.getText().toString()) < Integer.parseInt(snapshot.child(nama2).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama2).setValue(2);
                                        else if (Integer.parseInt(KK21.getText().toString()) > Integer.parseInt(snapshot.child(nama2).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama2).setValue(1);
                                    }

                                }
                                else{
                                    if (snapshot.child(nama2).child("Kaidah").getValue().toString().equals("max")) {
                                        event.child(id).child(nama2).setValue(Integer.parseInt(KK21.getText().toString()));
                                    }
                                    else {
                                        event.child(id).child(nama2).setValue(Integer.parseInt(KK21.getText().toString()) * -1);

                                    }

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }


                        });





                    case 1:


                        if(TextUtils.isEmpty(KK11.getText().toString())){
                            DatabaseReference refd = mRootref.child("Nilai Real");

                            refd.addValueEventListener(new ValueEventListener() {


                                @Override
                                public void onDataChange(DataSnapshot snapshot) {

                                    //KK11.setHint(snapshot.child(id).child(nama1).getValue().toString());
                                    KK11.setText(snapshot.child(id).child(nama1).getValue().toString());


                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }


                            });}

                            else{Real.child(id).child(nama1).setValue(KK11.getText().toString());}



                        kriteria = mRootref.child("Kriteria");

                        kriteria.addValueEventListener(new ValueEventListener() {


                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                if (snapshot.child(nama1).child("Tipe Data").getValue().toString().equals("Kualitatif")) {
                                    if (snapshot.child(nama1).child("Kaidah").getValue().toString().equals("max")) {
                                        if (Integer.parseInt(KK11.getText().toString()) < Integer.parseInt(snapshot.child(nama1).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama1).setValue(1);
                                        else if (Integer.parseInt(KK11.getText().toString()) < Integer.parseInt(snapshot.child(nama1).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama1).setValue(2);
                                        else if (Integer.parseInt(KK11.getText().toString()) < Integer.parseInt(snapshot.child(nama1).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama1).setValue(3);
                                        else if (Integer.parseInt(KK11.getText().toString()) < Integer.parseInt(snapshot.child(nama1).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama1).setValue(4);
                                        else if (Integer.parseInt(KK11.getText().toString()) > Integer.parseInt(snapshot.child(nama1).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama1).setValue(5);
                                    } else {
                                        if (Integer.parseInt(KK11.getText().toString()) < Integer.parseInt(snapshot.child(nama1).child("Batas").child("BatasI").getValue().toString()))
                                            event.child(id).child(nama1).setValue(5);
                                        else if (Integer.parseInt(KK11.getText().toString()) < Integer.parseInt(snapshot.child(nama1).child("Batas").child("BatasII").getValue().toString()))
                                            event.child(id).child(nama1).setValue(4);
                                        else if (Integer.parseInt(KK11.getText().toString()) < Integer.parseInt(snapshot.child(nama1).child("Batas").child("BatasIII").getValue().toString()))
                                            event.child(id).child(nama1).setValue(3);
                                        else if (Integer.parseInt(KK11.getText().toString()) < Integer.parseInt(snapshot.child(nama1).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama1).setValue(2);
                                        else if (Integer.parseInt(KK11.getText().toString()) > Integer.parseInt(snapshot.child(nama1).child("Batas").child("BatasIV").getValue().toString()))
                                            event.child(id).child(nama1).setValue(1);
                                    }

                                }
                                else{
                                    if (snapshot.child(nama1).child("Kaidah").getValue().toString().equals("max")) {
                                        event.child(id).child(nama1).setValue(Integer.parseInt(KK11.getText().toString()));
                                    }
                                    else {
                                        event.child(id).child(nama1).setValue(Integer.parseInt(KK11.getText().toString()) * -1);

                                    }

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }


                        });



                }


                finish();
                startActivity(new Intent(EditKecamatanActivity.this, SetKecamatanActivity.class));
            }
        });
    }


}
