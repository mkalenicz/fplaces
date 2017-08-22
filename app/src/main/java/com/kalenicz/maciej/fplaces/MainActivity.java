package com.kalenicz.maciej.fplaces;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;


public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient mFusedLocationClient;
    public TextView mLatitudeText;
    public TextView mLongitudeText;
    public TextView mAccuracy;
    public TextView mAltitude;

    //private DataPicker InputWhen;
   // public EditText InputNamePlace;
   // public Button button;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);
        realm = Realm.getDefaultInstance();

        mLatitudeText = (TextView) findViewById((R.id.latTextView));
        mLongitudeText = (TextView) findViewById((R.id.lonTextView));
        mAccuracy = (TextView) findViewById((R.id.accTextView));
        mAltitude = (TextView) findViewById((R.id.altTextView));
      //  InputNamePlace = (EditText) findViewById(R.id.InputNamePlace);
    //    button = (Button) findViewById(R.id.button);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //saveToRealm();
////                Log.d("Tag", realm.where(Coordinates.class).findAll().toString());
//            }
//        });

    }

    public void onClickFab(View view) {
        AlertDialog.Builder alertDialogBuild = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuild.setTitle("Add new favorite place");

        View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_add, null, false);
        final EditText editText = (EditText) inflate.findViewById(R.id.input_note);
        alertDialogBuild.setView(inflate);

        alertDialogBuild.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getLastLocation();
                String place = editText.getText().toString();
                long now = System.currentTimeMillis();
                String latitude = mLatitudeText.getText().toString();
                String longitude = mLongitudeText.getText().toString();
                String accuracy = mAccuracy.getText().toString();
                String altitude = mAltitude.getText().toString();
                Coordinates coordinates = new Coordinates(now, place, latitude, longitude, accuracy, altitude);
                realm.beginTransaction();
                realm.copyToRealm(coordinates);
                realm.commitTransaction();
                Log.d("Tag", realm.where(Coordinates.class).findAll().toString());
                //saveToRealm();
                addNewNote(place);
                dialogInterface.dismiss();

            }
        });
        alertDialogBuild.show();

    }

    private void addNewNote(String input) {

    }

    private void getLastLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            //mLatitudeText.setText(String.format("Latitude: %1$,.5f", location.getLatitude()));
                            mLatitudeText.setText(String.format("%1$,.5f", location.getLatitude()));
                            mLongitudeText.setText(String.format("%1$,.5f", location.getLongitude()));
                            mAccuracy.setText(String.format("%1$,.5f ", location.getAccuracy()));
                            mAltitude.setText(String.format("%1$,.5f ", location.getAltitude()));
                        }

                    }
                });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length <= 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            finish();
            Toast.makeText(MainActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
        }
    }

//    private void saveToRealm() {
//        String place = InputNamePlace.getText().toString();
//        long now = System.currentTimeMillis();
//
//        Coordinates coordinates = new Coordinates(now, place, 2.2, 2.2, 2.2, 2.2);
//        realm.beginTransaction();
//        realm.copyToRealm(coordinates);
//        realm.commitTransaction();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.options_info:
                getLastLocation();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
