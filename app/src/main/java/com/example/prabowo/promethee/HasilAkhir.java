package com.example.prabowo.promethee;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.prabowo.promethee.ListKecamatanSet.SetKecamatanActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class HasilAkhir extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<LatLng> mListLatLngDanurejan = new ArrayList<>();
    private List<LatLng> mListLatLngWirobrajan = new ArrayList<>();
    private List<LatLng> mListLatLngGedongtengen = new ArrayList<>();
    private List<LatLng> mListLatLngGondokusuman = new ArrayList<>();
    private List<LatLng> mListLatLngDanurejan2 = new ArrayList<>();
    private List<LatLng> mListLatLngWirobrajan2 = new ArrayList<>();
    private List<LatLng> mListLatLngGedongtengen2 = new ArrayList<>();
    private List<LatLng> mListLatLngGondokusuman2 = new ArrayList<>();
    private List<LatLng> mListLatLngDanurejan3 = new ArrayList<>();
    private List<LatLng> mListLatLngWirobrajan3 = new ArrayList<>();
    private List<LatLng> mListLatLngGedongtengen3 = new ArrayList<>();
    private List<LatLng> mListLatLngGondokusuman3 = new ArrayList<>();

    private List<LatLng> mListLatLngGondomanan = new ArrayList<>();
    private List<LatLng> mListLatLngGondomanan2 = new ArrayList<>();
    private List<LatLng> mListLatLngGondomanan3 = new ArrayList<>();

    private List<LatLng> mListLatLngJetis = new ArrayList<>();
    private List<LatLng> mListLatLngJetis2 = new ArrayList<>();
    private List<LatLng> mListLatLngJetis3 = new ArrayList<>();

    private List<LatLng> mListLatLngKotagede = new ArrayList<>();
    private List<LatLng> mListLatLngKotagede2 = new ArrayList<>();
    private List<LatLng> mListLatLngKotagede3 = new ArrayList<>();

    private List<LatLng> mListLatLngKraton = new ArrayList<>();
    private List<LatLng> mListLatLngKraton2 = new ArrayList<>();
    private List<LatLng> mListLatLngKraton3 = new ArrayList<>();

    private List<LatLng> mListLatLngMantrijeron = new ArrayList<>();
    private List<LatLng> mListLatLngMantrijeron2 = new ArrayList<>();
    private List<LatLng> mListLatLngMantrijeron3 = new ArrayList<>();

    private List<LatLng> mListLatLngMergangsan = new ArrayList<>();
    private List<LatLng> mListLatLngMergangsan2 = new ArrayList<>();
    private List<LatLng> mListLatLngMergangsan3 = new ArrayList<>();

    private List<LatLng> mListLatLngNgampilan = new ArrayList<>();
    private List<LatLng> mListLatLngNgampilan2 = new ArrayList<>();
    private List<LatLng> mListLatLngNgampilan3 = new ArrayList<>();

    private List<LatLng> mListLatLngPakualaman = new ArrayList<>();
    private List<LatLng> mListLatLngPakualaman2 = new ArrayList<>();
    private List<LatLng> mListLatLngPakualaman3 = new ArrayList<>();

    private List<LatLng> mListLatLngTegalrejo = new ArrayList<>();
    private List<LatLng> mListLatLngTegalrejo2 = new ArrayList<>();
    private List<LatLng> mListLatLngTegalrejo3 = new ArrayList<>();

    private List<LatLng> mListLatLngUmbulharjo = new ArrayList<>();
    private List<LatLng> mListLatLngUmbulharjo2 = new ArrayList<>();
    private List<LatLng> mListLatLngUmbulharjo3 = new ArrayList<>();

    DatabaseReference mRootref = FirebaseDatabase.getInstance().getReference();
    private String alamat, warna;
    private String rank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_akhir);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        Bundle extras = getIntent().getExtras();
        String Koordinat = extras.getString("Koordinat");

        // Add a marker in Sydney and move the camera
        if(Koordinat.equals("Gondokusuman")){
        LatLng Gondokusuman = new LatLng(-7.786141, 110.380372);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Gondokusuman, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.addMarker(new MarkerOptions().position(Gondokusuman).title(Koordinat));}

        if(Koordinat.equals("Danurejan")){
        LatLng Danurejan = new LatLng(-7.792714, 110.372069);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Danurejan , 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.addMarker(new MarkerOptions().position(Danurejan).title(Koordinat));}

        if(Koordinat.equals("Gedongtengen")){
        LatLng Gedongtengen = new LatLng(-7.791625, 110.361137);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Gedongtengen, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.addMarker(new MarkerOptions().position(Gedongtengen).title(Koordinat));}

        if(Koordinat.equals("Gondomanan")){
        LatLng Gondomanan = new LatLng(-7.801154, 110.367953);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Gondomanan, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.addMarker(new MarkerOptions().position(Gondomanan).title(Koordinat));}

        if(Koordinat.equals("Jetis")){
        LatLng Jetis = new LatLng(-7.782069, 110.364994);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Jetis, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.addMarker(new MarkerOptions().position(Jetis).title(Koordinat));}

        if(Koordinat.equals("Kotagede")){
        LatLng Kotagede = new LatLng(-7.816991, 110.398072);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Kotagede, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.addMarker(new MarkerOptions().position(Kotagede).title(Koordinat));}

        if(Koordinat.equals("Kraton")){
        LatLng Kraton = new LatLng(-7.808602, 110.362656);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Kraton, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.addMarker(new MarkerOptions().position(Kraton).title(Koordinat));}

        if(Koordinat.equals("Mantrijeron")){
        LatLng Mantrijeron = new LatLng(-7.818710, 110.359767);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Mantrijeron, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.addMarker(new MarkerOptions().position(Mantrijeron).title(Koordinat));}

        if(Koordinat.equals("Mergangsan")){
        LatLng Mergangsan = new LatLng(-7.814062, 110.372862);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Mergangsan, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.addMarker(new MarkerOptions().position(Mergangsan).title(Koordinat));}

        if(Koordinat.equals("Ngampilan")){
        LatLng Ngampilan = new LatLng(-7.798244, 110.358622);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Ngampilan, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.addMarker(new MarkerOptions().position(Ngampilan).title(Koordinat));}

        if(Koordinat.equals("Pakualaman")){
        LatLng Pakualaman = new LatLng(-7.799547, 110.376136);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Pakualaman, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.addMarker(new MarkerOptions().position(Pakualaman).title(Koordinat));}

        if(Koordinat.equals("Tegalrejo")){
        LatLng Tegalrejo = new LatLng(-7.781013, 110.354193);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Tegalrejo, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.addMarker(new MarkerOptions().position(Tegalrejo).title(Koordinat));}

        if(Koordinat.equals("Umbulharjo")){
        LatLng Umbulharjo = new LatLng(-7.815936, 110.385549);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Umbulharjo, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.addMarker(new MarkerOptions().position(Umbulharjo).title(Koordinat));}

        if(Koordinat.equals("Wirobrajan")){
        LatLng Wirobrajan = new LatLng(-7.802934, 110.350569);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Wirobrajan, 15));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.addMarker(new MarkerOptions().position(Wirobrajan).title(Koordinat));}
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney),18);


        // Instantiates a new Polyline object and adds points to define a rectangle



            DatabaseReference refd = mRootref.child("Kecamatan").child("Gondokusuman").child("Rangking");
            refd.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    rank = dataSnapshot.getValue().toString();

            if (Integer.parseInt(rank) <= 4 && Integer.parseInt(rank) >0) {

                DatabaseReference ref = mRootref.child("Peta").child("Gondokusuman").child("geometries").child("0").child("coordinates").child("0").child("0");

                ref.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            mListLatLngGondokusuman.add(new LatLng
                                    (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                            Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                        }


                        Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngGondokusuman).strokeColor(Color.RED));
                        //line.setPoints(mListLatLngGondokusuman);
                        //line.setFillColor(0x7F0000FF)//blue
                        //line.setFillColor(0x7F00FF00)//green;
                        line.setFillColor(0x7FFF0000);


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
            }

            if (Integer.parseInt(rank) <= 9 && Integer.parseInt(rank) > 4) {
                alamat = "Danurejan";

                DatabaseReference refx = mRootref.child("Peta").child("Gondokusuman").child("geometries").child("0").child("coordinates").child("0").child("0");


                refx.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            mListLatLngGondokusuman2.add(new LatLng
                                    (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                            Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                        }


                        Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngGondokusuman2).strokeColor(Color.BLUE));
                        line.setFillColor(0x7F0000FF);


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });

            }

                if (Integer.parseInt(rank) <= 14 && Integer.parseInt(rank) > 9) {

                    DatabaseReference refxx = mRootref.child("Peta").child("Gondokusuman").child("geometries").child("0").child("coordinates").child("0").child("0");

                    refxx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngGondokusuman3.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngGondokusuman3).strokeColor(Color.GREEN));
                            line.setFillColor(0x7F00FF00);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });


                }


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

          //DANUREJAN DANUREJAN DANUREJAN DANUREJAN DANUREJAN DANUREJAN DANUREJAN DANUREJAN DANUREJAN

        DatabaseReference refdd = mRootref.child("Kecamatan").child("Danurejan").child("Rangking");
        refdd.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rank = dataSnapshot.getValue().toString();

                if (Integer.parseInt(rank) <= 4 && Integer.parseInt(rank) >0) {

                    DatabaseReference ref = mRootref.child("Peta").child("Danurejan").child("geometries").child("0").child("coordinates").child("0").child("0");

                    ref.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngDanurejan.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngDanurejan).strokeColor(Color.RED));
                            line.setFillColor(0x7FFF0000);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });
                }

                if (Integer.parseInt(rank) <= 9 && Integer.parseInt(rank) > 4) {
                    alamat = "Danurejan";

                    DatabaseReference refx = mRootref.child("Peta").child("Danurejan").child("geometries").child("0").child("coordinates").child("0").child("0");


                    refx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngDanurejan2.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngDanurejan2).strokeColor(Color.BLUE));
                            line.setFillColor(0x7F0000FF);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });




                }

                if (Integer.parseInt(rank) <= 14 && Integer.parseInt(rank) > 9) {

                    DatabaseReference refxx = mRootref.child("Peta").child("Danurejan").child("geometries").child("0").child("coordinates").child("0").child("0");

                    refxx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngDanurejan3.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }

                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngDanurejan3).strokeColor(Color.GREEN));
                            line.setFillColor(0x7F00FF00);



                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //WIROBRAJAN //WIROBRAJAN //WIROBRAJAN //WIROBRAJAN //WIROBRAJAN //WIROBRAJAN //WIROBRAJAN //WIROBRAJAN


        DatabaseReference refds = mRootref.child("Kecamatan").child("Wirobrajan").child("Rangking");
        refds.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rank = dataSnapshot.getValue().toString();

                if (Integer.parseInt(rank) <= 4 && Integer.parseInt(rank) >0) {

                    DatabaseReference ref = mRootref.child("Peta").child("Wirobrajan").child("geometries").child("0").child("coordinates").child("0").child("0");

                    ref.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngWirobrajan.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngWirobrajan).strokeColor(Color.RED));
                            line.setFillColor(0x7FFF0000);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });
                }

                if (Integer.parseInt(rank) <= 9 && Integer.parseInt(rank) > 4) {
                    alamat = "Danurejan";

                    DatabaseReference refx = mRootref.child("Peta").child("Wirobrajan").child("geometries").child("0").child("coordinates").child("0").child("0");


                    refx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngWirobrajan2.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngWirobrajan2).strokeColor(Color.BLUE));
                            line.setFillColor(0x7F0000FF);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });

                }

                if (Integer.parseInt(rank) <= 14 && Integer.parseInt(rank) > 9) {

                    DatabaseReference refxx = mRootref.child("Peta").child("Wirobrajan").child("geometries").child("0").child("coordinates").child("0").child("0");

                    refxx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngWirobrajan3.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngWirobrajan3).strokeColor(Color.GREEN));
                            line.setFillColor(0x7F00FF00);



                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Gedongtengen Gedongtengen Gedongtengen Gedongtengen Gedongtengen Gedongtengen Gedongtengen Gedongtengen Gedongtengen Gedongtengen


        DatabaseReference refdf = mRootref.child("Kecamatan").child("Gedongtengen").child("Rangking");
        refdf.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rank = dataSnapshot.getValue().toString();

                if (Integer.parseInt(rank) <= 4 && Integer.parseInt(rank) >0) {

                    DatabaseReference ref = mRootref.child("Peta").child("Gedongtengen").child("geometries").child("0").child("coordinates").child("0").child("0");

                    ref.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngGedongtengen.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngGedongtengen).strokeColor(Color.RED));
                            line.setFillColor(0x7FFF0000);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });
                }

                if (Integer.parseInt(rank) <= 9 && Integer.parseInt(rank) > 4) {


                    DatabaseReference refx = mRootref.child("Peta").child("Gedongtengen").child("geometries").child("0").child("coordinates").child("0").child("0");


                    refx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngGedongtengen2.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngGedongtengen2).strokeColor(Color.BLUE));
                            line.setFillColor(0x7F0000FF);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });

                }

                if (Integer.parseInt(rank) <= 14 && Integer.parseInt(rank) > 9) {

                    DatabaseReference refxx = mRootref.child("Peta").child("Gedongtengen").child("geometries").child("0").child("coordinates").child("0").child("0");

                    refxx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngGedongtengen3.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }

                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngGedongtengen3).strokeColor(Color.GREEN));
                            line.setFillColor(0x7F00FF00);



                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //GONDOMANAN GONDOMANAN //GONDOMANAN GONDOMANAN //GONDOMANAN GONDOMANAN //GONDOMANAN GONDOMANAN //GONDOMANAN GONDOMANAN //GONDOMANAN GONDOMANAN


        DatabaseReference refff = mRootref.child("Kecamatan").child("Gondomanan").child("Rangking");
        refff.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rank = dataSnapshot.getValue().toString();

                if (Integer.parseInt(rank) <= 4 && Integer.parseInt(rank) >0) {

                    DatabaseReference ref = mRootref.child("Peta").child("Gondomanan").child("geometries").child("0").child("coordinates").child("0").child("0");

                    ref.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngGondomanan.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngGondomanan).strokeColor(Color.RED));
                            line.setFillColor(0x7FFF0000);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });
                }

                if (Integer.parseInt(rank) <= 9 && Integer.parseInt(rank) > 4) {


                    DatabaseReference refx = mRootref.child("Peta").child("Gondomanan").child("geometries").child("0").child("coordinates").child("0").child("0");


                    refx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngGondomanan2.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngGondomanan2).strokeColor(Color.BLUE));
                            line.setFillColor(0x7F0000FF);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });

                }

                if (Integer.parseInt(rank) <= 14 && Integer.parseInt(rank) > 9) {

                    DatabaseReference refxx = mRootref.child("Peta").child("Gondomanan").child("geometries").child("0").child("coordinates").child("0").child("0");

                    refxx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngGondomanan3.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngGondomanan3).strokeColor(Color.GREEN));
                            line.setFillColor(0x7F00FF00);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //JETIS JETIS //JETIS JETIS //JETIS JETIS //JETIS JETIS //JETIS JETIS //JETIS JETIS //JETIS JETIS


        DatabaseReference refffs = mRootref.child("Kecamatan").child("Jetis").child("Rangking");
        refffs.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rank = dataSnapshot.getValue().toString();

                if (Integer.parseInt(rank) <= 4 && Integer.parseInt(rank) >0) {

                    DatabaseReference ref = mRootref.child("Peta").child("Jetis").child("geometries").child("0").child("coordinates").child("0").child("0");

                    ref.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngJetis.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngJetis).strokeColor(Color.RED));
                            line.setFillColor(0x7FFF0000);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });
                }

                if (Integer.parseInt(rank) <= 9 && Integer.parseInt(rank) > 4) {


                    DatabaseReference refx = mRootref.child("Peta").child("Jetis").child("geometries").child("0").child("coordinates").child("0").child("0");


                    refx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngJetis2.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngJetis2).strokeColor(Color.BLUE));
                            line.setFillColor(0x7F0000FF);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });

                }

                if (Integer.parseInt(rank) <= 14 && Integer.parseInt(rank) > 9) {

                    DatabaseReference refxx = mRootref.child("Peta").child("Jetis").child("geometries").child("0").child("coordinates").child("0").child("0");

                    refxx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngJetis3.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngJetis3).strokeColor(Color.GREEN));
                            line.setFillColor(0x7F00FF00);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //KOTAGEDE KOTAGEDE //KOTAGEDE KOTAGEDE //KOTAGEDE KOTAGEDE //KOTAGEDE KOTAGEDE //KOTAGEDE KOTAGEDE //KOTAGEDE KOTAGEDE

        DatabaseReference reffs = mRootref.child("Kecamatan").child("Kotagede").child("Rangking");
        reffs.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rank = dataSnapshot.getValue().toString();

                if (Integer.parseInt(rank) <= 4 && Integer.parseInt(rank) >0) {

                    DatabaseReference ref = mRootref.child("Peta").child("Kotagede").child("geometries").child("0").child("coordinates").child("0").child("0");

                    ref.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngKotagede.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngKotagede).strokeColor(Color.RED));
                            line.setFillColor(0x7FFF0000);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });
                }

                if (Integer.parseInt(rank) <= 9 && Integer.parseInt(rank) > 4) {


                    DatabaseReference refx = mRootref.child("Peta").child("Kotagede").child("geometries").child("0").child("coordinates").child("0").child("0");


                    refx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngKotagede2.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngKotagede2).strokeColor(Color.BLUE));
                            line.setFillColor(0x7F0000FF);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });

                }

                if (Integer.parseInt(rank) <= 14 && Integer.parseInt(rank) > 9) {

                    DatabaseReference refxx = mRootref.child("Peta").child("Kotagede").child("geometries").child("0").child("coordinates").child("0").child("0");

                    refxx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngKotagede3.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngKotagede3).strokeColor(Color.GREEN));
                            line.setFillColor(0x7F00FF00);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //KRATON KRATON //KRATON KRATON //KRATON KRATON //KRATON KRATON //KRATON KRATON //KRATON KRATON //KRATON KRATON

        DatabaseReference refs = mRootref.child("Kecamatan").child("Kraton").child("Rangking");
        refs.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rank = dataSnapshot.getValue().toString();

                if (Integer.parseInt(rank) <= 4 && Integer.parseInt(rank) >0) {

                    DatabaseReference ref = mRootref.child("Peta").child("Kraton").child("geometries").child("0").child("coordinates").child("0").child("0");

                    ref.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngKraton.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngKraton).strokeColor(Color.RED));
                            line.setFillColor(0x7FFF0000);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });
                }

                if (Integer.parseInt(rank) <= 9 && Integer.parseInt(rank) > 4) {


                    DatabaseReference refx = mRootref.child("Peta").child("Kraton").child("geometries").child("0").child("coordinates").child("0").child("0");


                    refx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngKraton2.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngKraton2).strokeColor(Color.BLUE));
                            line.setFillColor(0x7F0000FF);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });

                }

                if (Integer.parseInt(rank) <= 14 && Integer.parseInt(rank) > 9) {

                    DatabaseReference refxx = mRootref.child("Peta").child("Kraton").child("geometries").child("0").child("coordinates").child("0").child("0");

                    refxx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngKraton3.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngKraton3).strokeColor(Color.GREEN));
                            line.setFillColor(0x7F00FF00);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Mantrijeron Mantrijeron //Mantrijeron Mantrijeron //Mantrijeron Mantrijeron //Mantrijeron Mantrijeron //Mantrijeron Mantrijeron


        DatabaseReference refxs = mRootref.child("Kecamatan").child("Mantrijeron").child("Rangking");
        refxs.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rank = dataSnapshot.getValue().toString();

                if (Integer.parseInt(rank) <= 4 && Integer.parseInt(rank) >0) {

                    DatabaseReference ref = mRootref.child("Peta").child("Mantrijeron").child("geometries").child("0").child("coordinates").child("0").child("0");

                    ref.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngMantrijeron.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngMantrijeron).strokeColor(Color.RED));
                            line.setFillColor(0x7FFF0000);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });
                }

                if (Integer.parseInt(rank) <= 9 && Integer.parseInt(rank) > 4) {


                    DatabaseReference refx = mRootref.child("Peta").child("Mantrijeron").child("geometries").child("0").child("coordinates").child("0").child("0");


                    refx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngMantrijeron2.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngMantrijeron2).strokeColor(Color.BLUE));
                            line.setFillColor(0x7F0000FF);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });

                }

                if (Integer.parseInt(rank) <= 14 && Integer.parseInt(rank) > 9) {

                    DatabaseReference refxx = mRootref.child("Peta").child("Mantrijeron").child("geometries").child("0").child("coordinates").child("0").child("0");

                    refxx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngMantrijeron3.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngMantrijeron3).strokeColor(Color.GREEN));
                            line.setFillColor(0x7F00FF00);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Mergangsan Mergangsan //Mergangsan Mergangsan //Mergangsan Mergangsan //Mergangsan Mergangsan //Mergangsan Mergangsan


        DatabaseReference resxs = mRootref.child("Kecamatan").child("Mergangsan").child("Rangking");
        resxs.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rank = dataSnapshot.getValue().toString();

                if (Integer.parseInt(rank) <= 4 && Integer.parseInt(rank) >0) {

                    DatabaseReference ref = mRootref.child("Peta").child("Mergangsan").child("geometries").child("0").child("coordinates").child("0").child("0");

                    ref.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngMergangsan.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngMergangsan).strokeColor(Color.RED));
                            line.setFillColor(0x7FFF0000);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });
                }

                if (Integer.parseInt(rank) <= 9 && Integer.parseInt(rank) > 4) {


                    DatabaseReference refx = mRootref.child("Peta").child("Mergangsan").child("geometries").child("0").child("coordinates").child("0").child("0");


                    refx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngMergangsan2.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngMergangsan2).strokeColor(Color.BLUE));
                            line.setFillColor(0x7F0000FF);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });

                }

                if (Integer.parseInt(rank) <= 14 && Integer.parseInt(rank) > 9) {

                    DatabaseReference refxx = mRootref.child("Peta").child("Mergangsan").child("geometries").child("0").child("coordinates").child("0").child("0");

                    refxx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngMergangsan3.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngMergangsan3).strokeColor(Color.GREEN));
                            line.setFillColor(0x7F00FF00);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Ngampilan Ngampilan //Ngampilan Ngampilan //Ngampilan Ngampilan //Ngampilan Ngampilan //Ngampilan Ngampilan


        DatabaseReference resss = mRootref.child("Kecamatan").child("Ngampilan").child("Rangking");
        resss.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rank = dataSnapshot.getValue().toString();

                if (Integer.parseInt(rank) <= 4 && Integer.parseInt(rank) >0) {

                    DatabaseReference ref = mRootref.child("Peta").child("Ngampilan").child("geometries").child("0").child("coordinates").child("0").child("0");

                    ref.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngNgampilan.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngNgampilan).strokeColor(Color.RED));
                            line.setFillColor(0x7FFF0000);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });
                }

                if (Integer.parseInt(rank) <= 9 && Integer.parseInt(rank) > 4) {


                    DatabaseReference refx = mRootref.child("Peta").child("Ngampilan").child("geometries").child("0").child("coordinates").child("0").child("0");


                    refx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngNgampilan2.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngNgampilan2).strokeColor(Color.BLUE));
                            line.setFillColor(0x7F0000FF);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });

                }

                if (Integer.parseInt(rank) <= 14 && Integer.parseInt(rank) > 9) {

                    DatabaseReference refxx = mRootref.child("Peta").child("Ngampilan").child("geometries").child("0").child("coordinates").child("0").child("0");

                    refxx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngNgampilan3.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }

                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngNgampilan3).strokeColor(Color.GREEN));
                            line.setFillColor(0x7F00FF00);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Pakualaman Pakualaman //Pakualaman Pakualaman //Pakualaman Pakualaman //Pakualaman Pakualaman


        DatabaseReference reds = mRootref.child("Kecamatan").child("Pakualaman").child("Rangking");
        reds.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rank = dataSnapshot.getValue().toString();

                if (Integer.parseInt(rank) <= 4 && Integer.parseInt(rank) >0) {

                    DatabaseReference ref = mRootref.child("Peta").child("Pakualaman").child("geometries").child("0").child("coordinates").child("0").child("0");

                    ref.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngPakualaman.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngPakualaman).strokeColor(Color.RED));
                            line.setFillColor(0x7FFF0000);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });
                }

                if (Integer.parseInt(rank) <= 9 && Integer.parseInt(rank) > 4) {


                    DatabaseReference refx = mRootref.child("Peta").child("Pakualaman").child("geometries").child("0").child("coordinates").child("0").child("0");


                    refx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngPakualaman2.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngPakualaman2).strokeColor(Color.BLUE));
                            line.setFillColor(0x7F0000FF);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });

                }

                if (Integer.parseInt(rank) <= 14 && Integer.parseInt(rank) > 9) {

                    DatabaseReference refxx = mRootref.child("Peta").child("Pakualaman").child("geometries").child("0").child("coordinates").child("0").child("0");

                    refxx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngPakualaman3.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngPakualaman3).strokeColor(Color.GREEN));
                            line.setFillColor(0x7F00FF00);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Tegalrejo Tegalrejo //Tegalrejo Tegalrejo //Tegalrejo Tegalrejo //Tegalrejo Tegalrejo //Tegalrejo Tegalrejo

        DatabaseReference redsd = mRootref.child("Kecamatan").child("Tegalrejo").child("Rangking");
        redsd.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rank = dataSnapshot.getValue().toString();

                if (Integer.parseInt(rank) <= 4 && Integer.parseInt(rank) >0) {

                    DatabaseReference ref = mRootref.child("Peta").child("Tegalrejo").child("geometries").child("0").child("coordinates").child("0").child("0");

                    ref.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngTegalrejo.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngTegalrejo).strokeColor(Color.RED));
                            line.setFillColor(0x7FFF0000);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });
                }

                if (Integer.parseInt(rank) <= 9 && Integer.parseInt(rank) > 4) {


                    DatabaseReference refx = mRootref.child("Peta").child("Tegalrejo").child("geometries").child("0").child("coordinates").child("0").child("0");


                    refx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngTegalrejo2.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngTegalrejo2).strokeColor(Color.BLUE));
                            line.setFillColor(0x7F0000FF);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });

                }

                if (Integer.parseInt(rank) <= 14 && Integer.parseInt(rank) > 9) {

                    DatabaseReference refxx = mRootref.child("Peta").child("Tegalrejo").child("geometries").child("0").child("coordinates").child("0").child("0");

                    refxx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngTegalrejo3.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngTegalrejo3).strokeColor(Color.GREEN));
                            line.setFillColor(0x7F00FF00);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Umbulharjo Umbulharjo //Umbulharjo Umbulharjo //Umbulharjo Umbulharjo //Umbulharjo Umbulharjo //Umbulharjo Umbulharjo


        DatabaseReference rrdsd = mRootref.child("Kecamatan").child("Umbulharjo").child("Rangking");
        rrdsd.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rank = dataSnapshot.getValue().toString();

                if (Integer.parseInt(rank) <= 4 && Integer.parseInt(rank) >0) {

                    DatabaseReference ref = mRootref.child("Peta").child("Umbulharjo").child("geometries").child("0").child("coordinates").child("0").child("0");

                    ref.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngUmbulharjo.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngUmbulharjo).strokeColor(Color.RED));
                            line.setFillColor(0x7FFF0000);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });
                }

                if (Integer.parseInt(rank) <= 9 && Integer.parseInt(rank) > 4) {


                    DatabaseReference refx = mRootref.child("Peta").child("Umbulharjo").child("geometries").child("0").child("coordinates").child("0").child("0");


                    refx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngUmbulharjo2.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngUmbulharjo2).strokeColor(Color.BLUE));
                            line.setFillColor(0x7F0000FF);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });

                }

                if (Integer.parseInt(rank) <= 14 && Integer.parseInt(rank) > 9) {

                    DatabaseReference refxx = mRootref.child("Peta").child("Umbulharjo").child("geometries").child("0").child("coordinates").child("0").child("0");

                    refxx.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                mListLatLngUmbulharjo3.add(new LatLng
                                        (Double.parseDouble(postSnapshot.child("1").getValue().toString()),
                                                Double.parseDouble(postSnapshot.child("0").getValue().toString())));

                            }


                            Polygon line = mMap.addPolygon(new PolygonOptions().addAll(mListLatLngUmbulharjo3).strokeColor(Color.GREEN));
                            line.setFillColor(0x7F00FF00);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }


                    });


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    public void onBackPressed() {
        finish();
        startActivity(new Intent(HasilAkhir.this, MainActivity.class));
    }


        }




