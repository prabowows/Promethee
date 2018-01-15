package com.example.prabowo.promethee;

/**
 * Created by Prabowo on 26/04/2017.
 */

public class Koordinate {

    private double latitude;
    private double longitude;



    public Koordinate(Double latitude, Double longitude){
        this.latitude = latitude;
        this.longitude=longitude;

    }



    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }


}
