package com.kalenicz.maciej.fplaces;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by maciej on 18.08.2017.
 */

public class Coordinates extends RealmObject {

    @PrimaryKey
    private long added;

    public Coordinates(long added, String place, String latitude, double longitude, double accuracy, double altitude) {
        this.added = added;
        this.place = place;
        this.latitude = latitude;
        this.longitude = longitude;
        this.accuracy = accuracy;
        this.altitude = altitude;
    }

    private String place;

    private String latitude;
    private double longitude;
    private double accuracy;
    private double altitude;

    public Coordinates() {
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getAdded() {
        return added;
    }

    public void setAdded(long added) {
        this.added = added;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }


}
