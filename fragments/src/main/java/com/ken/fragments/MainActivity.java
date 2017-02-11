package com.ken.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Conseguimos la orientación del dispositivo
         * si es 1 esta en vertical
         * 2 horizontal
         */
        int orientacion = getResources().getConfiguration().orientation;
        if (orientacion == 1) {
            View fragmento1 = findViewById(R.id.fragmento1);
            fragmento1.setVisibility(View.GONE);
        }


        changeFragment(new TercerFragment());


    }

    /**
     * Agregamos dinamicamente  fragmnet pasado como parametro
     *
     * @param fragment
     */
    public void changeFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }


}
