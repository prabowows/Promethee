package com.example.prabowo.promethee;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prabowo.promethee.ListKecamatanSet.ItemSetKecamatan;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.prabowo.promethee.ListKecamatanSet.SetKecamatanActivity.countKriteria;
import static com.example.prabowo.promethee.MultiKriteriaActivity.IndeksPreferensi;
import static com.example.prabowo.promethee.MultiKriteriaActivity.namaKecamatan;
import static com.example.prabowo.promethee.PreferensiActivity.arrPrefHd;
import static com.example.prabowo.promethee.PreferensiActivity.batasPref;
import static com.example.prabowo.promethee.PreferensiActivity.bobotKriteria;

public class ListviewHasilActivity extends AppCompatActivity {

    static String[] values = new String[14];
    ListView simpleList;
    DatabaseReference mRootref;
    String[] Kriteria = new String[10];
    double[] arrLeaving = new double[14];
    double[] arrEntering = new double[14];
    double[] arrNet = new double[14];

    int[][] arrNilai = new int[14][10];
    int[][][] arrPrefD = new int[14][14][10];
    int[] preferensiKriteria = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_hasil);
        simpleList = findViewById(R.id.simpleListView);

         simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(ListviewHasilActivity.this, "Anda ngeklik item" + item, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ListviewHasilActivity.this, HasilAkhir.class);
                intent.putExtra("Koordinat", item);
                startActivity(intent);

            }

        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mRootref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference event = mRootref;
        event.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Menghitung Jumlah Kriteria
                countKriteria = 0;
                for (final DataSnapshot postSnap : dataSnapshot.child("Kriteria").getChildren()) {
                    Kriteria[countKriteria] = postSnap.getKey().toString();
                    countKriteria++;
                }

                //memuat data kriteria beserta bobot dan tipe preferensinya
                int x = 0, y = 0, bobotCount = 0;

                for (final DataSnapshot postShot : dataSnapshot.child("Kriteria").getChildren()) {
                    String a = postShot.getKey().toString();
                    bobotKriteria[bobotCount] = Integer.parseInt(postShot.child("Bobot" + a).getValue().toString());
                    preferensiKriteria[bobotCount] = Integer.parseInt(postShot.child("Preferensi" + a).getValue().toString());
                    bobotCount++;

                }
                //Memuat nilai kecamatan
                for (final DataSnapshot postSnapshot : dataSnapshot.child("Kecamatan").getChildren()) {
                    namaKecamatan[x] = postSnapshot.getKey().toString();
                    for (final DataSnapshot postSnap : dataSnapshot.child("Kecamatan").child(postSnapshot.getKey().toString()).getChildren()) {
                        arrNilai[x][y] = Integer.parseInt(postSnap.getValue().toString());

                        y++;


                    }
                    y = 0;
                    x++;


                }

                for (int k = 0; k < countKriteria; k++) {
                    for (int l = 0; l < 14; l++) {
                        for (int m = 0; m < 14; m++) {
                            arrPrefD[l][m][k] = arrNilai[l][k] - arrNilai[m][k];
                        }
                    }
                }

                for (int k = countKriteria; k < 10; k++) {
                    for (int l = 0; l < 14; l++) {
                        for (int m = 0; m < 14; m++) {
                            arrPrefD[l][m][k] = 0;
                        }
                    }
                }
                //l adalah perpindahan kecamatan perb.1,m perpindahan kecamatan perb.2,k kriteria


                //Tipe Preferensi
                for (int a = 0; a < countKriteria; a++) {
                    switch (preferensiKriteria[a]) {
                        case 1:
                            for (int i = 0; i < 14; i++) {
                                for (int j = 0; j < 14; j++) {
                                    if (arrPrefD[i][j][a] <= 0)
                                        arrPrefHd[i][j][a] = 0;
                                    else arrPrefHd[i][j][a] = 1;
                                }
                            }
                            break;
                        case 2:
                            for (int i = 0; i < 14; i++) {
                                for (int j = 0; j < 14; j++) {
                                    if ((arrPrefD[i][j][a]) <= batasPref[0][a])
                                        arrPrefHd[i][j][a] = 0;
                                    else arrPrefHd[i][j][a] = 1;
                                }
                            }
                            break;
                        case 3:
                            for (int i = 0; i < 14; i++) {
                                for (int j = 0; j < 14; j++) {
                                    if (((arrPrefD[i][j][a]) <= batasPref[1][a]) && (arrPrefD[i][j][a]) > 0)
                                        arrPrefHd[i][j][a] = Math.abs(arrPrefD[i][j][a]) / batasPref[1][a];
                                    else if  ((arrPrefD[i][j][a]) > batasPref[1][a])
                                        arrPrefHd[i][j][a] = 1;
                                    else
                                        arrPrefHd[i][j][a] = 0;

                                }
                            }
                            break;
                        case 4:
                            for (int i = 0; i < 14; i++) {
                                for (int j = 0; j < 14; j++) {
                                    if ((arrPrefD[i][j][a]) <= batasPref[2][a])
                                        arrPrefHd[i][j][a] = 0;
                                    else if ((arrPrefD[i][j][a]) <= batasPref[3][a] && (arrPrefD[i][j][a]) > batasPref[2][a])
                                        arrPrefHd[i][j][a] = 0.5;
                                    else arrPrefHd[i][j][a] = 1;
                                }
                            }
                            break;

                        case 5:
                            for (int i = 0; i < 14; i++) {
                                for (int j = 0; j < 14; j++) {
                                    if ((arrPrefD[i][j][a]) <= batasPref[5][a])
                                        arrPrefHd[i][j][a] = 0;
                                    else if ((arrPrefD[i][j][a]) <= batasPref[4][a] && (arrPrefD[i][j][a]) > batasPref[5][a] )
                                        arrPrefHd[i][j][a] = (Math.abs((arrPrefD[i][j][a]) - batasPref[5][a])/(batasPref[4][a]-batasPref[5][a]));
                                    else arrPrefHd[i][j][a] = 1;
                                }
                            }
                            break;
                        case 6:
                            for (int i = 0; i < 14; i++) {
                                for (int j = 0; j < 14; j++) {
                                    if (Math.abs(arrPrefD[i][j][a]) <= 0)
                                        arrPrefHd[i][j][a] = 0;
                                    else
                                        arrPrefHd[i][j][a] = 1 - Math.pow(2.71828, -(arrPrefD[i][j][a] * arrPrefD[i][j][a]) / (2.0d * (batasPref[6][a] * batasPref[6][a])));

                                }
                            }
                            break;
                    }
                }
                for (int a = countKriteria; a < 10; a++) {
                    for (int i = 0; i < 14; i++) {
                        for (int j = 0; j < 14; j++) {
                            arrPrefHd[i][j][a] = 0;
                        }
                    }

                }

                //Indeks Preferensi
                for (int i = 0; i < 14; i++) {
                    for (int j = 0; j < 14; j++) {
                        IndeksPreferensi[i][j] = 0.0;
                        for (int k = 0; k < countKriteria; k++) {
                            IndeksPreferensi[i][j] = IndeksPreferensi[i][j] + (arrPrefHd[i][j][k] * (bobotKriteria[k] / 100.0d));
                        }
                        IndeksPreferensi[i][j] = (1.0d / countKriteria) * IndeksPreferensi[i][j];
                    }
                }

                //Entring Flow, Leaving Flow, Net Flow
                for (int i = 0; i < 14; i++) {
                    arrLeaving[i] = 0;
                    arrEntering[i] = 0;
                    for (int j = 0; j < 14; j++) {
                        arrLeaving[i] = arrLeaving[i] + IndeksPreferensi[i][j];
                        arrEntering[i] = arrEntering[i] + IndeksPreferensi[j][i];
                    }
                    arrLeaving[i] = (1 / 13.0d) * arrLeaving[i];
                    arrEntering[i] = (1 / 13.0d) * arrEntering[i];
                    arrNet[i] = arrLeaving[i] - arrEntering[i];
                    mRootref.child("Batas").child(namaKecamatan[i]).child("Netflow").setValue(String.format("%.3f",arrNet[i]));
                }

                //Promethee Ranking
                for (int i = 0; i < 14; i++) {

                    int pos = i;
                    for (int j = 0; j < 14; j++) {
                        if (arrNet[pos] < arrNet[j]) {
                            pos = j;
                        }
                    }
                    ListviewHasilActivity.values[i] = namaKecamatan[pos];

                    arrNet[pos] = -100000;
                }

                MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(getApplicationContext(), values);
                simpleList.setAdapter(adapter);

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });

    }

    private class MySimpleArrayAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final String[] values;

        public MySimpleArrayAdapter(Context context, String[] values) {
            super(context, R.layout.activity_item_listview_hasil, values);
            this.context = context;
            this.values = values;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View rowView = inflater.inflate(R.layout.activity_item_listview_hasil, parent, false);
            final TextView textView = (TextView) rowView.findViewById(R.id.textListviewHasil);
            final ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewhasil);
            textView.setText(values[position]);

            DatabaseReference event = mRootref.child("Batas");
            event.addListenerForSingleValueEvent(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                        Double netFlow = Double.parseDouble(dataSnapshot.child(values[position]).getValue().toString());

                    Float rawas = Float.parseFloat(dataSnapshot.child("Rawas").getValue().toString());
                    Float wasiag = Float.parseFloat(dataSnapshot.child("Wasiag").getValue().toString());



                    if (netFlow >= rawas ) {
                textView.setBackgroundResource(R.color.Merah);
                imageView.setBackgroundResource(R.color.Merah);

            } else if (netFlow < rawas && netFlow > wasiag)
                    {textView.setBackgroundResource(R.color.colorPrimary);
            imageView.setBackgroundResource(R.color.colorPrimary);}
            else if (netFlow <= wasiag) {textView.setBackgroundResource(R.color.Hijau);
            imageView.setBackgroundResource(R.color.Hijau);}



                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }

            });
            return rowView;
        }
    }
    public void onBackPressed() {
        finish();
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        startActivity(new Intent(ListviewHasilActivity.this, PrometheeRankingActivity.class));
        else startActivity(new Intent(ListviewHasilActivity.this, MainActivity.class));
    }

}
