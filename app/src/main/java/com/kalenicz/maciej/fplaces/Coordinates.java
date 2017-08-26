package com.kalenicz.maciej.fplaces;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by maciej on 18.08.2017.
 */

public class Coordinates extends RealmObject {

    @PrimaryKey
    private long added;

    public Coordinates(long added, String place, String description, String latitude, String longitude, String accuracy, String altitude) {
        this.added = added;
        this.place = place;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.accuracy = accuracy;
        this.altitude = altitude;
    }

    private String place;
    private String description;

    private String latitude;
    private String longitude;
    private String accuracy;
    private String altitude;

    public Coordinates() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

//    private static int lastContactId = 0;
//    public static List<Coordinates> createContactsList(int numContacts) {
//        List<Coordinates> contacts = new List<Coordinates>();
//
//        for (int i = 1; i <= numContacts; i++) {
//            contacts.add(new Coordinates("Person " + ++lastContactId, i <= numContacts / 2));
//        }
//
//        return contacts;
//    }
}
