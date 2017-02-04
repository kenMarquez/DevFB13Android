package com.ken.devfb13;

import android.util.Log;

/**
 * Created by Ken on 02/02/17.
 */

public class Pikachu extends Pokemon {


    public Pikachu(String name, String tipo) {
        setNombre(name);
        setTipo(tipo);
    }

    public void impactrueno() {
        Log.d("myLog", "pikachu lanza impactrueno");
    }


}
