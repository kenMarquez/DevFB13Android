package com.ken.googlemaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MapFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_fragment);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, new MapFragment())
                .commit();
    }
}
