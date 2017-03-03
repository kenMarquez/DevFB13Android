package com.ken.googlemaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        moveCamera(new LatLng(19.4175257, -99.1654135));
        addMarker(new LatLng(19.4175257, -99.1654135));
        addMarker(new LatLng(19.4175217, -99.1654535));
        addMarker(new LatLng(19.4175297, -99.1654555));

    }

    public void moveCamera(LatLng latLng) {
        map.moveCamera(
                CameraUpdateFactory.newLatLngZoom(latLng, 16));
    }

    public void addMarker(LatLng latLng) {
        map.addMarker(new MarkerOptions()
                .position(latLng)
                .title("Titulo")
                .snippet("Descripción"));
    }


}
