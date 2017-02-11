package com.ken.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Bundle extras = getIntent().getExtras();

        String clave = extras.getString(Constants.CLAVE_INTENT);
        String texto = extras.getString("saludo");


        Log.d("log", clave);
        Log.d("log", texto);


    }
}
