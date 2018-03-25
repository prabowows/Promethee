package com.example.prabowo.promethee;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.example.prabowo.promethee.ListKecamatanSet.SetKecamatanActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mRootref = FirebaseDatabase.getInstance().getReference();;
    TableRow row;
    TableLayout tableLayout;
    Button Hapus,BTbatasatas,BTbatasbawah;
    ImageButton Tambah, TambahShow, HapusShow, Selesai, BThasil,BTeditV;
    EditText ETbatasbawah,ETbatasatas,editHapus, editTambah1, editTambah2, editTambah3, editBatas1, editBatas2,editGolongan1,editGolongan2,editGolongan3,editGolongan4;
    RadioButton CBmax,CBmin,CBkual,CBkuan;
    private static String a="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tableLayout = findViewById(R.id.tableLayoutMenu);
        row = (TableRow) getLayoutInflater().inflate(R.layout.activity_menu_row, null);
        BTeditV = findViewById(R.id.buttonEdit);
        BThasil = findViewById(R.id.buttonHasil);
        Hapus = findViewById(R.id.buttonHapus);
        Selesai = findViewById(R.id.buttonSelesai);
        Tambah = findViewById(R.id.buttonTambah);
        editHapus = findViewById(R.id.editHapus);
        TambahShow = findViewById(R.id.buttonTambahShow);
        HapusShow = findViewById(R.id.buttonHapusShow);
        editTambah1 = findViewById(R.id.editTambah1);
        editTambah2 = findViewById(R.id.editTambah2);
        editTambah3 = findViewById(R.id.editTambah3);
        editBatas1 = findViewById(R.id.editBatas1);
        editBatas2 = findViewById(R.id.editBatas2);
        editGolongan1=findViewById(R.id.editGolongan1);
        editGolongan2=findViewById(R.id.editGolongan2);
        editGolongan3=findViewById(R.id.editGolongan3);
        editGolongan4=findViewById(R.id.editGolongan4);
        CBmax = findViewById(R.id.CBmax);
        CBmin = findViewById(R.id.CBmin);
        CBkual=findViewById(R.id.CBkual);
        CBkuan=findViewById(R.id.CBkuan);
        ETbatasatas=findViewById(R.id.ETbatasatas);
        ETbatasbawah=findViewById(R.id.ETbatasbawah);
        BTbatasatas=findViewById(R.id.BTbatasatas);
        BTbatasbawah=findViewById(R.id.BTbatasbawah);

        BTbatasatas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mRootref.child("Batas").child("Rawas").setValue(ETbatasatas.getText().toString());
                Toast.makeText(MainActivity.this, "Parameter Telah Diperbarui menjadi "+ ETbatasatas.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

        BTbatasbawah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mRootref.child("Batas").child("Wasiag").setValue(ETbatasbawah.getText().toString());
                Toast.makeText(MainActivity.this, "Parameter Telah Diperbarui menjadi "+ ETbatasbawah.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });


        HapusShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ETbatasatas.setVisibility(view.GONE);
                BTbatasatas.setVisibility(view.GONE);
                ETbatasbawah.setVisibility(view.GONE);
                BTbatasbawah.setVisibility(view.GONE);
                editTambah1.setVisibility(view.GONE);
                editTambah2.setVisibility(view.GONE);
                editTambah3.setVisibility(view.GONE);
                editBatas1.setVisibility(View.GONE);
                editBatas2.setVisibility(View.GONE);
                HapusShow.setVisibility(View.GONE);
                Tambah.setVisibility(View.GONE);
                TambahShow.setVisibility(View.VISIBLE);
                tableLayout.setVisibility(view.VISIBLE);
                editHapus.setVisibility(view.VISIBLE);
                Hapus.setVisibility(View.VISIBLE);
            }
        });

        BThasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(MainActivity.this, HasilAkhir.class));
            }
        });

        BTeditV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EditActivity.class));
            }
        });

        Selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(MainActivity.this, SetKecamatanActivity.class));

            }
        });

        Tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(editTambah1.getText().toString()) ||
                        TextUtils.isEmpty(editTambah2.getText().toString()) ||
                        TextUtils.isEmpty(editTambah3.getText().toString()) ||
                        TextUtils.isEmpty(editBatas1.getText().toString()) ||
                        TextUtils.isEmpty(editBatas2.getText().toString()) ||
                        TextUtils.isEmpty(editGolongan1.getText().toString())||
                        TextUtils.isEmpty(editGolongan2.getText().toString())||
                        TextUtils.isEmpty(editGolongan3.getText().toString())||
                        TextUtils.isEmpty(editGolongan4.getText().toString())){
                    Toast.makeText(MainActivity.this, "Lengkapi Data Dahulu", Toast.LENGTH_LONG).show();
                }

                else if (Integer.parseInt(editTambah2.getText().toString()) <= 100 && Integer.parseInt(editTambah2.getText().toString()) >= 0 && Integer.parseInt(editTambah3.getText().toString()) <= 6 && Integer.parseInt(editTambah3.getText().toString()) >= 1) {
                    if (Integer.parseInt(editTambah3.getText().toString()) == 4 || Integer.parseInt(editTambah3.getText().toString()) == 5)
                        TambahRow(editTambah1.getText().toString(), editTambah2.getText().toString(), editTambah3.getText().toString(), editBatas1.getText().toString(), editBatas2.getText().toString());
                    else if (Integer.parseInt(editTambah3.getText().toString()) == 1)
                        TambahRow(editTambah1.getText().toString(), editTambah2.getText().toString(), editTambah3.getText().toString(), "n/a", "n/a");
                    else
                        TambahRow(editTambah1.getText().toString(), editTambah2.getText().toString(), editTambah3.getText().toString(), editBatas1.getText().toString(), "n/a");
                    Tambah.setVisibility(View.GONE);
                    tableLayout.setVisibility(View.VISIBLE);
                    TambahShow.setVisibility(View.VISIBLE);
                    finish();
                    startActivity(getIntent());

                }



                else Toast.makeText(MainActivity.this, "Inputan salah", Toast.LENGTH_LONG).show();

            }
        });

        TambahShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ETbatasatas.setVisibility(view.GONE);
                BTbatasatas.setVisibility(view.GONE);
                ETbatasbawah.setVisibility(view.GONE);
                BTbatasbawah.setVisibility(view.GONE);
                CBkual.setVisibility(view.VISIBLE);
                CBkuan.setVisibility(view.VISIBLE);
                CBmax.setVisibility(view.VISIBLE);
                CBmin.setVisibility(view.VISIBLE);
                BTeditV.setVisibility(view.GONE);
                BThasil.setVisibility(view.GONE);
                Selesai.setVisibility(view.GONE);
                HapusShow.setVisibility(view.GONE);
                tableLayout.setVisibility(view.GONE);
                editHapus.setVisibility(view.GONE);
                TambahShow.setVisibility(View.GONE);
                Tambah.setVisibility(View.VISIBLE);
                Hapus.setVisibility(View.GONE);
                editTambah1.setVisibility(view.VISIBLE);
                editTambah2.setVisibility(view.VISIBLE);
                editTambah3.setVisibility(view.VISIBLE);
                editBatas1.setVisibility(View.VISIBLE);
                editBatas2.setVisibility(View.VISIBLE);
                editGolongan1.setVisibility(View.VISIBLE);
                editGolongan2.setVisibility(View.VISIBLE);
                editGolongan3.setVisibility(View.VISIBLE);
                editGolongan4.setVisibility(View.VISIBLE);
            }
        });
        Hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editHapus.getText().toString());
                HapusRow(a);
            }
        });


    }




    @Override
    public void onStart() {
        super.onStart();
        mRootref = FirebaseDatabase.getInstance().getReference();
        //mRootref.child("Kode").child("Row").setValue("1");



        DatabaseReference event2 = mRootref.child("Kode").child("Row");
        event2.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {




           if(dataSnapshot.getValue().toString().equals( "0")) {
               DatabaseReference event = mRootref.child("Kriteria");
               event.addListenerForSingleValueEvent(new ValueEventListener() {

                   @Override
                   public void onDataChange(DataSnapshot dataSnapshot) {
                       int countBatas = 0;
                       for (final DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                           String a = postSnapshot.getKey().toString();
                           String b = postSnapshot.child("Bobot" + a).getValue().toString();
                           String c = postSnapshot.child("Preferensi" + a).getValue().toString();
                           String d = postSnapshot.child("Batas1").getValue().toString();
                           String e = postSnapshot.child("Batas2").getValue().toString();
                           InsertRow(a, b, c, d, e);
                           switch (Integer.parseInt(c.toString())) {
                               case 1:
                                   break;
                               case 2:
                                   PreferensiActivity.batasPref[0][countBatas] = Integer.parseInt(d.toString());
                                   break;
                               case 3:
                                   PreferensiActivity.batasPref[1][countBatas] = Integer.parseInt(d.toString());
                                   break;
                               case 4:
                                   PreferensiActivity.batasPref[2][countBatas] = Integer.parseInt(d.toString());
                                   PreferensiActivity.batasPref[3][countBatas] = Integer.parseInt(e.toString());
                                   break;
                               case 5:
                                   PreferensiActivity.batasPref[5][countBatas] = Integer.parseInt(d.toString());
                                   PreferensiActivity.batasPref[4][countBatas] = Integer.parseInt(e.toString());
                                   break;
                               case 6:
                                   PreferensiActivity.batasPref[6][countBatas] = Integer.parseInt(d.toString());
                                   break;
                           }
                           countBatas++;
                           mRootref.child("Kode").child("Row").setValue("1");


                       }

                   }

                   @Override
                   public void onCancelled(DatabaseError databaseError) {
                   }

               });
           }
           else{
               finish();
               startActivity(getIntent());
               mRootref.child("Kode").child("Row").setValue("0");


           }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });


        }


    public void InsertRow(String kriteria, String bobot, String preferensi, String batas1, String batas2) {
        tableLayout = findViewById(R.id.tableLayoutMenu);
        row = (TableRow) getLayoutInflater().inflate(R.layout.activity_menu_row, null);

        ((TextView) row.findViewById(R.id.kriteria)).setText(kriteria);
        ((TextView) row.findViewById(R.id.bobot)).setText(bobot);
        ((TextView) row.findViewById(R.id.preferensi)).setText(preferensi);
        ((TextView) row.findViewById(R.id.batas1)).setText(batas1);
        ((TextView) row.findViewById(R.id.batas2)).setText(batas2);


        tableLayout.addView(row);

    }

    public void TambahRow(final String kriteria, String bobot, String preferensi, String batas1, String batas2) {
        tableLayout = findViewById(R.id.tableLayoutMenu);
        row = (TableRow) getLayoutInflater().inflate(R.layout.activity_menu_row, null);

        ((TextView) row.findViewById(R.id.kriteria)).setText(kriteria);
        ((TextView) row.findViewById(R.id.bobot)).setText(bobot);
        ((TextView) row.findViewById(R.id.preferensi)).setText(preferensi);
        ((TextView) row.findViewById(R.id.batas1)).setText(batas1);
        ((TextView) row.findViewById(R.id.batas2)).setText(batas2);


        tableLayout.addView(row);
        mRootref.child("Kriteria").child(kriteria).child("Bobot" + kriteria).setValue(bobot);
        mRootref.child("Kriteria").child(kriteria).child("Preferensi" + kriteria).setValue(preferensi);
        mRootref.child("Kriteria").child(kriteria).child("Batas1").setValue(batas1);
        mRootref.child("Kriteria").child(kriteria).child("Batas2").setValue(batas2);
        mRootref.child("Kriteria").child(kriteria).child("Batas").child("BatasI").setValue(editGolongan1.getText().toString());
        mRootref.child("Kriteria").child(kriteria).child("Batas").child("BatasII").setValue(editGolongan2.getText().toString());
        mRootref.child("Kriteria").child(kriteria).child("Batas").child("BatasIII").setValue(editGolongan3.getText().toString());
        mRootref.child("Kriteria").child(kriteria).child("Batas").child("BatasIV").setValue(editGolongan4.getText().toString());
        if(CBmax.isChecked()){
            mRootref.child("Kriteria").child(kriteria).child("Kaidah").setValue("max");
        }
        if(CBmin.isChecked()){
            mRootref.child("Kriteria").child(kriteria).child("Kaidah").setValue("min");
        }
        if(CBkual.isChecked()){
            mRootref.child("Kriteria").child(kriteria).child("Tipe Data").setValue("Kualitatif");
        }
        if(CBkuan.isChecked()){
            mRootref.child("Kriteria").child(kriteria).child("Tipe Data").setValue("Kuantitatif");
        }


        DatabaseReference event = mRootref.child("Kecamatan");
        event.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (final DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String a = postSnapshot.getKey().toString();
                    mRootref.child("Kecamatan").child(a).child(kriteria).setValue(0);
                    mRootref.child("Nilai Real").child(a).child(kriteria).setValue(0);


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });

    }

    public void HapusRow(int Row) {
        tableLayout = findViewById(R.id.tableLayoutMenu);
        row = (TableRow) getLayoutInflater().inflate(R.layout.activity_menu_row, null);
        TableRow row2 = (TableRow) tableLayout.getChildAt(Row);
        TextView text = (TextView) row2.getChildAt(0);
        final String text2 = text.getText().toString();
        mRootref.child("Kriteria").child(text2).getRef().removeValue();
        tableLayout.removeViewsInLayout(Row, 1);
        DatabaseReference event = mRootref.child("Kecamatan");
        event.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (final DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    postSnapshot.child(text2).getRef().removeValue();


                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });


        DatabaseReference event2 = mRootref.child("Nilai Real");
        event2.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (final DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    postSnapshot.child(text2).getRef().removeValue();


                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });

        finish();
        startActivity(getIntent());

    }


    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apa anda ingin keluar ?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) { finish(); System.exit(0);
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }

}


