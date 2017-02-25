package com.ken.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CuartoFragment.OnFragment4InteractionListener {

    private CuartoFragment fragment;

    private static final String TAG_FRAGMENT_CUATRO = "fragment4";

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


//        changeFragment(new TercerFragment());

        fragment = CuartoFragment.newInstance("Texto Inicial");

        changeFragment(fragment, TAG_FRAGMENT_CUATRO);

    }

    @Override
    protected void onResume() {
        super.onResume();
//        fragment.getDatoInicial();
//        String datoInicial = fragment.datoInicial;
//        fragment.setDatoInicial("mandando datos desde la actividad");

        CuartoFragment fragment = (CuartoFragment)
                getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_CUATRO);

        if (fragment != null) {
            fragment.setDatoInicial("Mandando datos desde la actividad");
        }


    }

    /**
     * Agregamos dinamicamente  fragmnet pasado como parametro
     *
     * @param fragment
     */
    public void changeFragment(Fragment fragment, String tag) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, fragment, tag)
                .commit();
    }


    @Override
    public void onFragment4Interaction(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}
