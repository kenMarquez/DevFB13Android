package com.ken.lifecicle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MiInterfaz, View.OnClickListener {



    private EditText etExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("tag", "OnCreate");



    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView tvExemple = (TextView) findViewById(R.id.tv_example);
        tvExemple.setText("ASDAÑSDJASLÑKDJ \n asjdlaksdjlaks \n ahsdhaskd");

        etExample = (EditText) findViewById(R.id.et_example);


        Button btnExample = (Button) findViewById(R.id.btn_example);
        btnExample.setOnClickListener(this);


        Log.d("tag", "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("tag", "OnResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tag", "OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("tag", "OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("tag", "OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("tag", "OnDestroy");
    }


    @Override
    public void miAccion() {
        Log.d("tag", "miAccion");
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_example){

        }

        Log.d("tag", "contenido: " + etExample.getText().toString());

    }
}
