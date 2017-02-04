package com.ken.polimorfismo.models;

import android.util.Log;

/**
 * Created by Ken on 02/02/17.
 */

public class Charizard extends Pokemon {

    public Charizard(String name, String tipo) {
        setNombre(name);
        setTipo(tipo);
    }

    public void vuela() {
        Log.d("myLog", "Charizard esta volando");
    }
}
