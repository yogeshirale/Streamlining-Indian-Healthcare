package com.example.yogesh.life;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Google_Map extends FragmentActivity implements OnMapReadyCallback,LocationListener {

    private GoogleMap mMap;
    GPSTracker gps;
    double latitude;
    double longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google__map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Button b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Google_Map.this,"Unable to Load",Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        gps = new GPSTracker(Google_Map.this);
        if(gps.canGetLocation())
        {
            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
        }
        else
        {
            gps.showSettingsAlert();
        }
        LatLng sydney = new LatLng(18.553549, 73.937461);
        mMap.addMarker(new MarkerOptions().position(sydney).title("My location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
